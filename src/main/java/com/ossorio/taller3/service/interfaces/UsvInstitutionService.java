package com.ossorio.taller3.service.interfaces;

import com.ossorio.taller3.model.UsvInstitution;

public interface UsvInstitutionService {

	Iterable<UsvInstitution> findAll();

	UsvInstitution findById(Long id);

	UsvInstitution save(UsvInstitution usvInstitution);

	UsvInstitution update(UsvInstitution usvInstitution);

	void deleteById(Long id);

	void delete(UsvInstitution institution);

}
