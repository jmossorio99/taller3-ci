package com.ossorio.barrera.taller4.delegate.interfaces;

import com.ossorio.barrera.taller4.model.Symptom;

public interface SymptomDelegate {

    Symptom findById(Long id);

    Iterable<Symptom> findAll();

    Symptom save(Symptom symptom);

    void delete(Symptom symptom);

}
