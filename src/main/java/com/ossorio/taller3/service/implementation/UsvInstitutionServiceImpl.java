package com.ossorio.taller3.service.implementation;

import org.springframework.stereotype.Service;

import com.ossorio.taller3.model.UsvInstitution;
import com.ossorio.taller3.repository.UsvInstitutionRepository;
import com.ossorio.taller3.service.interfaces.UsvInstitutionService;

@Service
public class UsvInstitutionServiceImpl implements UsvInstitutionService {

	private final UsvInstitutionRepository repository;

	public UsvInstitutionServiceImpl(UsvInstitutionRepository repository) {
		this.repository = repository;
	}

	@Override
	public Iterable<UsvInstitution> findAll() {
		return repository.findAll();
	}

	@Override
	public UsvInstitution save(UsvInstitution usvInstitution) {
		if (usvInstitution != null) {
			if (usvInstitution.getInstName() != null && !usvInstitution.getInstName().isEmpty()) {
				if (verifyInstitutionURLs(usvInstitution)) {
					return repository.save(usvInstitution);
				}
				throw new RuntimeException("One or more Institution URLs did not begin with https://");
			}
			throw new RuntimeException("Institution name was null or empty");
		}
		throw new RuntimeException("Null institution entered");
	}

	@Override
	public UsvInstitution update(UsvInstitution usvInstitution) {
		if (usvInstitution != null) {
			if (usvInstitution.getInstName() != null && !usvInstitution.getInstName().isEmpty()) {
				if (verifyInstitutionURLs(usvInstitution)) {
					return repository.save(usvInstitution);
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

	@Override
	public UsvInstitution findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

	@Override
	public void delete(UsvInstitution institution) {
		repository.delete(institution);

	}

}
