package com.ossorio.barrera.taller4.delegate.interfaces;

import com.ossorio.barrera.taller4.model.PersonFence;
import com.ossorio.barrera.taller4.model.PersonFencePK;

import java.util.List;

public interface PersonFenceDelegate {
    PersonFence save(PersonFence pf);

    PersonFence update(PersonFence pf);

    void delete(PersonFencePK id);

    List<PersonFence> findAll();

    PersonFence findById(Long id);

}
