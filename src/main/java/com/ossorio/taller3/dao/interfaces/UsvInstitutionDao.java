package com.ossorio.taller3.dao.interfaces;

import java.util.List;

import com.ossorio.taller3.model.Institution;
import com.ossorio.taller3.model.UsvInstitution;

public interface UsvInstitutionDao {

	void delete(UsvInstitution institution);

	List<Institution> findAll();

	UsvInstitution findById(long id);

	UsvInstitution findByName(String name);

	void save(UsvInstitution institution);

	void update(UsvInstitution institution);

}
