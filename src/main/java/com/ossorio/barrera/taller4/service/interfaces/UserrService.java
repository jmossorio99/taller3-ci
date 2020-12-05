package com.ossorio.barrera.taller4.service.interfaces;

import java.util.Optional;

import com.ossorio.barrera.taller4.model.Userr;

public interface UserrService {

	Userr save(Userr user);

	Optional<Userr> findById(long id);

	Iterable<Userr> findAll();

	void delete(Userr user);

}
