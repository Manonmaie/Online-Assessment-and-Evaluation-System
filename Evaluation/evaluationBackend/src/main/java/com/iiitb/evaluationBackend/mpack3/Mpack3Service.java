package com.iiitb.evaluationBackend.mpack3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mpack3Service {
	@Autowired
	private Mpack3Repository mpack3Repository;
	
	public void addMpack3(Mpack3 mpack3) {
		mpack3Repository.save(mpack3);
	}
	
	public void addMpack3Bulk(List<Mpack3> mpack3s) {
		mpack3Repository.saveAll(mpack3s);
	}
	
	public void deleteAll() {
		mpack3Repository.deleteAll();
	}
}
