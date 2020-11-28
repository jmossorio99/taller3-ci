package com.ossorio.taller3.service.interfaces;

import org.springframework.stereotype.Service;

import com.ossorio.taller3.model.Symptompoll;

@Service
public interface SymptompollService {

	Symptompoll save(Symptompoll symptompoll, Long instId, Long epidemId);

	Symptompoll update(Symptompoll symptompoll, Long instId, Long epidemId);

	Symptompoll findById(Long id);

	Iterable<Symptompoll> findAll();

	void deleteById(Long id);

	void delete(Symptompoll symptompoll);

}
