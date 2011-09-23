package com.houston.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.houston.library.model.Item;

@Transactional
public interface ItemRepository extends CrudRepository<Item, Long> {

	@Query("select i FROM Item i LEFT JOIN FETCH i.comments c WHERE i.id = ?1")
	public Item findItemWithCommentsById(Long id);

	@Query("select DISTINCT i FROM Item i LEFT JOIN FETCH i.comments c")
	public List<Item> listItemsWithComments();
}
