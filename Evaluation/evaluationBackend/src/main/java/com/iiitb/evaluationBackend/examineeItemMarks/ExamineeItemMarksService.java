package com.iiitb.evaluationBackend.examineeItemMarks;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.evaluationBackend.response.EvResponse;
import com.iiitb.evaluationBackend.response.ResponseRepository;
import com.iiitb.evaluationBackend.examineeBatch.EvExamineeBatch;
import com.iiitb.evaluationBackend.examineeBatch.ExamineeBatchRepository;
import com.iiitb.evaluationBackend.itemMcqOptions.EvItemMcqOptions;
import com.iiitb.evaluationBackend.itemTrueFalse.EvItemTrueFalse;

@Service
public class ExamineeItemMarksService {
	
	@Autowired
	private ExamineeItemMarksRepository examineeItemMarksRepository;
	
	@Autowired
	private ResponseRepository responseRepository;
	
	@Autowired
	private ExamineeBatchRepository examineeBatchRepository;
	
	
	public EvExamineeItemMarks addMarks(EvExamineeItemMarks examineeItemMarks) {
//		EvExamineeItemMarks itemMarks = new EvExamineeItemMarks();
//		ExamineeItemMarksKey examineeMarksId = new ExamineeItemMarksKey(examineeItemMarks.getQpItem().getQpItemId(),examineeItemMarks.getExamineeBatch().getexaminee_batch_id());
//		itemMarks.setExamineeItemMarksId(examineeMarksId);
//		itemMarks.setExamineeItemMarks(10);
////		itemMarks.getQpItemId().setQpItemId(examineeItemMarks.getQpItemId().getQpItemId());
////		itemMarks.getExamineeBatchId().setexaminee_batch_id(examineeItemMarks.getExamineeBatchId().getexaminee_batch_id());
//		itemMarks.setQpItem(examineeItemMarks.getQpItem());
//		itemMarks.setExamineeBatch(examineeItemMarks.getExamineeBatch());
		examineeItemMarksRepository.save(examineeItemMarks);
		return examineeItemMarks;
	}
	
	public EvExamineeItemMarks getExamineeItemMarks(int qpItemId,int examineeBatchId) {
		ExamineeItemMarksKey examineeMarksId = new ExamineeItemMarksKey(qpItemId,examineeBatchId);
		return examineeItemMarksRepository.findByExamineeItemMarksId(examineeMarksId);
	}
	
	public Integer Trigger(int examineeBatchId) {
		List<EvResponse>ResponseList = responseRepository.findByEvExamineeBatchExamineeBatchId(examineeBatchId);
		for(EvResponse response : ResponseList) {
			float marks = 0;
			EvExamineeItemMarks itemMarks = new EvExamineeItemMarks();
			ExamineeItemMarksKey examineeMarksId = new ExamineeItemMarksKey(response.getEvQpItem().getQpItemId(),examineeBatchId);
			itemMarks.setExamineeItemMarksId(examineeMarksId);
			itemMarks.setExamineeItemMarks(marks);
			itemMarks.setQpItem(response.getEvQpItem());
			itemMarks.setExamineeBatch(response.getEvExamineeBatch());
			examineeItemMarksRepository.save(itemMarks);
		}
		EvExamineeBatch examineeBatch = examineeBatchRepository.findByExamineeBatchId(examineeBatchId);
		if(ResponseList.size() != 0) {
			examineeBatch.setStatus_id("PENDING");
			examineeBatchRepository.save(examineeBatch);
		}
		else {
			examineeBatch.setStatus_id("ABANDONED");
			examineeBatchRepository.save(examineeBatch);
		}
		return 1;
	}
	
	public Integer EvaluateQpItems(int examineeBatchId) {
		List<EvResponse>ResponseList = responseRepository.findByEvExamineeBatchExamineeBatchId(examineeBatchId);
		EvExamineeBatch examineeBatch = examineeBatchRepository.findByExamineeBatchId(examineeBatchId);
		for(EvResponse response : ResponseList) {
			for(EvItemMcqOptions mcqOptions: response.getEvQpItem().getEvItemMcqOptionsList()) {
				if(response.getResponseText().compareTo(mcqOptions.getMcqOptionText())==0) {
					float currMarks = (float) ((response.getEvQpItem().getItemMarks())
							*(mcqOptions.getMcqOptionPercentage()/100));
					ExamineeItemMarksKey examineeMarksId = new ExamineeItemMarksKey(response.getEvQpItem().getQpItemId(),examineeBatchId);
					EvExamineeItemMarks itemMarks = examineeItemMarksRepository.findByExamineeItemMarksId(examineeMarksId);
					float prevMarks = itemMarks.getExamineeItemMarks();
					itemMarks.setExamineeItemMarks(prevMarks + currMarks);
					examineeItemMarksRepository.save(itemMarks);
				}
			}
			for(EvItemTrueFalse TorF: response.getEvQpItem().getEvItemTrueFalseList()) {
				if((response.getResponseText().compareTo("True")==0 && TorF.getTruePercentage()==100.0)
				 ||(response.getResponseText().compareTo("False")==0 && TorF.getTruePercentage()==0.0)) {
					float currMarks = (float) (response.getEvQpItem().getItemMarks());
					ExamineeItemMarksKey examineeMarksId = new ExamineeItemMarksKey(response.getEvQpItem().getQpItemId(),examineeBatchId);
					EvExamineeItemMarks itemMarks = examineeItemMarksRepository.findByExamineeItemMarksId(examineeMarksId);
					itemMarks.setExamineeItemMarks(currMarks);
					examineeItemMarksRepository.save(itemMarks);
				}
			}
			examineeBatch.setStatus_id("COMPLETED");
			examineeBatchRepository.save(examineeBatch);
		}
		return 1;
	}
	
}
