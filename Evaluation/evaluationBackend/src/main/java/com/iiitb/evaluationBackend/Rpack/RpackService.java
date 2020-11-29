package com.iiitb.evaluationBackend.Rpack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.evaluationBackend.examineeBatch.EvExamineeBatch;
import com.iiitb.evaluationBackend.examineeBatch.ExamineeBatchService;
import com.iiitb.evaluationBackend.itemMcqOptions.EvItemMcqOptions;
import com.iiitb.evaluationBackend.itemMcqOptions.ItemMcqOptionsService;
import com.iiitb.evaluationBackend.itemTrueFalse.EvItemTrueFalse;
import com.iiitb.evaluationBackend.itemTrueFalse.ItemTrueFalseService;
import com.iiitb.evaluationBackend.qpItem.EvQpItem;
import com.iiitb.evaluationBackend.qpItem.QpItemService;
import com.iiitb.evaluationBackend.questionPaper.EvQuestionPaper;
import com.iiitb.evaluationBackend.questionPaper.QuestionPaperService;
import com.iiitb.evaluationBackend.response.EvResponse;
import com.iiitb.evaluationBackend.response.ResponseService;
import com.iiitb.evaluationBackend.responseMcq.EvResponseMcq;
import com.iiitb.evaluationBackend.responseMcq.ResponseMcqService;

@Service
public class RpackService {
	@Autowired
	private RpackRepository rpackRepository;
	
	@Autowired
	private QuestionPaperService questionPaperService;
	
	@Autowired
	private QpItemService qpItemService;
	
	@Autowired
	private ItemMcqOptionsService itemMcqOptionsService;
	
	@Autowired
	private ItemTrueFalseService itemTrueFalseService;
	
	@Autowired
	private ExamineeBatchService examineeBatchService; 
	
	@Autowired
	private ResponseService responseService;
	
	@Autowired
	private ResponseMcqService responseMcqService;
	
	
	public List<Rpack> getAllRpacks() {
		List<Rpack> rpacks = new ArrayList<>();
		rpackRepository.findAll().forEach(rpacks::add);
		return rpacks;
	}

	public void deleteRpack(int id) {
		rpackRepository.deleteById(id);
	}
	
	public Optional<Rpack> getRpack(int id){
		return rpackRepository.findById(id);
	}
	
	public void rpack2OriginalTables() {
		Map<Integer, EvQuestionPaper> id2Qp = new HashMap<Integer, EvQuestionPaper>();
		
		List<Object[]> qpObjects = rpackRepository.fetchQPdata();
		for(int i = 0; i < qpObjects.size(); i++) {
			EvQuestionPaper questionPaper = new EvQuestionPaper();
			questionPaper.setQpId((Integer)qpObjects.get(i)[0]);
			questionPaper.setMaximumMarks((double)(Float)qpObjects.get(i)[1]);
			questionPaper.setDuration((Integer)qpObjects.get(i)[2]);
			
			questionPaperService.addQuestionPaper(questionPaper);
			
			if(!id2Qp.containsKey(questionPaper.getQpId())) {
				id2Qp.put(questionPaper.getQpId(), questionPaper);
			}
		}
		
		Map<Integer, EvQpItem> id2QpItem = new HashMap<Integer, EvQpItem>();
		
		List<Object[]> qpItemObjects = rpackRepository.fetchQpItemData();
		for(int i = 0; i < qpItemObjects.size(); i++) {
			EvQpItem qpItem = new EvQpItem();
			qpItem.setQpItemId((Integer)qpItemObjects.get(i)[0]);
			qpItem.setItemText(String.valueOf(qpItemObjects.get(i)[1]));
			qpItem.setItemMarks((Float)qpItemObjects.get(i)[2]);
			qpItem.setItemType(String.valueOf(qpItemObjects.get(i)[3]));
			if(id2Qp.containsKey((Integer)qpItemObjects.get(i)[4])) {
				qpItem.setEvQuestionPaper(id2Qp.get((Integer)qpItemObjects.get(i)[4]));
			}
			qpItemService.addQpItem(qpItem);
			
			if(!id2QpItem.containsKey(qpItem.getQpItemId())) {
				id2QpItem.put(qpItem.getQpItemId(), qpItem);
			}
		}
		
		List<Object[]> itemOptionObjects = rpackRepository.fetchItemOptionsData();
		for(int i = 0; i < itemOptionObjects.size(); i++) {
			if(String.valueOf(itemOptionObjects.get(i)[2]).equals("True") || String.valueOf(itemOptionObjects.get(i)[2]).equals("False")) {
				EvItemTrueFalse itemTrueFalse = new EvItemTrueFalse();
				itemTrueFalse.setItemTrueFalseId((Integer)itemOptionObjects.get(i)[1]);
				itemTrueFalse.setQpItemId((Integer)itemOptionObjects.get(i)[0]);
				if(rpackRepository.fetchItemTFPercentData((Integer)itemOptionObjects.get(i)[0], (Integer)itemOptionObjects.get(i)[1], "True") != null) {
					itemTrueFalse.setTruePercentage((float)rpackRepository.fetchItemTFPercentData((Integer)itemOptionObjects.get(i)[0], (Integer)itemOptionObjects.get(i)[1], "True"));
				}
				if(rpackRepository.fetchItemTFPercentData((Integer)itemOptionObjects.get(i)[0], (Integer)itemOptionObjects.get(i)[1], "False") != null) {
					itemTrueFalse.setTruePercentage((float)rpackRepository.fetchItemTFPercentData((Integer)itemOptionObjects.get(i)[0], (Integer)itemOptionObjects.get(i)[1], "False"));
				}
//				if(String.valueOf(itemOptionObjects.get(i)[2]).equals("True")) {
//					itemTrueFalse.setTruePercentage((float)(Integer)itemOptionObjects.get(i)[2]);
//					itemTrueFalse.setFalsePercentage((float)(Integer)itemOptionObjects.get(i+1)[2]);
//				}
//				else {
//					itemTrueFalse.setFalsePercentage((float)(Integer)itemOptionObjects.get(i)[2]);
//					itemTrueFalse.setTruePercentage((float)(Integer)itemOptionObjects.get(i+1)[2]);
//				}
				i++;
				itemTrueFalseService.addItemTrueFalse(itemTrueFalse);
			}
			else {
				EvItemMcqOptions itemMcqOptions = new EvItemMcqOptions();
				itemMcqOptions.setItemMcqId((Integer)itemOptionObjects.get(i)[1]);
				if(id2QpItem.containsKey((Integer)itemOptionObjects.get(i)[0])) {
					itemMcqOptions.setEvQpItem(id2QpItem.get((Integer)itemOptionObjects.get(i)[0]));
				}
				itemMcqOptions.setMcqOptionText(String.valueOf(itemOptionObjects.get(i)[2]));
				if(rpackRepository.fetchItemMcqPercentData((Integer)itemOptionObjects.get(i)[0], (Integer)itemOptionObjects.get(i)[1]) != null) {
					itemMcqOptions.setMcqOptionPercentage(rpackRepository.fetchItemMcqPercentData((Integer)itemOptionObjects.get(i)[0], (Integer)itemOptionObjects.get(i)[1]));
				}
				itemMcqOptionsService.addItemMcqOptions(itemMcqOptions);
			}
		}
		
		Map<Integer, EvExamineeBatch> id2ExamineeBatch = new HashMap<Integer, EvExamineeBatch>();
		
		List<Integer> examineeBatchIds = rpackRepository.fetchExamineeBatchData();
		for(int i = 0; i < examineeBatchIds.size(); i++) {
			EvExamineeBatch examineeBatch = new EvExamineeBatch(examineeBatchIds.get(i), "PENDING");
			examineeBatchService.addExamineeBatch(examineeBatch);
			
			if(!id2ExamineeBatch.containsKey(examineeBatch.getexaminee_batch_id())) {
				id2ExamineeBatch.put(examineeBatch.getexaminee_batch_id(), examineeBatch);
			}
		}
		
		List<Object[]> responseObjects = rpackRepository.fetchResponseData();
		for(int i = 0; i < responseObjects.size(); i++) {
			EvResponse response = new EvResponse();
			if(id2ExamineeBatch.containsKey((Integer)responseObjects.get(i)[0])) {
				response.setEvExamineeBatch(id2ExamineeBatch.get((Integer)responseObjects.get(i)[0]));
			}
			
			if(id2QpItem.containsKey((Integer)responseObjects.get(i)[1])) {
				response.setEvQpItem(id2QpItem.get((Integer)responseObjects.get(i)[1]));
			}
			response.setResponseId((Integer)responseObjects.get(i)[2]);
			response.setResponseText(String.valueOf(responseObjects.get(i)[3]));
			
			responseService.addResponse(response);
			
			if((!response.getResponseText().equals("True")) || (!response.getResponseText().equals("False"))) {
				EvResponseMcq responseMcq = new EvResponseMcq();
//				responseMcq.setResponseId(response.getResponseId());
				responseMcq.setEvResponse(response);
				responseMcq.setResponseText(response.getResponseText());
				
				responseMcqService.addResponseMcq(responseMcq);
			}
		}
	}
}
