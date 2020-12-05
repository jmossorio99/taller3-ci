package com.ossorio.barrera.taller4.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ossorio.barrera.taller4.dao.interfaces.UsvInstitutionDao;
import com.ossorio.barrera.taller4.model.UsvInstitution;
import com.ossorio.barrera.taller4.service.interfaces.UsvInstitutionService;

@Service
public class UsvInstitutionServiceImpl implements UsvInstitutionService {

//	private final UsvInstitutionRepository repository;
	private final UsvInstitutionDao dao;

	public UsvInstitutionServiceImpl(UsvInstitutionDao dao) {
//		this.repository = repository;
		this.dao = dao;
	}

	@Override
	@Transactional
	public List<UsvInstitution> findAll() {
		return dao.findAll();
	}

	@Transactional
	@Override
	public UsvInstitution save(UsvInstitution usvInstitution) {
		if (usvInstitution != null) {
			if (usvInstitution.getInstName() != null && !usvInstitution.getInstName().isEmpty()) {
				if (verifyInstitutionURLs(usvInstitution)) {
					return dao.save(usvInstitution);
				}
				throw new RuntimeException("One or more Institution URLs did not begin with https://");
			}
			throw new RuntimeException("Institution name was null or empty");
		}
		throw new RuntimeException("Null institution entered");
	}

	@Override
	@Transactional
	public UsvInstitution update(UsvInstitution usvInstitution) {
		if (usvInstitution != null) {
			if (usvInstitution.getInstName() != null && !usvInstitution.getInstName().isEmpty()) {
				if (verifyInstitutionURLs(usvInstitution)) {
					return dao.update(usvInstitution);
				}
				throw new RuntimeException("One or more Institution URLs did not begin with https://");
			}
			throw new RuntimeException("Institution name was null or empty");
		}
		throw new RuntimeException("Null institution entered");
	}

	private boolean verifyURL(String url) {
		return url.startsWith("https://");
	}

	private boolean verifyInstitutionURLs(UsvInstitution usvInstitution) {
		return verifyURL(usvInstitution.getInstAcademicserverurl())
				&& verifyURL(usvInstitution.getInstAcadextradataurl())
				&& verifyURL(usvInstitution.getInstAcadloginurl())
				&& verifyURL(usvInstitution.getInstAcadpersoninfoidurl())
				&& verifyURL(usvInstitution.getInstAcadphysicalspacesurl())
				&& verifyURL(usvInstitution.getInstLdapurl());
	}

	@Transactional
	@Override
	public UsvInstitution findById(Long id) {
		return dao.findById(id);
	}

//	@Override
//	public void deleteById(Long id) {
//		dao.deleteById(id);
//
//	}

	@Transactional
	@Override
	public void delete(UsvInstitution institution) {
		dao.delete(institution);

	}

	@Override
	@Transactional
	public UsvInstitution findByName(String name) {
		return dao.findByName(name);
	}

}
