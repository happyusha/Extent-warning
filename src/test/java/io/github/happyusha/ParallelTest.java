package io.github.happyusha;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

import org.testng.annotations.Test;

import io.github.happyusha.reporter.ExtentSparkReporter;

public class ParallelTest {
    @Test
    public void parallelTests() {
        ExtentReports extent = new ExtentReports();
        IntStream.range(0, 10000).parallel().forEach(x -> extent.createTest("Test").info(String.valueOf(x)));
    }

    @Test
    public void parallelTestsWithReporter() {
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(new ExtentSparkReporter(""));
        IntStream.range(0, 10000).parallel().forEach(x -> extent.createTest("Test").info(String.valueOf(x)));
    }

    @Test
    public void parallelLogs() {
        ExtentReports extent = new ExtentReports();
        ExtentTest test = extent.createTest("Test");
        IntStream.range(0, 10000).parallel().forEach(x -> test.info(String.valueOf(x)));
    }

    @Test
    public void parallelFlush() {
        ExtentReports extent = new ExtentReports();
        CompletableFuture
                .runAsync(() -> IntStream.range(0, 10000)
                        .forEach(x -> extent.createTest("Test" + x).info(String.valueOf(x))));
        CompletableFuture
                .runAsync(() -> IntStream.range(0, 10000).forEach(x -> extent.flush()));
    }
}
