package com.urest.v1.authoring_module.item;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
	public List<Item> findByAuthorId(int qpId);
}