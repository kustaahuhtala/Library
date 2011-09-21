package com.houston.library.pages.edit;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.houston.library.model.Item;
import com.houston.library.pages.Index;
import com.houston.library.repository.ItemRepository;

/**
 * Start page of application library.
 */
public class EditIndex {

	private static final Logger logger = LoggerFactory.getLogger(EditIndex.class);

	@Persist
	private Item item;

	@Inject
	@Autowired
	private ItemRepository itemRepository;

	@InjectPage
	private Index indexPage;

	public void onActivate(Long id) {
		if (id.equals(0L)) {
			item = new Item();
		} else {
			logger.debug("Finding item with id {}", id);
			item = itemRepository.findOne(id);
		}
	}

	public Index onSuccessFromCreateItem() {
		logger.debug("Success from create item form.");
		itemRepository.save(item);
		return indexPage;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
