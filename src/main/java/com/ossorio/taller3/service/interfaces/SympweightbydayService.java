package com.ossorio.taller3.service.interfaces;

import java.util.List;

import com.ossorio.taller3.model.Sympweightbyday;

public interface SympweightbydayService {

	Sympweightbyday save(Sympweightbyday sympweightbyday, Long questionId);

	Sympweightbyday update(Sympweightbyday sympweightbyday, Long questionId);

	Sympweightbyday findById(Long id);

	void delete(Sympweightbyday sympweightbyday);

	List<Sympweightbyday> findAll();

}
