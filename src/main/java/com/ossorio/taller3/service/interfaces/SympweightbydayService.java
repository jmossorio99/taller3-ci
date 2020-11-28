package com.ossorio.taller3.service.interfaces;

import com.ossorio.taller3.model.Sympweightbyday;

public interface SympweightbydayService {

	Sympweightbyday save(Sympweightbyday sympweightbyday, Long questionId);

	Sympweightbyday update(Sympweightbyday sympweightbyday, Long questionId);

	Sympweightbyday findById(Long id);

	void deleteById(Long id);

	void delete(Sympweightbyday sympweightbyday);

	Iterable<Sympweightbyday> findAll();

}
