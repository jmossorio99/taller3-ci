package com.ossorio.taller3.service.interfaces;

import java.util.List;

import com.ossorio.taller3.model.UsvInstitution;

public interface UsvInstitutionService {

	List<UsvInstitution> findAll();

	UsvInstitution findById(Long id);

	UsvInstitution save(UsvInstitution usvInstitution);

	UsvInstitution update(UsvInstitution usvInstitution);

//	void deleteById(Long id);

	void delete(UsvInstitution institution);

	UsvInstitution findByName(String name);

}
