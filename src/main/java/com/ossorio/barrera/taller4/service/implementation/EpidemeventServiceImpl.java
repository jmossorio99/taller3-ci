package com.ossorio.barrera.taller4.service.implementation;

import com.ossorio.barrera.taller4.dao.interfaces.EpidemeventDao;
import org.springframework.stereotype.Service;

import com.ossorio.barrera.taller4.model.Epidemevent;
import com.ossorio.barrera.taller4.repository.EpidemeventRepository;
import com.ossorio.barrera.taller4.service.interfaces.EpidemeventService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EpidemeventServiceImpl implements EpidemeventService {

	private final EpidemeventDao epidemeventDao;

	public EpidemeventServiceImpl(EpidemeventDao epidemeventDao) {
		this.epidemeventDao = epidemeventDao;
	}

	@Transactional
	@Override
	public Epidemevent findById(Long id) {
		return epidemeventDao.findById(id);
	}

	@Transactional
	@Override
	public Epidemevent save(Epidemevent epidemevent) {
		return epidemeventDao.save(epidemevent);
	}

	@Transactional
	@Override
	public void delete(Epidemevent event) {
		epidemeventDao.delete(event);

	}

	@Transactional
	@Override
	public List<Epidemevent> findAll() {
		return epidemeventDao.findAll();
	}

}
