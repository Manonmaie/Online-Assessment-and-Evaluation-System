package com.urest.v1.authoring_module.item;

import org.springframework.data.repository.CrudRepository;

import com.urest.v1.authoring_module.item.Item;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ItemRepository extends CrudRepository<Item, Integer> {
}