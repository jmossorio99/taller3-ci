package com.ossorio.barrera.taller4.delegate.interfaces;

import com.ossorio.barrera.taller4.model.Symptompoll;

import java.util.Date;
import java.util.List;

public interface SymptompollDelegate {

    List<Symptompoll> getAll();

    Symptompoll findById(Long id);

    List<Symptompoll> findByDate(String startDate, String endDate);

    List<Symptompoll> findByDateOrdered(String date);

    List<Symptompoll> listZeroWeightQuestions();

    Symptompoll save(Symptompoll symptompoll);

    Symptompoll update(Symptompoll symptompoll);

    void delete(Symptompoll symptompoll);

}
