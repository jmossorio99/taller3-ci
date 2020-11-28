package com.ossorio.taller3.service.interfaces;

import com.ossorio.taller3.model.Epidemevent;

public interface EpidemeventService {

	Epidemevent save(Epidemevent epidemevent);

	Epidemevent findById(Long id);

	void delete(Epidemevent event);

	Iterable<Epidemevent> findAll();

}
