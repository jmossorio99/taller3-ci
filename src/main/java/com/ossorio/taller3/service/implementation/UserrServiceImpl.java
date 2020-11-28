package com.ossorio.taller3.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ossorio.taller3.model.Userr;
import com.ossorio.taller3.repository.UserrRepository;
import com.ossorio.taller3.service.interfaces.UserrService;

@Service
public class UserrServiceImpl implements UserrService {

	private final UserrRepository userRepository;

	@Autowired
	public UserrServiceImpl(UserrRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Userr save(Userr user) {
		return userRepository.save(user);

	}

	@Override
	public Optional<Userr> findById(long id) {

		return userRepository.findById(id);
	}

	@Override
	public Iterable<Userr> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(Userr user) {
		userRepository.delete(user);

	}

}
