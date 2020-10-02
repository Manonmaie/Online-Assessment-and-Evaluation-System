package com.iiitb.assessmentBackEnd.attempt;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttemptService {
	
	@Autowired
	private AttemptRepository attemptRepository;
	
	public void addAttempt(AsAttempt attempt) {
		attemptRepository.save(attempt);
	}
	
	public Optional<AsAttempt> getAttempt(int attemptId) {
		return attemptRepository.findById(attemptId);
	}
}
