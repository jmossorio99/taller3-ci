package com.ossorio.barrera.taller4.service.implementation;

import org.springframework.stereotype.Service;

import com.ossorio.barrera.taller4.model.Symptom;
import com.ossorio.barrera.taller4.repository.SymptomRepository;
import com.ossorio.barrera.taller4.service.interfaces.SymptomService;

@Service
public class SymptomServiceImpl implements SymptomService {

	private final SymptomRepository repository;

	public SymptomServiceImpl(SymptomRepository repository) {
		this.repository = repository;
	}

	@Override
	public Symptom save(Symptom symptom) {
		return repository.save(symptom);
	}

	@Override
	public Symptom findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public void delete(Symptom symptom) {
		repository.delete(symptom);
	}

	@Override
	public Iterable<Symptom> findAll() {
		return repository.findAll();
	}

}
