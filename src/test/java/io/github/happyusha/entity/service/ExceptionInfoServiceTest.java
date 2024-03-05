package io.github.happyusha.entity.service;

import org.testng.Assert;

import io.github.happyusha.model.ExceptionInfo;
import io.github.happyusha.model.service.ExceptionInfoService;

public class ExceptionInfoServiceTest {
    @org.testng.annotations.Test
    public void exceptionInfo() {
        RuntimeException ex = new RuntimeException("ERROR");
        ExceptionInfo info = ExceptionInfoService.createExceptionInfo(ex);
        Assert.assertEquals(info.getException(), ex);
        Assert.assertEquals(info.getName(), "java.lang.RuntimeException");
    }
}
