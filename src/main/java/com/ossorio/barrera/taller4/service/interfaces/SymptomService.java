package com.ossorio.barrera.taller4.service.interfaces;


import com.ossorio.barrera.taller4.model.Symptom;

public interface SymptomService {

	Symptom save(Symptom symptom);

	Symptom findById(Long id);

	Iterable<Symptom> findAll();

	void delete(Symptom symptom);

}
