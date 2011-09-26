package com.houston.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.apache.tapestry5.beaneditor.Validate;

@Entity
public class Item extends PersistentObject {

	@Validate("required")
	private String title;

	private boolean borrowed;

	private String description;

	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Comment> comments = new ArrayList<Comment>();

	public Item() {
	}

	public Item(String title, boolean borrowed, String description, List<Comment> comments) {
		super();
		this.title = title;
		this.borrowed = borrowed;
		this.description = description;
		this.comments = comments;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void addComment(Comment comment) {
		comment.setItem(this);
		this.comments.add(comment);

	}

}
