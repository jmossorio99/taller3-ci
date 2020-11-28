package com.ossorio.taller3.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ossorio.taller3.dao.interfaces.SymptomquestionDao;
import com.ossorio.taller3.model.Symptomquestion;

@Repository
public class SymptomquestionDaoImp implements SymptomquestionDao {

	@PersistenceContext
	private final EntityManager entityManager;

	public SymptomquestionDaoImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void delete(Symptomquestion symptomquestion) {
		entityManager.remove(symptomquestion);

	}

	@Override
	public List<Symptomquestion> findAll() {
		final String jpql = "SELECT a FROM Symptomquestion a";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public Symptomquestion findById(long id) {
		return entityManager.find(Symptomquestion.class, id);
	}

	@Override
	public void save(Symptomquestion symptomquestion) {
		entityManager.persist(symptomquestion);
	}

	@Override
	public void update(Symptomquestion symptomquestion) {
		entityManager.merge(symptomquestion);
	}

	@Override
	public Symptomquestion findByName(String name) {
		final String query = "SELECT a FROM Symptomquestion a WHERE a.sympquesName = " + name;
		return (Symptomquestion) entityManager.createQuery(query).getSingleResult();
	}

	@Override
	public Symptomquestion findByWeight(Double weight) {
		final String query = "SELECT a FROM Symptomquestion a WHERE a.sympquesWeight = " + weight;
		return (Symptomquestion) entityManager.createQuery(query).getSingleResult();
	}

}
