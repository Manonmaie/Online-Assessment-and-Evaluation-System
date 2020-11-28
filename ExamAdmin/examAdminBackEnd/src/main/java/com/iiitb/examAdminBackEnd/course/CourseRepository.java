package com.iiitb.examAdminBackEnd.course;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
	@Query(value="SELECT course_code FROM ea_course_master", nativeQuery=true)
	public List<String> findCourseCodes();
}

