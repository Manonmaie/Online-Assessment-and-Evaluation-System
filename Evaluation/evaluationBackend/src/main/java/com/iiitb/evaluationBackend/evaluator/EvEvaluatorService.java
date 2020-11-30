package com.iiitb.evaluationBackend.evaluator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.evaluationBackend.evaluator.EvEvaluator;
import com.iiitb.evaluationBackend.evaluator.EvEvaluatorRepository;

@Service
public class EvEvaluatorService {
	@Autowired
	private EvEvaluatorRepository evaluatorRepository;
	
	public EvEvaluator getEvaluatorForRegistrationNumberAndPassword(String evaluatorCode, String password) {
		return evaluatorRepository.findByEvaluatorCodeAndEvaluatorPassword(evaluatorCode, password);
	}
	
	public void addEvaluator(EvEvaluator evaluator) {
		evaluatorRepository.save(evaluator);
	}
}
