package com.houston.library.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.houston.library.model.Item;

@ContextConfiguration(locations = { "/META-INF/spring/applicationContext.xml" })
public class ItemPersistenceTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private ItemRepository repository;

	@Test
	public void shouldPersistItem() {
		Item item = new Item();
		item.setTitle("Title");
		item.setDescription("This is a description");
		Item savedItem = repository.save(item);

		Item retrievedItem = repository.findOne(savedItem.getId());

		assertThat(retrievedItem.getTitle(), is("Title"));

	}

}
