package com.ossorio.barrera.taller4.dao.imp;

import com.ossorio.barrera.taller4.dao.interfaces.PersonFenceDao;
import com.ossorio.barrera.taller4.model.PersonFence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PersonFenceDaoImpl implements PersonFenceDao {

    @Autowired
    EntityManager entityManager;

    @Override
    public PersonFence save(PersonFence pf) {
        entityManager.persist(pf);
        return pf;
    }

    @Override
    public List<PersonFence> findAll() {
        final String jpql = "SELECT pf FROM PersonFence pf";
        return entityManager.createQuery(jpql).getResultList();
    }

    @Override
    public PersonFence findById(long id) {
        return entityManager.find(PersonFence.class, id);
    }

    @Override
    public PersonFence update(PersonFence pf) {
        entityManager.merge(pf);
        return pf;
    }

    @Override
    public PersonFence delete(PersonFence pf) {
        entityManager.remove(pf);
        return pf;
    }
}
