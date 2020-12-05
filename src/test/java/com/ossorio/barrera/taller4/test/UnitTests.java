package com.ossorio.barrera.taller4.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.ossorio.barrera.taller4.Taller4;
import com.ossorio.barrera.taller4.dao.interfaces.SymptompollDao;
import com.ossorio.barrera.taller4.dao.interfaces.SymptomquestionDao;
import com.ossorio.barrera.taller4.dao.interfaces.SympweightDao;
import com.ossorio.barrera.taller4.dao.interfaces.UsvInstitutionDao;
import com.ossorio.barrera.taller4.model.Symptompoll;
import com.ossorio.barrera.taller4.model.Symptomquestion;
import com.ossorio.barrera.taller4.model.Sympweightbyday;
import com.ossorio.barrera.taller4.model.UsvInstitution;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller4.class)
public class UnitTests {

	@Autowired
	private SymptompollDao symptompollDao;
	@Autowired
	private UsvInstitutionDao instDao;
	@Autowired
	private SympweightDao weightDao;
	@Autowired
	private SymptomquestionDao questionDao;

//	@Transactional
//	@BeforeEach
//	public void setup() {
//		symptompollDao.save(new Symptompoll());
//		symptompollDao.save(new Symptompoll());
//	}

	@Transactional
	@Test
	public void symptompollDaoFindAllTest() {
		assertNotNull(symptompollDao.findAll());
	}

	@Transactional
	@Test
	public void symptompollDaoFindByIdTest() {
		final Symptompoll symptompoll = new Symptompoll();
		symptompollDao.save(symptompoll);
		assertNotNull(symptompollDao.findById(symptompoll.getSympollId()));
	}

	@Transactional
	@Test
	public void symptompollDaoUpdateTest() {
		final Symptompoll symptompoll = new Symptompoll();
		symptompollDao.save(symptompoll);
		symptompoll.setSympollName("Hola");
		assertEquals(symptompollDao.update(symptompoll).getSympollName(), "Hola");
	}

	@Transactional
	@Test
	public void symptompollDaoFindByDateTest() {
		final Symptompoll symptompoll = new Symptompoll();
		symptompoll.setSympollName("xd");
		final Date startDate = new Date();
		startDate.setYear(2020);
		startDate.setMonth(2);
		final Date endDate = new Date();
		endDate.setYear(2020);
		endDate.setMonth(8);
		symptompoll.setSympollStartdate(startDate);
		symptompoll.setSympollEnddate(endDate);
		symptompollDao.save(symptompoll);
		assertTrue(symptompollDao.findByDate(startDate, endDate).size() != 0);
	}

	@Transactional
	@Test
	public void symptompollDaoFindByDateOrderedTest() {
		final Symptompoll symptompoll = new Symptompoll();
		symptompoll.setSympollName("xd");
		final Date startDate = new Date();
		startDate.setYear(2020);
		startDate.setMonth(2);
		symptompoll.setSympollStartdate(startDate);
		symptompollDao.save(symptompoll);
		assertNotNull(symptompollDao.findByDateOrdered(startDate));
	}

	@Transactional
	@Test
	public void symptompollDaolistZeroWeightQuestionsTest() {
		final Symptompoll symptompoll = new Symptompoll();
		symptompoll.setSympollName("xd");
		symptompoll.setSymptomquestions(new ArrayList<Symptomquestion>());
		final Symptomquestion question = new Symptomquestion();
		question.setSympquesWeight(BigDecimal.valueOf(0));
		symptompoll.addSymptomquestion(question);
		symptompollDao.save(symptompoll);
//		assertNotNull(symptompollDao.listZeroWeightQuestions());
		assertTrue(symptompollDao.listZeroWeightQuestions().size() != 0);
	}

	// Institution tests

	@Transactional
	@Test
	public void instDaoFindAllTest() {
		assertNotNull(instDao.findAll());
	}

	@Transactional
	@Test
	public void instDaoFindByIdTest() {
		final UsvInstitution inst = new UsvInstitution();
		instDao.save(inst);
		assertNotNull(instDao.findById(inst.getInstId()));
	}

	@Transactional
	@Test
	public void instDaoUpdateTest() {
		final UsvInstitution inst = new UsvInstitution();
		instDao.save(inst);
		inst.setInstName("Hola");
		assertEquals(instDao.update(inst).getInstName(), "Hola");
	}

	@Transactional
	@Test
	public void instDaoFindByName() {
		final UsvInstitution inst = new UsvInstitution();
		inst.setInstName("Hola");
		instDao.save(inst);
		assertNotNull(instDao.findByName("Hola"));
	}

	// Sympweight tests
	@Transactional
	@Test
	public void weightDaoFindAllTest() {
		assertNotNull(weightDao.findAll());
	}

	@Transactional
	@Test
	public void weightDaoFindByIdTest() {
		final Sympweightbyday weight = new Sympweightbyday();
		weightDao.save(weight);
		assertNotNull(weightDao.findById(weight.getSympweidaysId()));
	}

	@Transactional
	@Test
	public void weightDaoUpdateTest() {
		final Sympweightbyday weight = new Sympweightbyday();
		weightDao.save(weight);
		weight.setSympweidaysWeight(BigDecimal.valueOf(0));
		assertEquals(weightDao.update(weight).getSympweidaysWeight(), BigDecimal.valueOf(0));
	}

	// Symptomquestion tests
	@Transactional
	@Test
	public void questionDaoFindAllTest() {
		assertNotNull(questionDao.findAll());
	}

	@Transactional
	@Test
	public void questionDaoFindByIdTest() {
		final Symptomquestion question = new Symptomquestion();
		questionDao.save(question);
		assertNotNull(questionDao.findById(question.getSympquesId()));
	}

	@Transactional
	@Test
	public void questionDaoUpdateTest() {
		final Symptomquestion question = new Symptomquestion();
		questionDao.save(question);
		question.setSympquesName("hola");
		assertEquals(questionDao.update(question).getSympquesName(), "hola");
	}

	@Transactional
	@Test
	public void questionDaoFindByNameTest() {
		final Symptomquestion question = new Symptomquestion();
		question.setSympquesName("hola");
		questionDao.save(question);
		assertNotNull(questionDao.findByName("hola"));
	}

	@Transactional
	@Test
	public void questionDaoFindByWeightTest() {
		final Symptomquestion question = new Symptomquestion();
		question.setSympquesWeight(BigDecimal.valueOf(0));
		questionDao.save(question);
		assertNotNull(questionDao.findByWeight(BigDecimal.valueOf(0)));
	}

}
