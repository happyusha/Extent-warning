package io.github.happyusha;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.happyusha.markuputils.CodeLanguage;
import io.github.happyusha.markuputils.Markup;
import io.github.happyusha.markuputils.MarkupHelper;

public class ExtentTestGeneratedLogTest {

    private ExtentReports extent() {
        return new ExtentReports();
    }

    @Test
    public void generatedLogEmpty() {
        ExtentTest t = extent().createTest("Test")
                .generateLog(Status.PASS, "");
        Assert.assertTrue(t.getModel().hasAnyLog());
        Assert.assertTrue(!t.getModel().getGeneratedLog().isEmpty());
        Assert.assertEquals(t.getModel().getGeneratedLog().get(0).getDetails(), "");
    }

    @Test
    public void generatedLogDetails() {
        ExtentTest t = extent().createTest("Test")
                .generateLog(Status.PASS, "Details");
        Assert.assertTrue(t.getModel().hasAnyLog());
        Assert.assertTrue(!t.getModel().getGeneratedLog().isEmpty());
        Assert.assertEquals(t.getModel().getGeneratedLog().get(0).getDetails(), "Details");
    }

    @Test
    public void generatedLogMarkup() {
        String json = "{ 'key': 'value' }";
        Markup m = MarkupHelper.createCodeBlock(json, CodeLanguage.JSON);
        ExtentTest t = extent().createTest("Test")
                .generateLog(Status.PASS, m);
        Assert.assertTrue(t.getModel().hasAnyLog());
        Assert.assertTrue(!t.getModel().getGeneratedLog().isEmpty());
        Assert.assertTrue(t.getModel().getGeneratedLog().get(0).getDetails().contains("jsonTree"));
        Assert.assertTrue(t.getModel().getGeneratedLog().get(0).getDetails().contains("<script>"));
        Assert.assertTrue(t.getModel().getGeneratedLog().get(0).getDetails().contains("</script>"));
        Assert.assertTrue(t.getModel().getGeneratedLog().get(0).getDetails().contains("{ 'key': 'value' }"));
    }
}
