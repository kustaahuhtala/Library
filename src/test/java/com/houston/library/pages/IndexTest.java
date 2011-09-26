package com.houston.library.pages;

import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertNotNull;

import java.util.ArrayList;

import org.apache.tapestry5.dom.Document;
import org.mockito.Mock;
import org.testng.annotations.Test;

import com.formos.tapestry.testify.core.ForComponents;
import com.houston.library.model.Item;
import com.houston.library.repository.ItemRepository;
import com.houston.library.test.AbstractMyApplicationTest;

public class IndexTest extends AbstractMyApplicationTest {

	@ForComponents
	@Mock
	ItemRepository itemRepository;

	@Test
	public void sampleTest() {

		when(itemRepository.listItemsWithComments()).thenReturn(new ArrayList<Item>());
		Document page = tester.renderPage("Index");
		assertNotNull(page.getElementById("test"));
	}

}
