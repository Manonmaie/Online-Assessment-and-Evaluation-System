package com.iiitb.evaluationBackend.examineeBatch;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExamineeBatchController {
	@Autowired
	private ExamineeBatchService examdriveService;
	
	@RequestMapping("/examdrives")
	public List<EvExamineeBatch> getAllExamDrives() {
		return examdriveService.getAllExamDrives();
	}
}
