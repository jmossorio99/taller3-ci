package com.ossorio.taller3.service.implementation;

import org.springframework.stereotype.Service;

import com.ossorio.taller3.model.Symptomquestion;
import com.ossorio.taller3.repository.SymptomquestionRepository;
import com.ossorio.taller3.service.interfaces.SymptomService;
import com.ossorio.taller3.service.interfaces.SymptompollService;
import com.ossorio.taller3.service.interfaces.SymptomquestionService;

@Service
public class SymptomquestionServiceImpl implements SymptomquestionService {

	private final SymptomService symptomService;
	private final SymptompollService symptomPollService;
	private final SymptomquestionRepository repository;

	public SymptomquestionServiceImpl(SymptomService symptomService, SymptompollService symptompollService,
			SymptomquestionRepository repository) {
		this.symptomService = symptomService;
		symptomPollService = symptompollService;
		this.repository = repository;
	}

	@Override
	public Symptomquestion save(Symptomquestion symptomquestion, Long symptomId, Long pollId) {
		if (symptomquestion != null && symptomId != null && pollId != null) {
			if (symptomquestion.getSympquesName() != null && !symptomquestion.getSympquesName().isEmpty()) {
				if (symptomService.findById(symptomId) != null) {
					if (symptomPollService.findById(pollId) != null) {
						symptomquestion.setSymptompoll(symptomPollService.findById(pollId));
						symptomquestion.setSymptom(symptomService.findById(symptomId));
						return repository.save(symptomquestion);
					}
					throw new RuntimeException("Symptompoll does not exist");
				}
				throw new RuntimeException("Symptom does not exist");
			}
			throw new RuntimeException("Question name was empty or null");
		}
		throw new RuntimeException("Error: Null parameter");
	}

	@Override
	public Symptomquestion update(Symptomquestion symptomquestion, Long symptomId, Long pollId) {
		if (symptomquestion != null && symptomId != null && pollId != null) {
			if (symptomquestion.getSympquesName() != null && !symptomquestion.getSympquesName().isEmpty()) {
				if (symptomService.findById(symptomId) != null) {
					if (symptomPollService.findById(pollId) != null) {
						symptomquestion.setSymptompoll(symptomPollService.findById(pollId));
						symptomquestion.setSymptom(symptomService.findById(symptomId));
						return repository.save(symptomquestion);
					}
					throw new RuntimeException("Symptompoll does not exist");
				}
				throw new RuntimeException("Symptom does not exist");
			}
			throw new RuntimeException("Question name was empty or null");
		}
		throw new RuntimeException("Error: Null parameter");
	}

	@Override
	public Symptomquestion findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(Symptomquestion symptomquestion) {
		repository.delete(symptomquestion);
	}

	@Override
	public Iterable<Symptomquestion> findAll() {
		return repository.findAll();
	}

}
