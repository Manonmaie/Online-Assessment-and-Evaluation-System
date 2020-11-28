package com.iiitb.examAdminBackEnd.qpack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.examAdminBackEnd.batch.Batch;
import com.iiitb.examAdminBackEnd.batch.BatchService;
import com.iiitb.examAdminBackEnd.instructions.Instructions;
import com.iiitb.examAdminBackEnd.instructions.InstructionsService;
import com.iiitb.examAdminBackEnd.questionPaper.QuestionPaper;
import com.iiitb.examAdminBackEnd.questionPaper.QuestionPaperService;

@Service
public class QpackService {
	@Autowired
	private QpackRepository qpackRepository;
	
	@Autowired
	private BatchService batchService;
	
	@Autowired
	private QuestionPaperService questionPaperService;
	
	@Autowired
	private InstructionsService instructionsService;
	
	public List<Qpack> getAllQpacks() {
		List<Qpack> qpacks = new ArrayList<>();
		qpackRepository.findAll().forEach(qpacks::add);
		return qpacks;
	}

	public void deleteQpack(int id) {
		qpackRepository.deleteById(id);
	}
	
	public Optional<Qpack> getQpack(int id){
		return qpackRepository.findById(id);
	}
	
	public void qpack2OriginalTables() {
		Map<Integer, QuestionPaper> id2Qp = new HashMap<Integer, QuestionPaper>();
		
		List<Object[]> qpDataObjects = qpackRepository.fetchQPdata();
		for(int i = 0; i < qpDataObjects.size(); i++) {
			Batch batch = batchService.getBatchesByCode(String.valueOf(qpDataObjects.get(i)[3]));
			batch.setQpStatus("RECEIVED");
			batchService.updateBatch(batch.getBatchId(), batch);
//			System.out.println((Integer)qpDataObjects.get(i)[0] + " " + batch.getBatchId() + " " + (float)(Integer)qpDataObjects.get(i)[1]);
			QuestionPaper questionPaper = new QuestionPaper((Integer)qpDataObjects.get(i)[0], batch, (float)(Integer)qpDataObjects.get(i)[1], (Integer)qpDataObjects.get(i)[2]);
			questionPaperService.addQuestionPaper(questionPaper);
			
			if(!id2Qp.containsKey(questionPaper.getQp_id())) {
				id2Qp.put(questionPaper.getQp_id(), questionPaper);
			}
		}
		
		List<Object[]> instructionObjects = qpackRepository.fetchInstructionsdata();
		for(int i = 0; i < instructionObjects.size(); i++) {
			Instructions instruction = new Instructions((Integer)instructionObjects.get(i)[0], String.valueOf(instructionObjects.get(i)[2]));
			if(id2Qp.containsKey((Integer)instructionObjects.get(i)[1])) {
				instruction.setQuestionPaper(id2Qp.get((Integer)instructionObjects.get(i)[1]));
			}
			instructionsService.addInstructions(instruction);
		}
	}
}
