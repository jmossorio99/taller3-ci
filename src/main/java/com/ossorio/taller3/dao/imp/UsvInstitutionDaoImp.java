package com.ossorio.taller3.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ossorio.taller3.dao.interfaces.UsvInstitutionDao;
import com.ossorio.taller3.model.Institution;
import com.ossorio.taller3.model.UsvInstitution;

@Repository
public class UsvInstitutionDaoImp implements UsvInstitutionDao {

	@PersistenceContext
	private final EntityManager entityManager;

	public UsvInstitutionDaoImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void delete(UsvInstitution institution) {
		entityManager.remove(institution);

	}

	@Override
	public List<Institution> findAll() {
		final String jpql = "SELECT a FROM UsvInstitution a";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public UsvInstitution findById(long id) {
		return entityManager.find(UsvInstitution.class, id);
	}

	@Override
	public void save(UsvInstitution institution) {
		entityManager.persist(institution);
	}

	@Override
	public void update(UsvInstitution institution) {
		entityManager.merge(institution);
	}

	@Override
	public UsvInstitution findByName(String name) {
		final String query = "SELECT a FROM UsvInstitution a WHERE a.instName = " + name;
		return (UsvInstitution) entityManager.createQuery(query).getSingleResult();
	}

}
