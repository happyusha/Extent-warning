package io.github.happyusha.entity;

import io.github.happyusha.model.Category;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CategoryEntityTest {

	@Test
	public void tagName() {
		final String name = "TagName";
		Category tag = new Category(name);
		Assert.assertEquals(tag.getName(), name);
	}
	
}
