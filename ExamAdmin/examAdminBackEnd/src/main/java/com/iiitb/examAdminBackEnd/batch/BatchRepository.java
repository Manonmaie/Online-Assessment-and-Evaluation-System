package com.iiitb.examAdminBackEnd.batch;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BatchRepository extends CrudRepository<Batch, Integer>{
	public List<Batch> findByExamdriveExamdriveId(int id);
}
