package com.ossorio.taller3.repository;

import org.springframework.data.repository.CrudRepository;

import com.ossorio.taller3.model.Userr;

public interface UserrRepository extends CrudRepository<Userr, Long> {

	Userr findByUserName(String userName);

}
