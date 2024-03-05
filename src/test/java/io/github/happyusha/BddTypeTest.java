package io.github.happyusha;

import java.lang.reflect.Method;

import io.github.happyusha.gherkin.model.Asterisk;
import io.github.happyusha.gherkin.model.Background;
import io.github.happyusha.gherkin.model.But;
import io.github.happyusha.gherkin.model.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.happyusha.gherkin.model.And;
import io.github.happyusha.gherkin.model.Given;
import io.github.happyusha.gherkin.model.Scenario;
import io.github.happyusha.gherkin.model.ScenarioOutline;
import io.github.happyusha.gherkin.model.Then;
import io.github.happyusha.gherkin.model.When;

public class BddTypeTest {
    private ExtentReports extent() {
        return new ExtentReports();
    }

    @Test
    public void featureIsOfBddType(Method method) {
        ExtentTest feature = extent().createTest(Feature.class, method.getName());
        Assert.assertTrue(feature.getModel().isBDD());
        Assert.assertEquals(feature.getModel().getBddType(), Feature.class);
    }

    @Test
    public void scenarioIsOfBddTypeWithBddChild(Method method) {
        ExtentTest feature = extent().createTest(Feature.class, method.getName());
        ExtentTest scenario = feature.createNode(Scenario.class, "Scenario");
        Assert.assertTrue(scenario.getModel().isBDD());
        Assert.assertEquals(scenario.getModel().getBddType(), Scenario.class);
    }

    @Test
    public void scenarioOutlineIsOfBddTypeWithBddChild(Method method) {
        ExtentTest feature = extent().createTest(Feature.class, method.getName());
        ExtentTest scenarioOutline = feature.createNode(ScenarioOutline.class, "ScenarioOutline");
        Assert.assertTrue(scenarioOutline.getModel().isBDD());
        Assert.assertEquals(scenarioOutline.getModel().getBddType(), ScenarioOutline.class);
    }

    @Test
    public void andIsOfBddTypeWithBddChild(Method method) {
        ExtentTest feature = extent().createTest(Feature.class, method.getName());
        ExtentTest scenario = feature.createNode(Scenario.class, "Scenario");
        ExtentTest and = scenario.createNode(And.class, "And");
        Assert.assertTrue(and.getModel().isBDD());
        Assert.assertEquals(and.getModel().getBddType(), And.class);
    }

    @Test
    public void asteriskIsOfBddTypeWithBddChild(Method method) {
        ExtentTest feature = extent().createTest(Feature.class, method.getName());
        ExtentTest scenario = feature.createNode(Scenario.class, "Scenario");
        ExtentTest asterisk = scenario.createNode(Asterisk.class, "Asterisk");
        Assert.assertTrue(asterisk.getModel().isBDD());
        Assert.assertEquals(asterisk.getModel().getBddType(), Asterisk.class);
    }

    @Test
    public void backgroundIsOfBddTypeWithBddChild(Method method) {
        ExtentTest feature = extent().createTest(Feature.class, method.getName());
        ExtentTest scenario = feature.createNode(Scenario.class, "Scenario");
        ExtentTest background = scenario.createNode(Background.class, "Background");
        Assert.assertTrue(background.getModel().isBDD());
        Assert.assertEquals(background.getModel().getBddType(), Background.class);
    }

    @Test
    public void butIsOfBddTypeWithBddChild(Method method) {
        ExtentTest feature = extent().createTest(Feature.class, method.getName());
        ExtentTest scenario = feature.createNode(Scenario.class, "Scenario");
        ExtentTest but = scenario.createNode(But.class, "But");
        Assert.assertTrue(but.getModel().isBDD());
        Assert.assertEquals(but.getModel().getBddType(), But.class);
    }

    @Test
    public void givenIsOfBddTypeWithBddChild(Method method) {
        ExtentTest feature = extent().createTest(Feature.class, method.getName());
        ExtentTest scenario = feature.createNode(Scenario.class, "Scenario");
        ExtentTest given = scenario.createNode(Given.class, "Given");
        Assert.assertTrue(given.getModel().isBDD());
        Assert.assertEquals(given.getModel().getBddType(), Given.class);
    }

    @Test
    public void thenIsOfBddTypeWithBddChild(Method method) {
        ExtentTest feature = extent().createTest(Feature.class, method.getName());
        ExtentTest scenario = feature.createNode(Scenario.class, "Scenario");
        ExtentTest then = scenario.createNode(Then.class, "Then");
        Assert.assertTrue(then.getModel().isBDD());
        Assert.assertEquals(then.getModel().getBddType(), Then.class);
    }

    @Test
    public void whenIsOfBddTypeWithBddChild(Method method) {
        ExtentTest feature = extent().createTest(Feature.class, method.getName());
        ExtentTest scenario = feature.createNode(Scenario.class, "Scenario");
        ExtentTest when = scenario.createNode(When.class, "When");
        Assert.assertTrue(when.getModel().isBDD());
        Assert.assertEquals(when.getModel().getBddType(), When.class);
    }
}
