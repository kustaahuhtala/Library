package com.houston.library.pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.dom.Document;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.func.Predicate;
import org.mockito.Mock;
import org.testng.annotations.Test;

import com.formos.tapestry.testify.core.ForComponents;
import com.houston.library.model.Comment;
import com.houston.library.model.Item;
import com.houston.library.repository.ItemRepository;
import com.houston.library.test.AbstractMyApplicationTest;

public class IndexTest extends AbstractMyApplicationTest {

	@ForComponents
	@Mock
	ItemRepository itemRepository;

	@Test
	public void listItems() {

		List<Item> items = createItems();

		when(itemRepository.listItemsWithComments()).thenReturn(items);
		Document page = tester.renderPage("Index");
		assertNotNull(page.getElementById("items"));

		Element tbody = page.getElementById("items").getElement(new Predicate<Element>() {
			public boolean accept(Element e) {
				return "tbody".equals(e.getName());
			}
		});

		assertThat(tbody.getChildren().size(), is(10));
	}

	private List<Item> createItems() {
		List<Item> list = new ArrayList<Item>();
		for (int i = 0; i < 10; i++) {
			List<Comment> comments = new ArrayList<Comment>();
			list.add(new Item("Title" + i, false, "Description", comments));
		}
		return list;
	}

}
