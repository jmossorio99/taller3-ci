package com.ossorio.taller3.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ossorio.taller3.dao.interfaces.UsvInstitutionDao;
import com.ossorio.taller3.model.UsvInstitution;

@Repository
public class UsvInstitutionDaoImp implements UsvInstitutionDao {

	@Autowired
	private EntityManager entityManager;

//	public UsvInstitutionDaoImp(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}

	@Override
	public void delete(UsvInstitution institution) {
		entityManager.remove(institution);
	}

	@Override
	public List<UsvInstitution> findAll() {
		final String jpql = "SELECT a FROM UsvInstitution a";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public UsvInstitution findById(long id) {
		return entityManager.find(UsvInstitution.class, id);
	}

	@Override
	public UsvInstitution save(UsvInstitution institution) {
		entityManager.persist(institution);
		return institution;
	}

	@Override
	public UsvInstitution update(UsvInstitution institution) {
		entityManager.merge(institution);
		return institution;
	}

	@Override
	public UsvInstitution findByName(String name) {
		final String query = "SELECT a FROM UsvInstitution a WHERE a.instName = :name";
		return (UsvInstitution) entityManager.createQuery(query).setParameter("name", name).getSingleResult();
	}

}
