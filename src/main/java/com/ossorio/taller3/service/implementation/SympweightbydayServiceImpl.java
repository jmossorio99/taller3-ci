package com.ossorio.taller3.service.implementation;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.ossorio.taller3.model.Sympweightbyday;
import com.ossorio.taller3.repository.SympweightbydayRepository;
import com.ossorio.taller3.service.interfaces.SymptomquestionService;
import com.ossorio.taller3.service.interfaces.SympweightbydayService;

@Service
public class SympweightbydayServiceImpl implements SympweightbydayService {

	private final SympweightbydayRepository repository;
	private final SymptomquestionService symptomquestionService;

	public SympweightbydayServiceImpl(SympweightbydayRepository repository,
			SymptomquestionService symptomquestionService) {
		this.repository = repository;
		this.symptomquestionService = symptomquestionService;
	}

	@Override
	public Sympweightbyday save(Sympweightbyday sympweightbyday, Long questionId) {
		if (sympweightbyday != null && questionId != null) {
			if (sympweightbyday.getSympweidaysMin() != null) {
				if (sympweightbyday.getSympweidaysWeight() != null) {
					if (sympweightbyday.getSympweidaysMin().compareTo(sympweightbyday.getSympweidaysMax()) <= 0) {
						if (sympweightbyday.getSympweidaysWeight().compareTo(BigDecimal.valueOf(0)) >= 0) {
							if (symptomquestionService.findById(questionId) != null) {
								sympweightbyday.setSymptomquestion(symptomquestionService.findById(questionId));
								return repository.save(sympweightbyday);
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

	@Override
	public Sympweightbyday update(Sympweightbyday sympweightbyday, Long questionId) {
		if (sympweightbyday != null && questionId != null) {
			if (sympweightbyday.getSympweidaysMin() != null) {
				if (sympweightbyday.getSympweidaysWeight() != null) {
					if (sympweightbyday.getSympweidaysMin().compareTo(sympweightbyday.getSympweidaysMax()) <= 0) {
						if (sympweightbyday.getSympweidaysWeight().compareTo(BigDecimal.valueOf(0)) >= 0) {
							if (symptomquestionService.findById(questionId) != null) {
								sympweightbyday.setSymptomquestion(symptomquestionService.findById(questionId));
								return repository.save(sympweightbyday);
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

	@Override
	public Sympweightbyday findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(Sympweightbyday sympweightbyday) {
		repository.delete(sympweightbyday);
	}

	@Override
	public Iterable<Sympweightbyday> findAll() {
		return repository.findAll();
	}

}
