package com.ossorio.taller3.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ossorio.taller3.Taller3;
import com.ossorio.taller3.dao.interfaces.SymptompollDao;
import com.ossorio.taller3.model.Symptompoll;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller3.class)
public class UnitTests {

	@Autowired
	private SymptompollDao symptompollDao;

	@BeforeEach
	public void setup() {
		symptompollDao.save(new Symptompoll());
		symptompollDao.save(new Symptompoll());
	}

	@Test
	public void symptompollDaoFindAllTest() {
		System.out.println(symptompollDao);
		assertEquals(symptompollDao.findAll().size(), 2);
	}

	@Test
	public void symptompollDaoFindByIdTest() {
		assertTrue(true);
	}

	@Test
	public void symptompollDaoUpdateTest() {
		assertTrue(true);
	}

	@Test
	public void symptompollDaoFindByDateTest() {
		assertTrue(true);
	}

	@Test
	public void symptompollDaoFindByDateOrderedTest() {
		assertTrue(true);
	}

	@Test
	public void symptompollDaolistZeroWeightQuestionsTest() {
		assertTrue(true);
	}

}
