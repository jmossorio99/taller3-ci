package com.ossorio.barrera.taller4.delegate.interfaces;

import com.ossorio.barrera.taller4.model.Epidemevent;

public interface EpidemeventDelegate {

    Epidemevent save(Epidemevent epidemevent);

    Iterable<Epidemevent> findAll();

    Epidemevent findById(Long id);

    void delete(Epidemevent epidemevent);

    void setPort(int port);

}
