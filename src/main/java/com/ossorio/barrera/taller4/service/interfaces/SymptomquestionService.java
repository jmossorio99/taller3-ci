package com.ossorio.barrera.taller4.service.interfaces;

import java.util.List;

import com.ossorio.barrera.taller4.model.Symptomquestion;

public interface SymptomquestionService {

	Symptomquestion save(Symptomquestion symptomquestion);

	Symptomquestion update(Symptomquestion symptomquestion, Long symptomId, Long pollId);

	Symptomquestion findById(Long id);

	void delete(Symptomquestion symptomquestion);

	List<Symptomquestion> findAll();

}
