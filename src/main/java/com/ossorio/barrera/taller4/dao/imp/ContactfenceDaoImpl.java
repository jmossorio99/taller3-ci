package com.ossorio.barrera.taller4.dao.imp;

import com.ossorio.barrera.taller4.dao.interfaces.ContactFenceDao;
import com.ossorio.barrera.taller4.model.Contactfence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ContactfenceDaoImpl implements ContactFenceDao {

    @Autowired
    EntityManager entityManager;

    public Contactfence save(Contactfence cf){
        entityManager.persist(cf);
        return cf;
    }

    @Override
    public List<Contactfence> findAll(){
        final String jpql = "SELECT a FROM Contactfence a";
        return entityManager.createQuery(jpql).getResultList();
    }

    @Override
    public Contactfence findById(Long id){
        return entityManager.find(Contactfence.class, id);
    }

    public void delete(Contactfence cf){
        entityManager.remove(cf);
    }
}
