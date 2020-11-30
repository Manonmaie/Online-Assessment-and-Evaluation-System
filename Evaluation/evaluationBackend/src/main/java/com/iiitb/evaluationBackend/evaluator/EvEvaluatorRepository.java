package com.iiitb.evaluationBackend.evaluator;

import org.springframework.data.repository.CrudRepository;

import com.iiitb.evaluationBackend.evaluator.EvEvaluator;

public interface EvEvaluatorRepository extends CrudRepository<EvEvaluator, Integer> {

	public EvEvaluator findByEvaluatorCodeAndEvaluatorPassword(String evaluatorCode, String evaluatorPassword);
}
