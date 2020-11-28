package com.ossorio.taller3.service.interfaces;

import java.util.Optional;

import com.ossorio.taller3.model.Userr;

public interface UserrService {

	Userr save(Userr user);

	Optional<Userr> findById(long id);

	Iterable<Userr> findAll();

	void delete(Userr user);

}
