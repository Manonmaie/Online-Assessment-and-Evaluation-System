package com.iiitb.examAdminBackEnd.examinee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ExamineeRepository extends CrudRepository<Examinee, Integer> {

	@Query(value = "SELECT MAX(examinee_id) AS MaxId FROM ea_examinee", nativeQuery = true)
	Integer findMaxId();
}
