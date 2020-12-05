package com.ossorio.barrera.taller4.dao.imp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ossorio.barrera.taller4.dao.interfaces.SymptompollDao;
import com.ossorio.barrera.taller4.model.Symptompoll;

@Repository
public class SymptompollDaoImp implements SymptompollDao {

	@Autowired
	EntityManager entityManager;

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
	public Symptompoll save(Symptompoll symptompoll) {
		entityManager.persist(symptompoll);
		return symptompoll;
	}

	@Override
	public Symptompoll update(Symptompoll symptompoll) {
		entityManager.merge(symptompoll);
		return symptompoll;
	}

	@Override
	public List<Symptompoll> findByDate(Date startDate, Date endDate) {
		final String query = "SELECT a FROM Symptompoll a WHERE a.sympollStartdate <= :startDate AND a.sympollEnddate >= :endDate";
		return entityManager.createQuery(query).setParameter("startDate", startDate, TemporalType.DATE)
				.setParameter("endDate", endDate, TemporalType.DATE).getResultList();
	}

	@Override
	public List<Symptompoll> findByDateOrdered(Date date) {
//		final String query = "SELECT a FROM Symptompoll a WHERE :date BETWEEN a.sympollStartdate AND a.sympollEnddate ORDER BY a.sympollStartdate ASC";
		final String query = "SELECT a, (SELECT count(q) FROM Symptomquestion q WHERE q.symptompoll.sympollId=a.sympollId) FROM Symptompoll a WHERE :date BETWEEN a.sympollStartdate AND a.sympollEnddate ORDER BY a.sympollStartdate ASC";
		return entityManager.createQuery(query).setParameter("date", date, TemporalType.DATE).getResultList();
	}

	@Override
	public List<Symptompoll> listZeroWeightQuestions() {
		final String query = "SELECT a FROM Symptompoll a INNER JOIN a.symptomquestions question WHERE question.sympquesWeight = :weight";
//		final String query = "SELECT a FROM Symptompoll JOIN Symptomquestion q WHERE q.symptompoll.sympollId=a.sympollId AND q.sympquesWeight = 0";
		return entityManager.createQuery(query).setParameter("weight", BigDecimal.valueOf(0)).getResultList();
	}

}
