package com.ossorio.taller3.dao.interfaces;

import java.util.Date;
import java.util.List;

import com.ossorio.taller3.model.Symptompoll;

public interface SymptompollDao {

	void delete(Symptompoll symptompoll);

	List<Symptompoll> findAll();

	Symptompoll findById(long id);

	List<Symptompoll> findByDate(Date startDate, Date endDate);

	List<Symptompoll> findByDateOrdered(Date date);

	List<Symptompoll> listZeroWeightQuestions();

	Symptompoll save(Symptompoll symptompoll);

	Symptompoll update(Symptompoll symptompoll);

}
