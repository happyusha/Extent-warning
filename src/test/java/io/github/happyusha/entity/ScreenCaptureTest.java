package io.github.happyusha.entity;

import io.github.happyusha.model.ScreenCapture;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScreenCaptureTest {

    @Test
    public void initWithAllEntitiesNull() {
        ScreenCapture capture = ScreenCapture.builder().build();
        Assert.assertNull(capture.getBase64());
        Assert.assertNull(capture.getPath());
        Assert.assertNull(capture.getResolvedPath());
        Assert.assertNull(capture.getTitle());
    }
}
