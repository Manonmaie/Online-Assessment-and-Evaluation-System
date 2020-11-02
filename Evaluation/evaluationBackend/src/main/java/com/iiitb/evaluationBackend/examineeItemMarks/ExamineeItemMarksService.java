package com.iiitb.evaluationBackend.examineeItemMarks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.evaluationBackend.examineeBatch.ExamineeBatchRepository;

@Service
public class ExamineeItemMarksService {
	
	@Autowired
	private ExamineeItemMarksRepository examineeItemMarksRepository;
	
	@Autowired
	private ExamineeBatchRepository examineebatchRepository;
	
	
	
	public EvExamineeItemMarks addMarks(EvExamineeItemMarks examineeItemMarks) {
		examineeItemMarksRepository.save(examineeItemMarks);
		return examineeItemMarks;
	}
	
}
