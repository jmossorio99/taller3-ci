package com.ossorio.taller3.dao.imp;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ossorio.taller3.dao.interfaces.SymptompollDao;
import com.ossorio.taller3.model.Symptompoll;

@Repository
public class SymptompollDaoImp implements SymptompollDao {

	@Autowired
	private EntityManager entityManager;

//	public SymptompollDaoImp(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}

	@Override
	public void delete(Symptompoll symptompoll) {
		entityManager.remove(symptompoll);
	}

	@Override
	public List<Symptompoll> findAll() {
		final String jpql = "SELECT a FROM Symptompoll a";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public Symptompoll findById(long id) {
		return entityManager.find(Symptompoll.class, id);
	}

	@Override
	public void save(Symptompoll symptompoll) {
		entityManager.persist(symptompoll);
	}

	@Override
	public void update(Symptompoll symptompoll) {
		entityManager.merge(symptompoll);
	}

	@Override
	public List<Symptompoll> findByDate(Date startDate, Date endDate) {
		final String query = "SELECT a FROM Symptompoll a WHERE a.sympollStartdate <= :startDate AND a.sympollEnddate >= :endDate";
		return entityManager.createQuery(query).setParameter("startDate", startDate, TemporalType.DATE)
				.setParameter("endDate", endDate, TemporalType.DATE).getResultList();
	}

	@Override
	public List<Symptompoll> findByDateOrdered(Date date) {
		final String query = "SELECT a FROM Symptompoll a WHERE :date BETWEEN a.sympollStartdate AND a.sympollEnddate ORDER BY a.sympollStartdate ASC";
		return entityManager.createQuery(query).setParameter("date", date, TemporalType.DATE).getResultList();
	}

	@Override
	public List<Symptompoll> listZeroWeightQuestions(Date date) {
		final String query = "SELECT a FROM Symptompoll a JOIN a.symptomquestions question WHERE question.sympquesWeight = 0";
		return entityManager.createQuery(query).getResultList();
	}

}
