package com.ossorio.barrera.taller4.delegate.interfaces;

import com.ossorio.barrera.taller4.model.Symptomquestion;

import java.util.List;

public interface SymptomquestionDelegate {

    Symptomquestion save(Symptomquestion symptomquestion);

    Symptomquestion update(Symptomquestion symptomquestion);

    Symptomquestion findById(Long id);

    void delete(Symptomquestion symptomquestion);

    List<Symptomquestion> getAll();

}
