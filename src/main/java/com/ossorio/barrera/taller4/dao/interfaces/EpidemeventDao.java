package com.ossorio.barrera.taller4.dao.interfaces;

import com.ossorio.barrera.taller4.model.Epidemevent;

import java.util.List;

public interface EpidemeventDao {

    Epidemevent save(Epidemevent epidemevent);

    List<Epidemevent> findAll();

    Epidemevent findById(Long id);

    void delete(Epidemevent epidemevent);

}
