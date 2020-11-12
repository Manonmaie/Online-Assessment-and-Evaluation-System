package com.urest.v1.authoring_module.qpack;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.urest.v1.authoring_module.qpack1.Qpack1;
import com.urest.v1.authoring_module.qpack2.Qpack2;


public interface QpackJoinRepository extends JpaRepository<Qpack1, Integer>{
	@Query("SELECT new Qpack1(q.question_paper_id, q.totalMarks) FROM questionPaper q")
	List<Qpack1> fetchData();
	
	@Query("SELECT new Qpack2(q.question_paper_id, i.itemId, i.itemText, i.marks, i.itemType, i.cgLvl) FROM Item i INNER JOIN questionPaperItem q on q.itemId = i.itemId")
	List<Qpack2> fetchQpack2Data();
	
}
