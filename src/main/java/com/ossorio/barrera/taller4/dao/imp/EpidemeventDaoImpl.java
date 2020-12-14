package com.ossorio.barrera.taller4.dao.imp;

import com.ossorio.barrera.taller4.dao.interfaces.EpidemeventDao;
import com.ossorio.barrera.taller4.model.Epidemevent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EpidemeventDaoImpl implements EpidemeventDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Epidemevent save(Epidemevent epidemevent) {
        entityManager.persist(epidemevent);
        return epidemevent;
    }

    @Override
    public List<Epidemevent> findAll() {
        final String jpql = "SELECT a FROM Epidemevent a";
        return entityManager.createQuery(jpql).getResultList();
    }

    @Override
    public Epidemevent findById(Long id) {
        return entityManager.find(Epidemevent.class, id);
    }

    @Override
    public void delete(Epidemevent epidemevent) {
        entityManager.remove(epidemevent);
    }
}
