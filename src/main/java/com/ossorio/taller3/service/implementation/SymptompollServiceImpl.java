package com.ossorio.taller3.service.implementation;

import org.springframework.stereotype.Service;

import com.ossorio.taller3.model.Symptompoll;
import com.ossorio.taller3.repository.SymptompollRepository;
import com.ossorio.taller3.service.interfaces.EpidemeventService;
import com.ossorio.taller3.service.interfaces.SymptompollService;
import com.ossorio.taller3.service.interfaces.UsvInstitutionService;

@Service
public class SymptompollServiceImpl implements SymptompollService {

	private final UsvInstitutionService usvInstitutionService;
	private final EpidemeventService epidemEventService;
	private final SymptompollRepository repository;

	public SymptompollServiceImpl(UsvInstitutionService usvInstitutionService, EpidemeventService epidemEventService,
			SymptompollRepository repository) {

		this.epidemEventService = epidemEventService;
		this.usvInstitutionService = usvInstitutionService;
		this.repository = repository;

	}

	@Override
	public Symptompoll save(Symptompoll symptompoll, Long instId, Long epidemId) {
		if (symptompoll != null && instId != null && epidemId != null) {
			if (symptompoll.getSympollName() != null && !symptompoll.getSympollName().isEmpty()) {
				if (usvInstitutionService.findById(instId) != null) {
					if (epidemEventService.findById(epidemId) != null) {
						symptompoll.setEpidemevent(epidemEventService.findById(epidemId));
						symptompoll.setInstInstId(instId);
						return repository.save(symptompoll);
					}
					throw new RuntimeException("EpidemEvent does not exist");
				}
				throw new RuntimeException("Institution does not exist");
			}
			throw new RuntimeException("Name of symptompoll was empty or null");
		}
		throw new RuntimeException("Error: Null parameter");
	}

	@Override
	public Symptompoll update(Symptompoll symptompoll, Long instId, Long epidemId) {
		if (symptompoll != null && instId != null && epidemId != null) {
			if (!symptompoll.getSympollName().isEmpty()) {
				if (usvInstitutionService.findById(instId) != null) {
					if (epidemEventService.findById(epidemId) != null) {
						symptompoll.setEpidemevent(epidemEventService.findById(epidemId));
						symptompoll.setInstInstId(instId);
						return repository.save(symptompoll);
					}
					throw new RuntimeException("EpidemEvent does not exist");
				}
				throw new RuntimeException("Institution does not exist");
			}
			throw new RuntimeException("Name of symptompoll was empty");
		}
		throw new RuntimeException("Error: Null parameter");
	}

	@Override
	public Symptompoll findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(Symptompoll symptompoll) {
		repository.delete(symptompoll);
	}

	@Override
	public Iterable<Symptompoll> findAll() {

		return repository.findAll();
	}

}
