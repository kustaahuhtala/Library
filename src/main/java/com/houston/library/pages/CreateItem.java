package com.houston.library.pages;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.houston.library.model.Item;
import com.houston.library.repository.ItemRepository;

/**
 * Start page of application library.
 */
public class CreateItem {

	@Property
	private Item item;

	@Inject
	@Autowired
	private ItemRepository itemRepository;

	private Logger logger = LoggerFactory.getLogger(CreateItem.class);

	@InjectPage
	private Index indexPage;

	public Index onSuccessFromCreateItem() {
		itemRepository.save(item);
		logger.debug("Success from create item form.");
		return indexPage;
	}

}
