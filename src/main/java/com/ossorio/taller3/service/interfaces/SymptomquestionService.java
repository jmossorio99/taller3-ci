package com.ossorio.taller3.service.interfaces;

import com.ossorio.taller3.model.Symptomquestion;

public interface SymptomquestionService {

	Symptomquestion save(Symptomquestion symptomquestion, Long symptomId, Long pollId);

	Symptomquestion update(Symptomquestion symptomquestion, Long symptomId, Long pollId);

	Symptomquestion findById(Long id);

	void deleteById(Long id);

	void delete(Symptomquestion symptomquestion);

	Iterable<Symptomquestion> findAll();

}
