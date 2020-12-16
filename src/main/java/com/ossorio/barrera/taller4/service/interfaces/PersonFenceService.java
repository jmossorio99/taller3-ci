package com.ossorio.barrera.taller4.service.interfaces;

import com.ossorio.barrera.taller4.model.PersonFence;

import java.util.List;

public interface PersonFenceService {

    PersonFence save(PersonFence pf);
    List<PersonFence> findAll();
    PersonFence findById(long id);
    PersonFence update(PersonFence pf);
    PersonFence delete(PersonFence pf);
}
