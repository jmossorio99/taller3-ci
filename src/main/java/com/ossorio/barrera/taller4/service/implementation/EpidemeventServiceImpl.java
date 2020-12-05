package com.ossorio.barrera.taller4.service.implementation;

import org.springframework.stereotype.Service;

import com.ossorio.barrera.taller4.model.Epidemevent;
import com.ossorio.barrera.taller4.repository.EpidemeventRepository;
import com.ossorio.barrera.taller4.service.interfaces.EpidemeventService;

@Service
public class EpidemeventServiceImpl implements EpidemeventService {

	private final EpidemeventRepository epidemeventRepository;

	public EpidemeventServiceImpl(EpidemeventRepository epidemeventRepository) {
		this.epidemeventRepository = epidemeventRepository;
	}

	@Override
	public Epidemevent findById(Long id) {
		return epidemeventRepository.findById(id).get();
	}

	@Override
	public Epidemevent save(Epidemevent epidemevent) {
		return epidemeventRepository.save(epidemevent);
	}

	@Override
	public void delete(Epidemevent event) {
		epidemeventRepository.delete(event);

	}

	@Override
	public Iterable<Epidemevent> findAll() {
		return epidemeventRepository.findAll();
	}

}
