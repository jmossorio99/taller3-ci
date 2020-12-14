package com.ossorio.barrera.taller4.delegate.implementation;

import com.ossorio.barrera.taller4.delegate.interfaces.EpidemeventDelegate;
import com.ossorio.barrera.taller4.model.Epidemevent;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class EpidemeventDelegateImpl implements EpidemeventDelegate {

    private final String SERVER = "http://localhost:8081/epidemevent/";
    private final RestTemplate restTemplate;

    public EpidemeventDelegateImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public Epidemevent save(Epidemevent epidemevent) {
        return restTemplate.postForEntity(SERVER, epidemevent, Epidemevent.class).getBody();
    }

    @Override
    public List<Epidemevent> findAll() {
        try{
            return Arrays.asList(restTemplate.getForObject(SERVER, Epidemevent[].class));
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Epidemevent findById(Long id) {
        return restTemplate.getForObject(SERVER + id, Epidemevent.class);
    }

    @Override
    public void delete(Epidemevent epidemevent) {
        restTemplate.delete(SERVER, epidemevent, Epidemevent.class);
    }
}
