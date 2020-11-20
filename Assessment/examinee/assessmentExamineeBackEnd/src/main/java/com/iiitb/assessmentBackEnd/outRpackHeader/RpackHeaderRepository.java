package com.iiitb.assessmentBackEnd.outRpackHeader;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RpackHeaderRepository extends CrudRepository<OutRpackHeader, Integer> {

	List<OutRpackHeader> findByRpackStatus(String rpackStatus);
}
