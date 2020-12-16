package com.ossorio.barrera.taller4.service.interfaces;

import com.ossorio.barrera.taller4.model.Contactfence;

import java.util.List;

public interface ContactfenceService {
    Contactfence save(Contactfence cf);

    Contactfence findById(Long id);

    void delete(Contactfence cf);

    List<Contactfence> findAll();
}
