package com.ossorio.taller3.service.interfaces;

import org.springframework.stereotype.Service;

import com.ossorio.taller3.model.Symptom;

@Service
public interface SymptomService {

	Symptom save(Symptom symptom);

	Symptom findById(Long id);

	Iterable<Symptom> findAll();

	void delete(Symptom symptom);

}
