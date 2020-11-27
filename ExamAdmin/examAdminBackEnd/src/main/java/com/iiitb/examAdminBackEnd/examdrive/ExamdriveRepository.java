package com.iiitb.examAdminBackEnd.examdrive;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ExamdriveRepository extends CrudRepository<Examdrive, Integer>{
	@Query(value="SELECT examdrive_code FROM ea_examdrive", nativeQuery=true)
	public List<String> findExamdriveCodes();
}
