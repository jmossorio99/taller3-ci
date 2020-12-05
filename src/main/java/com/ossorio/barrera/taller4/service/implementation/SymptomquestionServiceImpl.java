package com.ossorio.barrera.taller4.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ossorio.barrera.taller4.dao.interfaces.SymptomquestionDao;
import com.ossorio.barrera.taller4.model.Symptomquestion;
import com.ossorio.barrera.taller4.service.interfaces.SymptomService;
import com.ossorio.barrera.taller4.service.interfaces.SymptompollService;
import com.ossorio.barrera.taller4.service.interfaces.SymptomquestionService;

@Service
public class SymptomquestionServiceImpl implements SymptomquestionService {

	private final SymptomService symptomService;
	private final SymptompollService symptomPollService;
	private final SymptomquestionDao dao;
//	private final SymptomquestionRepository repository;

	public SymptomquestionServiceImpl(SymptomService symptomService, SymptompollService symptompollService,
			SymptomquestionDao dao) {
		this.symptomService = symptomService;
		symptomPollService = symptompollService;
//		this.repository = repository;
		this.dao = dao;
	}

	@Transactional
	@Override
	public Symptomquestion save(Symptomquestion symptomquestion, Long symptomId, Long pollId) {
		if (symptomquestion != null && symptomId != null && pollId != null) {
			if (symptomquestion.getSympquesName() != null && !symptomquestion.getSympquesName().isEmpty()) {
				if (symptomService.findById(symptomId) != null) {
					if (symptomPollService.findById(pollId) != null) {
						symptomquestion.setSymptompoll(symptomPollService.findById(pollId));
						symptomquestion.setSymptom(symptomService.findById(symptomId));
						return dao.save(symptomquestion);
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
	@Transactional
	public Symptomquestion update(Symptomquestion symptomquestion, Long symptomId, Long pollId) {
		if (symptomquestion != null && symptomId != null && pollId != null) {
			if (symptomquestion.getSympquesName() != null && !symptomquestion.getSympquesName().isEmpty()) {
				if (symptomService.findById(symptomId) != null) {
					if (symptomPollService.findById(pollId) != null) {
						symptomquestion.setSymptompoll(symptomPollService.findById(pollId));
						symptomquestion.setSymptom(symptomService.findById(symptomId));
						return dao.update(symptomquestion);
					}
					throw new RuntimeException("Symptompoll does not exist");
				}
				throw new RuntimeException("Symptom does not exist");
			}
			throw new RuntimeException("Question name was empty or null");
		}
		throw new RuntimeException("Error: Null parameter");
	}

	@Transactional
	@Override
	public Symptomquestion findById(Long id) {
		return dao.findById(id);
	}

	@Transactional
	@Override
	public void delete(Symptomquestion symptomquestion) {
		dao.delete(symptomquestion);
	}

	@Transactional
	@Override
	public List<Symptomquestion> findAll() {
		return dao.findAll();
	}

}
