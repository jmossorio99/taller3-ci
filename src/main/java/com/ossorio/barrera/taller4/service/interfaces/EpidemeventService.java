package com.ossorio.barrera.taller4.service.interfaces;

import com.ossorio.barrera.taller4.model.Epidemevent;

import java.util.List;

public interface EpidemeventService {

	Epidemevent save(Epidemevent epidemevent);

	Epidemevent findById(Long id);

	void delete(Epidemevent event);

	List<Epidemevent> findAll();

}
