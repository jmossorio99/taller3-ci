package com.ossorio.barrera.taller4.repository;

import org.springframework.data.repository.CrudRepository;

import com.ossorio.barrera.taller4.model.Userr;
import org.springframework.stereotype.Repository;

public interface UserrRepository extends CrudRepository<Userr, Long> {

	Userr findByUserName(String userName);

}
