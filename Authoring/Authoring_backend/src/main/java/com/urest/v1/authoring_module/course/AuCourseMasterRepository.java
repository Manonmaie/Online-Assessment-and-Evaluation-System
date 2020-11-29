package com.urest.v1.authoring_module.course;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuCourseMasterRepository extends CrudRepository<AuCourseMaster, Integer>{

}

