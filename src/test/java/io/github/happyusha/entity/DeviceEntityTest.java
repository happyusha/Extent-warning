package io.github.happyusha.entity;

import io.github.happyusha.model.Device;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeviceEntityTest {

	@Test
	public void deviceName() {
		final String name = "DeviceName";
		Device author = new Device(name);
		Assert.assertEquals(author.getName(), name);
	}
	
}
