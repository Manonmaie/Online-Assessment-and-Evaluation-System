package com.iiitb.evaluationBackend.examineeBatch;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamineeBatchService {
	@Autowired
	private ExamineeBatchRepository examdriveRepository;
	
	public List<EvExamineeBatch> getAllExamDrives() {
		List<EvExamineeBatch> examdrives = new ArrayList<>();
		examdriveRepository.findAll().forEach(examdrives::add);
		return examdrives;
	}
}

