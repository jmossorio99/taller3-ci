package com.ossorio.taller3.dao.interfaces;

import java.util.List;

import com.ossorio.taller3.model.Sympweightbyday;

public interface SympweightDao {

	void delete(Sympweightbyday sympweightbyday);

	List<Sympweightbyday> findAll();

	Sympweightbyday findById(long id);

	Sympweightbyday save(Sympweightbyday sympweightbyday);

	Sympweightbyday update(Sympweightbyday sympweightbyday);

}
