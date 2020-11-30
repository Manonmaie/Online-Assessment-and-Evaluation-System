package com.iiitb.examAdminBackEnd.qpack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.examAdminBackEnd.batch.Batch;
import com.iiitb.examAdminBackEnd.batch.BatchService;
import com.iiitb.examAdminBackEnd.examdrive.Examdrive;
import com.iiitb.examAdminBackEnd.examdrive.ExamdriveService;
import com.iiitb.examAdminBackEnd.examineeBatch.ExamineeBatch;
import com.iiitb.examAdminBackEnd.examineeBatch.ExamineeBatchService;
import com.iiitb.examAdminBackEnd.examineeItemMarks.ExamineeItemMarks;
import com.iiitb.examAdminBackEnd.examineeItemMarks.ExamineeItemMarksService;
import com.iiitb.examAdminBackEnd.instructions.Instructions;
import com.iiitb.examAdminBackEnd.instructions.InstructionsService;
import com.iiitb.examAdminBackEnd.itemMcqOptions.ItemMcqOptions;
import com.iiitb.examAdminBackEnd.itemMcqOptions.ItemMcqOptionsService;
import com.iiitb.examAdminBackEnd.itemTrueFalse.ItemTrueFalse;
import com.iiitb.examAdminBackEnd.itemTrueFalse.ItemTrueFalseService;
import com.iiitb.examAdminBackEnd.qp_item.QpItem;
import com.iiitb.examAdminBackEnd.qp_item.QpItemService;
import com.iiitb.examAdminBackEnd.questionPaper.QuestionPaper;
import com.iiitb.examAdminBackEnd.questionPaper.QuestionPaperService;
import com.iiitb.examAdminBackEnd.sqlDump.SqlDumpService;

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
	
	@Autowired
	private QpItemService qpItemService;
	
	@Autowired
	private ItemMcqOptionsService itemMcqOptionsService;
	
	@Autowired
	private ItemTrueFalseService itemTrueFalseService;
	
	@Autowired
	private ExamdriveService examdriveService;
	
	@Autowired
	private SqlDumpService sqlDumpService;
	
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
	
	public void qpack2OriginalTables() throws IOException, InterruptedException {
		sqlDumpService.importDump("Qpack");
		
		Map<Integer, QuestionPaper> id2Qp = new HashMap<Integer, QuestionPaper>();
		Set<Examdrive> examdriveSet =  new HashSet<Examdrive>(); 
		List<Object[]> qpDataObjects = qpackRepository.fetchQPdata();
		for(int i = 0; i < qpDataObjects.size(); i++) {
			Batch batch = batchService.getBatchesByCode(String.valueOf(qpDataObjects.get(i)[3]));
			examdriveSet.add(batch.getExamdrive());
			batch.setQpStatus("RECEIVED");
			batchService.updateBatch(batch.getBatchId(), batch);
//			System.out.println((Integer)qpDataObjects.get(i)[0] + " " + batch.getBatchId() + " " + (float)(Integer)qpDataObjects.get(i)[1]);
			QuestionPaper questionPaper = new QuestionPaper((Integer)qpDataObjects.get(i)[0], batch, (float)(Integer)qpDataObjects.get(i)[1], (Integer)qpDataObjects.get(i)[2]);
			questionPaperService.addQuestionPaper(questionPaper);
			
			if(!id2Qp.containsKey(questionPaper.getQp_id())) {
				id2Qp.put(questionPaper.getQp_id(), questionPaper);
			}
		}
		
		for (Examdrive examdrive : examdriveSet) {
			examdrive.setStatus("IN_PROGRESS");
			examdriveService.updateExamdrive(examdrive.getExamdriveId(), examdrive);
		}
		
		List<Object[]> instructionObjects = qpackRepository.fetchInstructionsdata();
		for(int i = 0; i < instructionObjects.size(); i++) {
			Instructions instruction = new Instructions((Integer)instructionObjects.get(i)[0], String.valueOf(instructionObjects.get(i)[2]));
			if(id2Qp.containsKey((Integer)instructionObjects.get(i)[1])) {
				instruction.setQuestionPaper(id2Qp.get((Integer)instructionObjects.get(i)[1]));
			}
			instructionsService.addInstructions(instruction);
		}
		
		Map<Integer, QpItem> id2QpItem = new HashMap<Integer, QpItem>();
		
		List<Object[]> qpItemObjects = qpackRepository.fetchQpItemdata();
		for(int i = 0; i < qpItemObjects.size(); i++) {
			QpItem qpItem = new QpItem((Integer)qpItemObjects.get(i)[0], String.valueOf(qpItemObjects.get(i)[1]), (Float)qpItemObjects.get(i)[2], String.valueOf(qpItemObjects.get(i)[3]), String.valueOf(qpItemObjects.get(i)[4]));
			if(id2Qp.containsKey((Integer)qpItemObjects.get(i)[5])) {
				qpItem.setQuestionPaper(id2Qp.get((Integer)qpItemObjects.get(i)[5]));
			}
			qpItemService.addQpItem(qpItem);
			
			if(!id2QpItem.containsKey(qpItem.getQp_item_id())) {
				id2QpItem.put(qpItem.getQp_item_id(), qpItem);
			}
		}
		
		List<Object[]> itemOptionsObjects = qpackRepository.fetchItemOptionsdata();
		for(int i = 0; i < itemOptionsObjects.size(); i++) {
			if(String.valueOf(itemOptionsObjects.get(i)[2]).equals("True") || String.valueOf(itemOptionsObjects.get(i)[2]).equals("False")) {
				ItemTrueFalse itemTrueFalse = new ItemTrueFalse((Integer)itemOptionsObjects.get(i)[1]);
				
				if(id2QpItem.containsKey((Integer)itemOptionsObjects.get(i)[0])) {
					itemTrueFalse.setQpItem(id2QpItem.get((Integer)itemOptionsObjects.get(i)[0]));
				}
				itemTrueFalseService.addItemTrueFalse(itemTrueFalse);
			}
			else {
				ItemMcqOptions itemMcqOptions = new ItemMcqOptions((Integer)itemOptionsObjects.get(i)[1], String.valueOf(itemOptionsObjects.get(i)[2]));
				
				if(id2QpItem.containsKey((Integer)itemOptionsObjects.get(i)[0])) {
					itemMcqOptions.setQpItem(id2QpItem.get((Integer)itemOptionsObjects.get(i)[0]));
				}
				itemMcqOptionsService.additemMcqOptions(itemMcqOptions);
			}
		}
	}
}
