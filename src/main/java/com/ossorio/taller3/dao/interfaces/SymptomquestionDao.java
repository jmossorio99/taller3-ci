package com.ossorio.taller3.dao.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.ossorio.taller3.model.Symptomquestion;

public interface SymptomquestionDao {

	void delete(Symptomquestion symptomquestion);

	List<Symptomquestion> findAll();

	Symptomquestion findById(long id);

	Symptomquestion findByName(String name);

	Symptomquestion findByWeight(BigDecimal weight);

	Symptomquestion save(Symptomquestion symptomquestion);

	Symptomquestion update(Symptomquestion symptomquestion);

}
