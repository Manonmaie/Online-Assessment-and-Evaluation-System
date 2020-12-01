package com.iiitb.evaluationBackend.apack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.evaluationBackend.qpItem.EvQpItem;
import com.iiitb.evaluationBackend.serverConnect.ServerConnect;
import com.iiitb.evaluationBackend.sqlDump.SqlDumpService;

@Service
public class ApackService {
	@Autowired
	private ApackRepository apackRepository;
	
	@Autowired
	private SqlDumpService sqlDumpService;
	
//	@Autowired
	private ServerConnect serverConnect;
	
	public void addApack1(Apack apack) {
		apackRepository.save(apack);
	}
	
	public void addApackBulk(List<Apack> apacks) {
		apackRepository.saveAll(apacks);
	}
	
	public void deleteAll() {
		apackRepository.deleteAll();
	}
	
	public void apack2OriginalTables(String ApackKey) throws IOException, InterruptedException {
//		List<Object[]> qpItemObjects = apackRepository.fetchQpItemdata();
//		for(int i = 0; i < qpItemObjects.size(); i++) {
//			
//			EvQpItem qpItem = new EvQpItem();
////			qpItem.setEvQuestionPaper(evQuestionPaper);
//		}
//		serverConnect.execCurlPullCommand("ApackDump.sql", ApackKey);
		
		sqlDumpService.importDump("Apack");
	}
}
