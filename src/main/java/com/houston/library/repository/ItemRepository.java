package com.houston.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.houston.library.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
