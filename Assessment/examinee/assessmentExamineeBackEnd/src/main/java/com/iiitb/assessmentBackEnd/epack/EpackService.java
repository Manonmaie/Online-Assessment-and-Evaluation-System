package com.iiitb.assessmentBackEnd.epack;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.assessmentBackEnd.batch.AsBatch;
import com.iiitb.assessmentBackEnd.batch.BatchService;
import com.iiitb.assessmentBackEnd.center.AsCenter;
import com.iiitb.assessmentBackEnd.center.CenterService;
import com.iiitb.assessmentBackEnd.courseMaster.AsCourseMaster;
import com.iiitb.assessmentBackEnd.courseMaster.CourseMasterService;
import com.iiitb.assessmentBackEnd.examdrive.AsExamdrive;
import com.iiitb.assessmentBackEnd.examdrive.ExamdriveService;
import com.iiitb.assessmentBackEnd.examinee.AsExaminee;
import com.iiitb.assessmentBackEnd.examinee.ExamineeService;
import com.iiitb.assessmentBackEnd.examineeBatch.AsExamineeBatch;
import com.iiitb.assessmentBackEnd.examineeBatch.ExamineeBatchKey;
import com.iiitb.assessmentBackEnd.examineeBatch.ExamineeBatchService;
import com.iiitb.assessmentBackEnd.itemMcqOptions.AsItemMcqOptions;
import com.iiitb.assessmentBackEnd.itemMcqOptions.ItemMcqOptionsService;
import com.iiitb.assessmentBackEnd.itemTrueFalse.AsItemTrueFalse;
import com.iiitb.assessmentBackEnd.itemTrueFalse.ItemTrueFalseService;
import com.iiitb.assessmentBackEnd.qpItem.AsQpItem;
import com.iiitb.assessmentBackEnd.qpItem.QpItemService;
import com.iiitb.assessmentBackEnd.questionPaper.AsQuestionPaper;
import com.iiitb.assessmentBackEnd.questionPaper.QuestionPaperService;
import com.iiitb.assessmentBackEnd.sqlDump.SqlDumpService;

@Service
public class EpackService {
	
	@Autowired
	private EpackRepository epackRepository;
	
	@Autowired
	CourseMasterService courseMasterService;
	
	@Autowired
	ExamdriveService examdriveService;
	
	@Autowired
	private CenterService centerService;
	
	@Autowired
	private QuestionPaperService questionPaperService;
	
	@Autowired
	private BatchService batchService;
	
	@Autowired
	private QpItemService qpItemService;
	
	@Autowired
	private ItemTrueFalseService itemTrueFalseService;
	
	@Autowired
	private ItemMcqOptionsService itemMcqOptionsService;
	
	@Autowired
	private ExamineeService examineeService;
	
	@Autowired
	private ExamineeBatchService examineeBatchService;
	
	@Autowired
	private SqlDumpService sqlDumpService;
	
	public void epack2OriginalTables(String EpackKey) throws IOException, InterruptedException {
		sqlDumpService.importEpackDump();
		
		Map<Integer, AsCourseMaster> id2CourseMaster = new HashMap<Integer, AsCourseMaster>();
		
		List<Object[]> courseObjects = epackRepository.fetchCourseMasterdata();
		for(int i = 0; i < courseObjects.size(); i++) {
			AsCourseMaster course = new AsCourseMaster((Integer)courseObjects.get(i)[0], String.valueOf(courseObjects.get(i)[1]), String.valueOf(courseObjects.get(i)[2]));
			courseMasterService.addCourseMaster(course);
			
			if(!id2CourseMaster.containsKey(course.getCourseMasterId())) {
				id2CourseMaster.put(course.getCourseMasterId(), course);
			}
		}
		
		Map<Integer, AsExamdrive> id2ExamDrive = new HashMap<Integer, AsExamdrive>();
		
		List<Object[]> examDriveObjects = epackRepository.fetchExamDrivedata();
		for(int i = 0; i < examDriveObjects.size(); i++) {
			AsExamdrive examdrive = new AsExamdrive();
			examdrive.setExamdriveId((Integer)examDriveObjects.get(i)[0]);
			examdrive.setExamdriveCode(String.valueOf(examDriveObjects.get(i)[1]));
			examdrive.setExamdriveName(String.valueOf(examDriveObjects.get(i)[2]));
			examdrive.setStatus("NOT_STARTED");
			if(id2CourseMaster.containsKey((Integer)examDriveObjects.get(i)[3])) {
				examdrive.setCourseMaster(id2CourseMaster.get((Integer)examDriveObjects.get(i)[3]));
			}
			examdriveService.addExamDrive(examdrive);
			
			if(!id2ExamDrive.containsKey(examdrive.getExamdriveId())) {
				id2ExamDrive.put(examdrive.getExamdriveId(), examdrive);
			}
		}
		
		Map<Integer, AsCenter> id2Center = new HashMap<Integer, AsCenter>();
		
		List<Object[]> centerObjects = epackRepository.fetchCenterData();
		for(int i = 0; i < centerObjects.size(); i++) {
			AsCenter center = new AsCenter();
			center.setCenterId((Integer)centerObjects.get(i)[0]);
			center.setCenterCode(String.valueOf(centerObjects.get(i)[1]));
			center.setCenterName(String.valueOf(centerObjects.get(i)[2]));
			
			centerService.addCenter(center);
			
			if(!id2Center.containsKey(center.getCenterId())) {
				id2Center.put(center.getCenterId(), center);
			}
		}
		
		Map<Integer, AsQuestionPaper> id2QuestionPaper = new HashMap<Integer, AsQuestionPaper>();
		
		List<Object[]> questionPaperObjects = epackRepository.fetchQuestionPaperData();
		for(int i = 0; i < questionPaperObjects.size(); i++) {
			AsQuestionPaper questionPaper = new AsQuestionPaper();
			questionPaper.setQpId((Integer)questionPaperObjects.get(i)[0]);
			questionPaper.setMaximumMarks((double)(Float)questionPaperObjects.get(i)[2]);
			questionPaper.setDuration((Integer)questionPaperObjects.get(i)[3]);
			
//			questionPaperService.addQuestionPaper(questionPaper);
			
			if(!id2QuestionPaper.containsKey(questionPaper.getQpId())) {
				id2QuestionPaper.put(questionPaper.getQpId(), questionPaper);
			}
		}
		
		Map<Integer, AsBatch> id2Batch= new HashMap<Integer, AsBatch>();
		
		List<Object[]> batchObjects = epackRepository.fetchBatchData();
		for(int i = 0; i < batchObjects.size(); i++) {
			AsBatch batch = new AsBatch();
			batch.setBatchId((Integer)batchObjects.get(i)[0]);
			batch.setBatchCode(String.valueOf(batchObjects.get(i)[1]));
			batch.setBatchStartTime(LocalDateTime.parse(batchObjects.get(i)[2].toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")));
			batch.setBatchEndTime(LocalDateTime.parse(batchObjects.get(i)[3].toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")));
			if(id2Center.containsKey((Integer)batchObjects.get(i)[4])) {
				batch.setAsCenter(id2Center.get((Integer)batchObjects.get(i)[4]));
			}
			if(id2ExamDrive.containsKey((Integer)batchObjects.get(i)[5])) {
				batch.setAsExamdrive(id2ExamDrive.get((Integer)batchObjects.get(i)[5]));
			}
			
			if(id2QuestionPaper.containsKey((Integer)batchObjects.get(i)[6])) {
				batch.setAsQuestionPaper(id2QuestionPaper.get((Integer)batchObjects.get(i)[6]));
				id2QuestionPaper.get((Integer)batchObjects.get(i)[6]).setAsBatch(batch);
				questionPaperService.addQuestionPaper(id2QuestionPaper.get((Integer)batchObjects.get(i)[6]));
			}
			batchService.addBatch(batch);
			
			if(!id2Batch.containsKey(batch.getBatchId())) {
				id2Batch.put(batch.getBatchId(), batch);
			}
		}
		
		Map<Integer, AsQpItem> id2QpItem = new HashMap<Integer, AsQpItem>();
		
		List<Object[]> qpItemObjects = epackRepository.fetchQpItemData();
		for(int i = 0; i < qpItemObjects.size(); i++) {
			AsQpItem qpItem = new AsQpItem();
			qpItem.setQpItemId((Integer)qpItemObjects.get(i)[0]);
			qpItem.setItemText(String.valueOf(qpItemObjects.get(i)[1]));
			qpItem.setItemMarks((Float)qpItemObjects.get(i)[2]);
			qpItem.setItemType(String.valueOf(qpItemObjects.get(i)[3]));
			qpItem.setCognitiveLevel(String.valueOf(qpItemObjects.get(i)[4]));
			if(id2QuestionPaper.containsKey((Integer)qpItemObjects.get(i)[5])) {
				qpItem.setAsQuestionPaper(id2QuestionPaper.get((Integer)qpItemObjects.get(i)[5]));
			}
			qpItemService.addQpItem(qpItem);
			
			if(!id2QpItem.containsKey(qpItem.getQpItemId())) {
				id2QpItem.put(qpItem.getQpItemId(), qpItem);
			}
		}
		
		List<Object[]> itemOptionObjects = epackRepository.fetchItemOptionsData();
		for(int i = 0; i < itemOptionObjects.size(); i++) {
			if(String.valueOf(itemOptionObjects.get(i)[2]).equals("True") || String.valueOf(itemOptionObjects.get(i)[2]).equals("False")) {
				AsItemTrueFalse itemTrueFalse = new AsItemTrueFalse();
				itemTrueFalse.setItemTrueFalseId((Integer)itemOptionObjects.get(i)[1]);
				if(id2QpItem.containsKey((Integer)itemOptionObjects.get(i)[0])) {
					itemTrueFalse.setAsQpItem(id2QpItem.get((Integer)itemOptionObjects.get(i)[0]));
				}
				i++;
				itemTrueFalseService.addItemTrueFalse(itemTrueFalse);
			}
			else {
				AsItemMcqOptions itemMcqOptions = new AsItemMcqOptions();
				itemMcqOptions.setItemMcqId((Integer)itemOptionObjects.get(i)[1]);
				if(id2QpItem.containsKey((Integer)itemOptionObjects.get(i)[0])) {
					itemMcqOptions.setAsQpItem(id2QpItem.get((Integer)itemOptionObjects.get(i)[0]));
				}
				itemMcqOptions.setMcqOptionText(String.valueOf(itemOptionObjects.get(i)[2]));
				itemMcqOptionsService.addItemMcqOptions(itemMcqOptions);
			}
		}
		
		Map<Integer, AsExaminee> id2Examinee = new HashMap<Integer, AsExaminee>();
		
		List<Object[]> examineeObjects = epackRepository.fetchExamineeData();
		for(int i = 0; i < examineeObjects.size();i++) {
			AsExaminee examinee = new AsExaminee((Integer)examineeObjects.get(i)[0], String.valueOf(examineeObjects.get(i)[1]), String.valueOf(examineeObjects.get(i)[2]), String.valueOf(examineeObjects.get(i)[3]), String.valueOf(examineeObjects.get(i)[4]), String.valueOf(examineeObjects.get(i)[5]), String.valueOf(examineeObjects.get(i)[6]));
			examineeService.addExaminee(examinee);
			
			if(!id2Examinee.containsKey(examinee.getExamineeId())) {
				id2Examinee.put(examinee.getExamineeId(), examinee);
			}
		}
		
		List<Object[]> examineeBatchObjects = epackRepository.fetchExamineeBatchData();
		for(int i = 0; i < examineeBatchObjects.size(); i++) {
			ExamineeBatchKey examineeBatchKey = new ExamineeBatchKey((Integer)examineeBatchObjects.get(i)[1], (Integer)examineeBatchObjects.get(i)[2]);
			AsExamineeBatch examineeBatch = new AsExamineeBatch();
			examineeBatch.setExamineeBatchId(examineeBatchKey);
			if(id2Examinee.containsKey((Integer)examineeBatchObjects.get(i)[1])) {
				examineeBatch.setExaminee(id2Examinee.get((Integer)examineeBatchObjects.get(i)[1]));
			}
			if(id2Batch.containsKey((Integer)examineeBatchObjects.get(i)[2])) {
				examineeBatch.setBatch(id2Batch.get((Integer)examineeBatchObjects.get(i)[2]));
			}
			examineeBatchService.addExamineeBatch(examineeBatch);
		}
	}
}
