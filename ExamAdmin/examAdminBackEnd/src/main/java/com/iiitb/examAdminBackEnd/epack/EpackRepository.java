package com.iiitb.examAdminBackEnd.epack;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface EpackRepository extends CrudRepository<Epack, Integer>{
	public Optional<Epack> findBycenter_id(int center_id);
}
