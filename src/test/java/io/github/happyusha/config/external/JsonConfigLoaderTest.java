package io.github.happyusha.config.external;

import java.io.File;
import java.io.FileNotFoundException;

import io.github.happyusha.reporter.configuration.ExtentSparkReporterConfig;
import io.github.happyusha.reporter.configuration.Protocol;
import io.github.happyusha.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsonConfigLoaderTest {
    private static final String JSON_FILE = "src/test/resources/config/spark-config.json";
    private static final String JSON_FILE_ENUM = "src/test/resources/config/spark-config_lowercase_enum.json";

    @Test
    public void jsonConfigTest() throws FileNotFoundException {
        ExtentSparkReporterConfig conf = ExtentSparkReporterConfig.builder().build();
        JsonConfigLoader<ExtentSparkReporterConfig> loader = new JsonConfigLoader<ExtentSparkReporterConfig>(conf,
                new File(JSON_FILE));
        loader.apply();
        Assert.assertEquals(conf.getCss(), "css1");
        Assert.assertEquals(conf.getDocumentTitle(), "Test1");
        Assert.assertEquals(conf.getEncoding(), "utf-8");
        Assert.assertEquals(conf.getReportName(), "Test2");
        Assert.assertEquals(conf.getTimeStampFormat(), "MMM dd, yyyy HH:mm:ss a");
        Assert.assertEquals(conf.getOfflineMode().booleanValue(), true);
        Assert.assertEquals(conf.getProtocol(), Protocol.HTTP);
        Assert.assertEquals(conf.getTheme(), Theme.STANDARD);
    }

    @Test
    public void jsonConfigLowerCaseEnumTest() throws FileNotFoundException {
        ExtentSparkReporterConfig conf = ExtentSparkReporterConfig.builder().build();
        JsonConfigLoader<ExtentSparkReporterConfig> loader = new JsonConfigLoader<ExtentSparkReporterConfig>(conf,
                new File(JSON_FILE_ENUM));
        loader.apply();
        Assert.assertEquals(conf.getProtocol(), Protocol.HTTP);
        Assert.assertEquals(conf.getTheme(), Theme.DARK);
    }
}
