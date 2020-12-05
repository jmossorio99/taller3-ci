package com.ossorio.taller3.service.implementation;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ossorio.taller3.dao.interfaces.SympweightDao;
import com.ossorio.taller3.model.Sympweightbyday;
import com.ossorio.taller3.service.interfaces.SymptomquestionService;
import com.ossorio.taller3.service.interfaces.SympweightbydayService;

@Service
public class SympweightbydayServiceImpl implements SympweightbydayService {

//	private final SympweightbydayRepository repository;
	private final SympweightDao weightDao;
	private final SymptomquestionService symptomquestionService;

	public SympweightbydayServiceImpl(SympweightDao weightDao, SymptomquestionService symptomquestionService) {
//		this.repository = repository;
		this.weightDao = weightDao;
		this.symptomquestionService = symptomquestionService;
	}

	@Transactional
	@Override
	public Sympweightbyday save(Sympweightbyday sympweightbyday, Long questionId) {
		if (sympweightbyday != null && questionId != null) {
			if (sympweightbyday.getSympweidaysMin() != null) {
				if (sympweightbyday.getSympweidaysWeight() != null) {
					if (sympweightbyday.getSympweidaysMin().compareTo(sympweightbyday.getSympweidaysMax()) <= 0) {
						if (sympweightbyday.getSympweidaysWeight().compareTo(BigDecimal.valueOf(0)) >= 0) {
							if (symptomquestionService.findById(questionId) != null) {
								sympweightbyday.setSymptomquestion(symptomquestionService.findById(questionId));
								return weightDao.save(sympweightbyday);
							}
							throw new RuntimeException("Question does not exist");
						}
						throw new RuntimeException("Weight is lower than 0");
					}
					throw new RuntimeException("min days is greater than max days");
				}
				throw new RuntimeException("Null weight");
			}
			throw new RuntimeException("null min days");

		}
		throw new RuntimeException("Error: Null parameter");
	}

	@Transactional
	@Override
	public Sympweightbyday update(Sympweightbyday sympweightbyday, Long questionId) {
		if (sympweightbyday != null && questionId != null) {
			if (sympweightbyday.getSympweidaysMin() != null) {
				if (sympweightbyday.getSympweidaysWeight() != null) {
					if (sympweightbyday.getSympweidaysMin().compareTo(sympweightbyday.getSympweidaysMax()) <= 0) {
						if (sympweightbyday.getSympweidaysWeight().compareTo(BigDecimal.valueOf(0)) >= 0) {
							if (symptomquestionService.findById(questionId) != null) {
								sympweightbyday.setSymptomquestion(symptomquestionService.findById(questionId));
								return weightDao.update(sympweightbyday);
							}
							throw new RuntimeException("Question does not exist");
						}
						throw new RuntimeException("Weight is lower than 0");
					}
					throw new RuntimeException("min days is greater than max days");
				}
				throw new RuntimeException("Null weight");
			}
			throw new RuntimeException("null min days");

		}
		throw new RuntimeException("Error: Null parameter");
	}

	@Transactional
	@Override
	public Sympweightbyday findById(Long id) {
		return weightDao.findById(id);
	}

	@Transactional
	@Override
	public void delete(Sympweightbyday sympweightbyday) {
		weightDao.delete(sympweightbyday);
	}

	@Transactional
	@Override
	public List<Sympweightbyday> findAll() {
		return weightDao.findAll();
	}

}
