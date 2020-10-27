package com.urest.v1.authoring_module.options;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface OptionsRepository extends CrudRepository<Options, Integer> {
}