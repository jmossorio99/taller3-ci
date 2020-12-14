package com.ossorio.barrera.taller4.delegate.interfaces;

import com.ossorio.barrera.taller4.model.Sympweightbyday;

import java.util.List;

public interface SymptomWeightDelegate {
    Sympweightbyday save(Sympweightbyday sympweightbyday, Long questionId);

    Sympweightbyday update(Sympweightbyday sympweightbyday, Long questionId);

    Sympweightbyday findById(Long id);

    void delete(Sympweightbyday sympweightbyday);

    List<Sympweightbyday> findAll();
}
