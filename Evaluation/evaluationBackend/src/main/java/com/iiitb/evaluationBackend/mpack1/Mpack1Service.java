package com.iiitb.evaluationBackend.mpack1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mpack1Service {
	@Autowired
	private Mpack1Repository mpack1Repository;
	
	public void addMpack1(Mpack1 mpack1) {
		mpack1Repository.save(mpack1);
	}
	
	public void addMpack1Bulk(List<Mpack1> mpack1s) {
		mpack1Repository.saveAll(mpack1s);
	}
	
	public void deleteAll() {
		mpack1Repository.deleteAll();
	}
	
}
