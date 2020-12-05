package com.ossorio.taller3.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ossorio.taller3.dao.interfaces.SympweightDao;
import com.ossorio.taller3.model.Sympweightbyday;

@Repository
public class SympweightDaoImp implements SympweightDao {

	@Autowired
	private EntityManager entityManager;

//	public SympweightDaoImp(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}

	@Override
	public void delete(Sympweightbyday sympweightbyday) {
		entityManager.remove(sympweightbyday);

	}

	@Override
	public List<Sympweightbyday> findAll() {
		final String jpql = "SELECT a FROM Sympweightbyday a";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public Sympweightbyday findById(long id) {
		return entityManager.find(Sympweightbyday.class, id);
	}

	@Override
	public Sympweightbyday save(Sympweightbyday sympweightbyday) {
		entityManager.persist(sympweightbyday);
		return sympweightbyday;
	}

	@Override
	public Sympweightbyday update(Sympweightbyday sympweightbyday) {
		entityManager.merge(sympweightbyday);
		return sympweightbyday;
	}

}
