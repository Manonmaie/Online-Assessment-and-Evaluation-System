package com.iiitb.examAdminBackEnd.mpack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.examAdminBackEnd.examineeBatch.ExamineeBatch;
import com.iiitb.examAdminBackEnd.examineeBatch.ExamineeBatchService;
import com.iiitb.examAdminBackEnd.examineeItemMarks.ExamineeItemMarks;
import com.iiitb.examAdminBackEnd.examineeItemMarks.ExamineeItemMarksService;
import com.iiitb.examAdminBackEnd.qp_item.QpItem;
import com.iiitb.examAdminBackEnd.qp_item.QpItemService;

@Service
public class MpackService {
	@Autowired
	private MpackRepository mpackRepository;
	
	@Autowired
	private QpItemService qpItemService;
	
	@Autowired
	ExamineeBatchService examineeBatchService;
	
	@Autowired
	ExamineeItemMarksService examineeItemMarksService;
	
	public void mpack2OriginalTables() {
		List<Object[]> examineeBatchMarksObjects = mpackRepository.fetchExamineeBatchMarksdata();
		for(int i = 0; i < examineeBatchMarksObjects.size(); i++) {
			ExamineeBatch examineeBatch = examineeBatchService.getExamineeBatchByExamineeBatchId((Integer)examineeBatchMarksObjects.get(i)[0]);
			QpItem qpItem = qpItemService.getQpItem((Integer)examineeBatchMarksObjects.get(i)[1]);
			
			ExamineeItemMarks examineeItemMarks = new ExamineeItemMarks((Float)examineeBatchMarksObjects.get(i)[2]);
			if(examineeBatch != null) {
				examineeItemMarks.setExamineeBatch(examineeBatch);
			}
			
			if(qpItem != null) {
				examineeItemMarks.setQpItem(qpItem);
			}
//			if(id2QpItem.containsKey((Integer)examineeBatchMarksObjects.get(i)[1])) {
//				examineeItemMarks.setQpItem(id2QpItem.get((Integer)examineeBatchMarksObjects.get(i)[1]));
//			}
			examineeItemMarksService.addExamineeItemMarks(examineeItemMarks);
		}
	}
}
