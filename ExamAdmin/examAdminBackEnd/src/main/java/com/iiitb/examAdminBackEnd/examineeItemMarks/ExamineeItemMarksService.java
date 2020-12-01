package com.iiitb.examAdminBackEnd.examineeItemMarks;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamineeItemMarksService {
	@Autowired
	private ExamineeItemMarksRepository examineeItemMarksRepository;
	
	public void addExamineeItemMarks(ExamineeItemMarks examineeItemMarks) {
		examineeItemMarksRepository.save(examineeItemMarks);
	}
	
	public Optional<ExamineeItemMarks> getExamineeItemMarks(int id){
		return examineeItemMarksRepository.findById(id);
	}
	
	public void addExamineeItemMarksBulk(List<ExamineeItemMarks> examineeItemMarks) {
		examineeItemMarksRepository.saveAll(examineeItemMarks);
	}
	
	public void deleteAll() {
		examineeItemMarksRepository.deleteAll();
	}
	
	public Optional<ExamineeItemMarks> getExamineeItemMarksByQpItemId(int qp_item_id, int examinee_batch_id){
		return examineeItemMarksRepository.getExamineeItemMarksByQpItemId(qp_item_id, examinee_batch_id);
	}
}
