package com.ossorio.barrera.taller4.service.implementation;

import com.ossorio.barrera.taller4.dao.imp.ContactfenceDaoImpl;
import com.ossorio.barrera.taller4.model.Contactfence;
import com.ossorio.barrera.taller4.service.interfaces.ContactfenceService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContactfenceServiceImpl implements ContactfenceService {

    private final ContactfenceDaoImpl dao;

    public ContactfenceServiceImpl(ContactfenceDaoImpl dao){
        this.dao = dao;
    }

    @Transactional
    @Override
    public Contactfence save(Contactfence cf) {
        return dao.save(cf);
    }

    @Transactional
    @Override
    public Contactfence findById(Long id) {
        return dao.findById(id);
    }

    @Transactional
    @Override
    public void delete(Contactfence cf) {
        dao.delete(cf);
    }

    @Transactional
    @Override
    public List<Contactfence> findAll() {
        return dao.findAll();
    }
}
