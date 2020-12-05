package com.ossorio.taller3.service.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ossorio.taller3.model.Symptompoll;

@Service
public interface SymptompollService {

	Symptompoll save(Symptompoll symptompoll, Long instId, Long epidemId);

	Symptompoll update(Symptompoll symptompoll, Long instId, Long epidemId);

	Symptompoll findById(Long id);

	List<Symptompoll> findAll();

	void delete(Symptompoll symptompoll);

	List<Symptompoll> findByDate(Date startDate, Date endDate);

	List<Symptompoll> findByDateOrdered(Date date);

	List<Symptompoll> listZeroWeightQuestions();

}
