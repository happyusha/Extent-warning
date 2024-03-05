package io.github.happyusha.model.service;

import java.util.Calendar;
import java.util.List;

import io.github.happyusha.gherkin.model.IGherkinFormatterModel;
import io.github.happyusha.model.Log;
import io.github.happyusha.model.Test;
import io.github.happyusha.util.Assert;

public class TestService {
    public static Boolean testHasScreenCapture(Test test, Boolean deep) {
        if (deep) {
            Boolean hasScreenCapture = !test.getMedia().isEmpty()
                    || test.getLogs().stream().anyMatch(Log::hasMedia);
            if (!hasScreenCapture)
                hasScreenCapture = test.getChildren().stream().anyMatch(x -> testHasScreenCapture(x, deep));
            return hasScreenCapture;
        }
        return test.hasScreenCapture();
    }

    public static Test createTest(Class<? extends IGherkinFormatterModel> type, String name, String description) {
    	Assert.notEmpty(name, "Test name must not be null or empty");
        return Test.builder()
                .bddType(type)
                .name(name)
                .description(description)
                .endTime(Calendar.getInstance().getTime()).build();
    }

    public static Test createTest(String name, String description) {
        return createTest(null, name, description);
    }

    public static Test createTest(String name) {
        return createTest(name, null);
    }
    
    public static boolean deleteTest(List<Test> list, Test test) {
        boolean removed = list.removeIf(x -> x.getId() == test.getId());
        if (!removed)
            list.forEach(x -> deleteTest(x.getChildren(), test));
        return removed;
    }
}
