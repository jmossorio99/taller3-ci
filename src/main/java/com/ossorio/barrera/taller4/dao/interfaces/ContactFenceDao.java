package com.ossorio.barrera.taller4.dao.interfaces;

import com.ossorio.barrera.taller4.model.Contactfence;

import java.util.List;

public interface ContactFenceDao {

    Contactfence save(Contactfence cf);
    List<Contactfence> findAll();
    Contactfence findById(Long id);
}
