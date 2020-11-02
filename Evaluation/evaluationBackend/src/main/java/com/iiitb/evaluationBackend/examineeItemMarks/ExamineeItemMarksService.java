package com.iiitb.evaluationBackend.examineeItemMarks;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.evaluationBackend.response.EvResponse;
import com.iiitb.evaluationBackend.response.ResponseRepository;
import com.iiitb.evaluationBackend.examineeBatch.ExamineeBatchRepository;
import com.iiitb.evaluationBackend.itemMcqOptions.EvItemMcqOptions;

@Service
public class ExamineeItemMarksService {
	
	@Autowired
	private ExamineeItemMarksRepository examineeItemMarksRepository;
	
	@Autowired
	private ExamineeBatchRepository examineebatchRepository;
	
	@Autowired
	private ResponseRepository responseRepository;
	
	
	public EvExamineeItemMarks addMarks(EvExamineeItemMarks examineeItemMarks) {
//		EvExamineeItemMarks itemMarks = new EvExamineeItemMarks();
//		ExamineeItemMarksKey examineeMarksId = new ExamineeItemMarksKey(examineeItemMarks.getQpItemId().getQpItemId(),examineeItemMarks.getExamineeBatchId().getexaminee_batch_id());
//		itemMarks.setExamineeItemMarksId(examineeMarksId);
//		itemMarks.setExamineeItemMarks(10);
////		itemMarks.getQpItemId().setQpItemId(examineeItemMarks.getQpItemId().getQpItemId());
////		itemMarks.getExamineeBatchId().setexaminee_batch_id(examineeItemMarks.getExamineeBatchId().getexaminee_batch_id());
//		itemMarks.setQpItemId(examineeItemMarks.getQpItemId());
//		itemMarks.setExamineeBatchId(examineeItemMarks.getExamineeBatchId());
		examineeItemMarksRepository.save(examineeItemMarks);
		return examineeItemMarks;
	}
	
	public EvExamineeItemMarks getExamineeItemMarks(int qpItemId,int examineeBatchId) {
		ExamineeItemMarksKey examineeMarksId = new ExamineeItemMarksKey(qpItemId,examineeBatchId);
		return examineeItemMarksRepository.findByExamineeItemMarksId(examineeMarksId);
	}
	
	public Integer EvaluateQpItems(int examineeBatchId) {
		List<EvResponse>ResponseList = responseRepository.findByEvExamineeBatchExamineeBatchId(examineeBatchId);
		for(EvResponse response : ResponseList) {
			for(EvItemMcqOptions mcqOptions: response.getEvQpItem().getEvItemMcqOptionsList()) {
				if(response.getResponseText().compareTo(mcqOptions.getMcqOptionText())==0) {
					double marks = (response.getEvQpItem().getItemMarks())
							*(mcqOptions.getMcqOptionPercentage()/100);
					EvExamineeItemMarks itemMarks = new EvExamineeItemMarks();
					ExamineeItemMarksKey examineeMarksId = new ExamineeItemMarksKey(response.getEvQpItem().getQpItemId(),examineeBatchId);
					itemMarks.setExamineeItemMarksId(examineeMarksId);
					itemMarks.setExamineeItemMarks(marks);
					itemMarks.setQpItemId(response.getEvQpItem());
					itemMarks.setExamineeBatchId(response.getEvExamineeBatch());
					examineeItemMarksRepository.save(itemMarks);
				}
			}	
		}
		return 1;
	}
	
}
