package com.iiitb.evaluationBackend.mpack2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mpack2Service {
	@Autowired
	private Mpack2Repository mpack2Repository;
	
	public void addMpack2(Mpack2 mpack2) {
		mpack2Repository.save(mpack2);
	}
	
	public void addMpack2Bulk(List<Mpack2> mpack2s) {
		mpack2Repository.saveAll(mpack2s);
	}
	
	public void deleteAll() {
		mpack2Repository.deleteAll();
	}
}
