package com.houston.library.pages;

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

	public Iterable<Item> getItems() {
		return itemRepository.findAll();
	}

}
