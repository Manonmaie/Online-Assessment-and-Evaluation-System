package com.iiitb.examAdminBackEnd.examineeItemMarks;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ExamineeItemMarksRepository extends CrudRepository<ExamineeItemMarks, Integer> {
	@Query(nativeQuery = true, value = "select * from ea_examinee_item_marks where qp_item_id = :qp_item_id and examinee_batch_id = :examinee_batch_id")
	Optional<ExamineeItemMarks> getExamineeItemMarksByQpItemId(@Param("qp_item_id") int qp_item_id, @Param("examinee_batch_id") int examinee_batch_id);
}
