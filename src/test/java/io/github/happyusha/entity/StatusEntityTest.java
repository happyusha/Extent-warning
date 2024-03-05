package io.github.happyusha.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.github.happyusha.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StatusEntityTest {

    private List<Status> randomHierarchy() {
        List<Status> list = Arrays.asList(Status.values());
        Collections.shuffle(list);
        return list;
    }

    @Test
    public void statusMax() {
        Assert.assertEquals(Status.max(randomHierarchy()), Status.FAIL);
    }

    @Test
    public void statusMin() {
        Assert.assertEquals(Status.min(randomHierarchy()), Status.INFO);
    }

    @Test
    public void statusHierarchy() {
        List<Status> list = Status.getResolvedHierarchy(randomHierarchy());
        Assert.assertTrue(list.get(0).equals(Status.INFO));
        Assert.assertTrue(list.get(Status.values().length - 1).equals(Status.FAIL));
    }

}
