package com.iiitb.assessmentBackEnd.examinee;

import org.springframework.data.repository.CrudRepository;

public interface ExamineeRepository extends CrudRepository<AsExaminee, Integer> {

	public AsExaminee findByExamineeCodeAndExamineePassword(String examineeCode, String examineePassword);
}
