package com.ossorio.barrera.taller4.dao.interfaces;

import java.util.List;

import com.ossorio.barrera.taller4.model.UsvInstitution;

public interface UsvInstitutionDao {

	void delete(UsvInstitution institution);

	List<UsvInstitution> findAll();

	UsvInstitution findById(long id);

	UsvInstitution findByName(String name);

	UsvInstitution save(UsvInstitution institution);

	UsvInstitution update(UsvInstitution institution);

}
