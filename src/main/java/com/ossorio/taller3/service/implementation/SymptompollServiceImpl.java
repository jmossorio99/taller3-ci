package com.ossorio.taller3.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ossorio.taller3.dao.interfaces.SymptompollDao;
import com.ossorio.taller3.model.Symptompoll;
import com.ossorio.taller3.service.interfaces.EpidemeventService;
import com.ossorio.taller3.service.interfaces.SymptompollService;
import com.ossorio.taller3.service.interfaces.UsvInstitutionService;

@Service
public class SymptompollServiceImpl implements SymptompollService {

	private final UsvInstitutionService usvInstitutionService;
	private final EpidemeventService epidemEventService;
//	private final SymptompollRepository repository;
	private final SymptompollDao dao;

	public SymptompollServiceImpl(UsvInstitutionService usvInstitutionService, EpidemeventService epidemEventService,
			SymptompollDao dao) {

		this.epidemEventService = epidemEventService;
		this.usvInstitutionService = usvInstitutionService;
//		this.repository = repository;
		this.dao = dao;

	}

	@Transactional
	@Override
	public Symptompoll save(Symptompoll symptompoll, Long instId, Long epidemId) {
		if (symptompoll != null && instId != null && epidemId != null) {
			if (symptompoll.getSympollName() != null && !symptompoll.getSympollName().isEmpty()) {
				if (usvInstitutionService.findById(instId) != null) {
					if (epidemEventService.findById(epidemId) != null) {
						symptompoll.setEpidemevent(epidemEventService.findById(epidemId));
						symptompoll.setInstInstId(instId);
						return dao.save(symptompoll);
					}
					throw new RuntimeException("EpidemEvent does not exist");
				}
				throw new RuntimeException("Institution does not exist");
			}
			throw new RuntimeException("Name of symptompoll was empty or null");
		}
		throw new RuntimeException("Error: Null parameter");
	}

	@Transactional
	@Override
	public Symptompoll update(Symptompoll symptompoll, Long instId, Long epidemId) {
		if (symptompoll != null && instId != null && epidemId != null) {
			if (!symptompoll.getSympollName().isEmpty()) {
				if (usvInstitutionService.findById(instId) != null) {
					if (epidemEventService.findById(epidemId) != null) {
						symptompoll.setEpidemevent(epidemEventService.findById(epidemId));
						symptompoll.setInstInstId(instId);
						return dao.update(symptompoll);
					}
					throw new RuntimeException("EpidemEvent does not exist");
				}
				throw new RuntimeException("Institution does not exist");
			}
			throw new RuntimeException("Name of symptompoll was empty");
		}
		throw new RuntimeException("Error: Null parameter");
	}

	@Transactional
	@Override
	public Symptompoll findById(Long id) {
		return dao.findById(id);
	}

	@Transactional
	@Override
	public void delete(Symptompoll symptompoll) {
		dao.delete(symptompoll);
	}

	@Transactional
	@Override
	public List<Symptompoll> findAll() {

		return dao.findAll();
	}

	@Transactional
	@Override
	public List<Symptompoll> findByDate(Date startDate, Date endDate) {
		return dao.findByDate(startDate, endDate);
	}

	@Transactional
	@Override
	public List<Symptompoll> findByDateOrdered(Date date) {
		return dao.findByDateOrdered(date);
	}

	@Transactional
	@Override
	public List<Symptompoll> listZeroWeightQuestions() {
		return dao.listZeroWeightQuestions();
	}

}
