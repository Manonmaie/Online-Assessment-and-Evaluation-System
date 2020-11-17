package com.urest.v1.authoring_module.qpack3;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Qpack3Repository extends CrudRepository<Qpack3, Integer>{
	Qpack3 findById(int id);
	
	
}
