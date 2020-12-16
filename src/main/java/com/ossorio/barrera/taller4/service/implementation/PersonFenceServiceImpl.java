package com.ossorio.barrera.taller4.service.implementation;

import com.ossorio.barrera.taller4.dao.interfaces.PersonFenceDao;
import com.ossorio.barrera.taller4.model.PersonFence;
import com.ossorio.barrera.taller4.service.interfaces.PersonFenceService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonFenceServiceImpl implements PersonFenceService {

    private final PersonFenceDao dao;

    public PersonFenceServiceImpl(PersonFenceDao dao){
        this.dao = dao;
    }

    @Transactional
    @Override
    public PersonFence save(PersonFence pf) {
        return dao.save(pf);
    }

    @Transactional
    @Override
    public List<PersonFence> findAll() {
        return dao.findAll();
    }

    @Override
    public PersonFence findById(long id) {
        return dao.findById(id);
    }

    @Override
    public PersonFence update(PersonFence pf) {
        return dao.update(pf);
    }

    @Override
    public PersonFence delete(PersonFence pf) {
        return dao.delete(pf);
    }
}
