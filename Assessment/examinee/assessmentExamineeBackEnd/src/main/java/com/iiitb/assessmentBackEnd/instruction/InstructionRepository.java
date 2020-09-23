package com.iiitb.assessmentBackEnd.instruction;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InstructionRepository extends CrudRepository<AsInstruction, Integer> {
	
//	@Query(value = "select * from as_instruction where qp_id = ?1", nativeQuery = true)
//	@Query(value = "select instruction_id, instruction_code, instruction_text from as_instruction where as_instruction.asQuestionPaper.qp_id = ?1", nativeQuery = true)
//	@Query("SELECT instructionId, instructionCode, instructionText FROM AsInstruction i where i.asQuestionPaper.qpId = :qpId")
//	List<AsInstruction> findAllInstructionNative(int qpId);
	
	public List<AsInstruction> findByAsQuestionPaperQpId(int qpId);
	
}
