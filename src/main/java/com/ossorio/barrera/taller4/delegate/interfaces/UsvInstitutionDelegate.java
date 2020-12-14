package com.ossorio.barrera.taller4.delegate.interfaces;

import com.ossorio.barrera.taller4.model.UsvInstitution;

import java.util.List;

public interface UsvInstitutionDelegate {

    List<UsvInstitution> findAll();

    UsvInstitution findById(Long id);

    UsvInstitution findByName(String name);

    UsvInstitution save(UsvInstitution institution);

    UsvInstitution update(UsvInstitution institution);

    void delete(UsvInstitution institution);

}
