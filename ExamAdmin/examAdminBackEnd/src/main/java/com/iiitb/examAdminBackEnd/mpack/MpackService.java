package com.iiitb.examAdminBackEnd.mpack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.examAdminBackEnd.examdrive.Examdrive;
import com.iiitb.examAdminBackEnd.examdrive.ExamdriveService;
import com.iiitb.examAdminBackEnd.examineeBatch.ExamineeBatch;
import com.iiitb.examAdminBackEnd.examineeBatch.ExamineeBatchService;
import com.iiitb.examAdminBackEnd.examineeItemMarks.ExamineeItemMarks;
import com.iiitb.examAdminBackEnd.examineeItemMarks.ExamineeItemMarksService;
import com.iiitb.examAdminBackEnd.qp_item.QpItem;
import com.iiitb.examAdminBackEnd.qp_item.QpItemService;
import com.iiitb.examAdminBackEnd.sqlDump.SqlDumpService;

@Service
public class MpackService {
	@Autowired
	private MpackRepository mpackRepository;
	
	@Autowired
	private QpItemService qpItemService;
	
	@Autowired
	private ExamineeBatchService examineeBatchService;
	
	@Autowired
	private ExamineeItemMarksService examineeItemMarksService;
	
	@Autowired
	private ExamdriveService examdriveService;
	
	@Autowired
	private SqlDumpService sqlDumpService;
	
	public void mpack2OriginalTables() throws IOException, InterruptedException {
		sqlDumpService.importDump("Mpack");
		
		Set<Examdrive> examdriveSet =  new HashSet<Examdrive>();
		List<Object[]> examineeBatchMarksObjects = mpackRepository.fetchExamineeBatchMarksdata();
		for(int i = 0; i < examineeBatchMarksObjects.size(); i++) {
			Optional<ExamineeItemMarks> examineeItemMarksOptional = examineeItemMarksService.getExamineeItemMarksByQpItemId((Integer)examineeBatchMarksObjects.get(i)[1], (Integer)examineeBatchMarksObjects.get(i)[0]);
			if(examineeItemMarksOptional.isEmpty()) {
				Optional<ExamineeBatch> examineeBatchOptional = examineeBatchService.getExamineeBatchByExamineeBatchId((Integer)examineeBatchMarksObjects.get(i)[0]);
				QpItem qpItem = qpItemService.getQpItem((Integer)examineeBatchMarksObjects.get(i)[1]);
				
				ExamineeItemMarks examineeItemMarks = new ExamineeItemMarks((Float)examineeBatchMarksObjects.get(i)[2]);
	//			if(examineeBatch != null) {
	//				examineeItemMarks.setExamineeBatch(examineeBatch);
	//			}
				examineeItemMarks.setExaminee_batch_id((Integer)examineeBatchMarksObjects.get(i)[0]);
				if(qpItem != null) {
					examineeItemMarks.setQpItem(qpItem);
				}
	//			if(id2QpItem.containsKey((Integer)examineeBatchMarksObjects.get(i)[1])) {
	//				examineeItemMarks.setQpItem(id2QpItem.get((Integer)examineeBatchMarksObjects.get(i)[1]));
	//			}
				examineeItemMarksService.addExamineeItemMarks(examineeItemMarks);
				
				if(examineeBatchOptional.isPresent()) {
					examdriveSet.add(examineeBatchOptional.get().getBatch().getExamdrive());
				}
			}
		}
			
		for (Examdrive examdrive : examdriveSet) {
			System.out.println(examdrive.getExamdriveId());
			examdrive.setStatus("COMPLETED");
			examdriveService.updateExamdrive(examdrive.getExamdriveId(), examdrive);
		}
	}
}
