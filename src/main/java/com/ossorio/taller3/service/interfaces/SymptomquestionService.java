package com.ossorio.taller3.service.interfaces;

import java.util.List;

import com.ossorio.taller3.model.Symptomquestion;

public interface SymptomquestionService {

	Symptomquestion save(Symptomquestion symptomquestion, Long symptomId, Long pollId);

	Symptomquestion update(Symptomquestion symptomquestion, Long symptomId, Long pollId);

	Symptomquestion findById(Long id);

	void delete(Symptomquestion symptomquestion);

	List<Symptomquestion> findAll();

}
