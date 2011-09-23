package com.houston.library.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.houston.library.model.Comment;
import com.houston.library.model.Item;

@ContextConfiguration(locations = { "classpath:META-INF/spring/applicationContext-test.xml" })
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

	@Test
	public void shouldPersistItemWithComments() {
		Item item = new Item();
		item.setTitle("Title");
		Item savedItem = repository.save(item);

		// create comment
		Comment comment = new Comment();
		comment.setText("This is my comment");
		savedItem.addComment(comment);

		savedItem = repository.save(savedItem);

		// fetch once again

		Item itemWithComment = repository.findOne(savedItem.getId());
		assertThat(itemWithComment.getComments().size(), is(1));

	}

}
