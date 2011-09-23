package com.houston.library.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.houston.library.model.Comment;
import com.houston.library.model.Item;

@ContextConfiguration(locations = { "classpath:META-INF/spring/applicationContext-test.xml" })
public class ItemRepositoryTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private ItemRepository repository;

	@Test
	public void retrievesItemWithCommentsByID() {
		// Create item with 2 comments

		Item item = new Item();
		item.setTitle("Ant in action");

		for (int i = 0; i < 2; i++) {
			Comment comment = new Comment();
			comment.setDate(new Date());
			comment.setText("Comment # " + i);
			item.addComment(comment);
		}
		Item persistedItem = repository.save(item);

		// Fetch items...
		Item itemFromDB = repository.findItemWithCommentsById(persistedItem.getId());
		assertThat(itemFromDB.getComments().size(), is(2));
	}

	@Test
	public void retrieveListOfItemsWithComments() {
		// Create item with 2 comments
		for (int j = 0; j < 3; j++) {
			Item item = new Item();
			item.setTitle("Ant in action " + j);

			for (int i = 0; i < 2; i++) {
				Comment comment = new Comment();
				comment.setDate(new Date());
				comment.setText("Comment # " + i);
				item.addComment(comment);
			}
			repository.save(item);
		}
		// Insert additional item without comment

		Item item = new Item();
		item.setTitle("JBOSS SEAM");
		repository.save(item);

		// Fetch items...
		List<Item> listOfItems = repository.listItemsWithComments();
		assertThat(listOfItems.size(), is(4));
		assertThat(listOfItems.get(0).getComments().size(), is(2));

	}

}
