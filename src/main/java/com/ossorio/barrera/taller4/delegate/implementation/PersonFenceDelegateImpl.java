package com.ossorio.barrera.taller4.delegate.implementation;

import com.ossorio.barrera.taller4.delegate.interfaces.PersonDelegate;
import com.ossorio.barrera.taller4.delegate.interfaces.PersonFenceDelegate;
import com.ossorio.barrera.taller4.model.PersonFence;
import com.ossorio.barrera.taller4.model.PersonFencePK;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class PersonFenceDelegateImpl implements PersonFenceDelegate {

    private final String SERVER = "http://localhost:8080/personfences/";
    RestTemplate restTemplate;

    public PersonFenceDelegateImpl(){
        this.restTemplate = new RestTemplate();
    }

    @Override
    public PersonFence save(PersonFence pf) {
        return restTemplate.postForEntity(SERVER,pf, PersonFence.class).getBody();
    }

    @Override
    public PersonFence update(PersonFence pf) {
        restTemplate.put(SERVER, pf, PersonFence.class);
        return pf;
    }

    @Override
    public void delete(PersonFencePK id) {
        restTemplate.delete(SERVER, id);
    }

    @Override
    public List<PersonFence> findAll() {
        return Arrays.asList(restTemplate.getForObject(SERVER, PersonFence[].class));
    }

    @Override
    public PersonFence findById(Long id) {
        return restTemplate.getForObject(SERVER + id, PersonFence.class);
    }
}
