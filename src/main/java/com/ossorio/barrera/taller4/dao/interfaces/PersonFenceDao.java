package com.ossorio.barrera.taller4.dao.interfaces;

import com.ossorio.barrera.taller4.model.PersonFence;

import java.util.List;

public interface PersonFenceDao {
    PersonFence save(PersonFence pf);
    List<PersonFence> findAll();
    PersonFence findById(long id);
    PersonFence update(PersonFence pf);
    PersonFence delete(PersonFence pf);
}
