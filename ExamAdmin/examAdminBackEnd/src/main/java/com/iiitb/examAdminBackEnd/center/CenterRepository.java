package com.iiitb.examAdminBackEnd.center;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CenterRepository extends CrudRepository<Center, Integer> {
	@Query(value="SELECT center_code FROM ea_center", nativeQuery=true)
	public List<String> findCenterCodes();
}
