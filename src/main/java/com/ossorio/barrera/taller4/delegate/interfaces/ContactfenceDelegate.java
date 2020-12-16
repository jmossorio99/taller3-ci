package com.ossorio.barrera.taller4.delegate.interfaces;

import com.ossorio.barrera.taller4.model.Contactfence;

import java.util.List;

public interface ContactfenceDelegate {
    Contactfence save(Contactfence cf);
    List<Contactfence> findAll();
    Contactfence findById(Long id);
}
