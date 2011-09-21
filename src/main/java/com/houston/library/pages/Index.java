package com.houston.library.pages;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;

import com.houston.library.model.Item;
import com.houston.library.repository.ItemRepository;

/**
 * Start page of application library.
 */
public class Index {

	@Property
	private Item item;

	@Autowired
	@Inject
	private ItemRepository itemRepository;

	@InjectPage
	private CreateItem createItem;

	public Iterable<Item> getItems() {
		return itemRepository.findAll();
	}

	@OnEvent("edit")
	public CreateItem edit(Long id) {
		createItem.setItem(itemRepository.findOne(id));
		return createItem;
	}

	@OnEvent("remove")
	public void remove(Long id) {
		itemRepository.delete(itemRepository.findOne(id));
	}

}
