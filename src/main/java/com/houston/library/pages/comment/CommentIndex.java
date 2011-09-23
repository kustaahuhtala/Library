package com.houston.library.pages.comment;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;

import com.houston.library.model.Comment;
import com.houston.library.model.Item;
import com.houston.library.pages.Index;
import com.houston.library.repository.ItemRepository;

public class CommentIndex {

	@Inject
	@Autowired
	private ItemRepository repository;

	@InjectPage
	private Index indexPage;

	@Persist
	private Long itemId;

	@Property
	private Comment comment;

	public Index onSuccessFromCommentItem() {

		Item item = repository.findItemWithCommentsById(itemId);
		item.addComment(comment);

		repository.save(item);

		return indexPage;

	}

	public void onActivate(Long id) {
		itemId = id;
	}

}
