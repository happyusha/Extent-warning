package io.github.happyusha.entity;

import io.github.happyusha.model.Author;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorEntityTest {

	@Test
	public void authorName() {
		final String name = "Anshoo";
		Author author = new Author(name);
		Assert.assertEquals(author.getName(), name);
	}
	
}
