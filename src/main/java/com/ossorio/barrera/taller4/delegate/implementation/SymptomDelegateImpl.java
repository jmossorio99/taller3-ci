package com.ossorio.barrera.taller4.delegate.implementation;

import com.ossorio.barrera.taller4.delegate.interfaces.SymptomDelegate;
import com.ossorio.barrera.taller4.model.Symptom;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class SymptomDelegateImpl implements SymptomDelegate {

    private final String SERVER = "http://localhost:8080/symptoms/";
    RestTemplate restTemplate;

    public SymptomDelegateImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public Symptom findById(Long id) {
        return restTemplate.getForObject(SERVER + id, Symptom.class);
    }

    @Override
    public List<Symptom> findAll() {
        return Arrays.asList(restTemplate.getForObject(SERVER, Symptom[].class));
    }

    @Override
    public Symptom save(Symptom symptom) {
        return restTemplate.postForEntity(SERVER, symptom, Symptom.class).getBody();
    }

    @Override
    public Symptom update(Symptom symptom){
        restTemplate.put(SERVER, symptom, Symptom.class);
        return symptom;
    }

    @Override
    public void delete(Symptom symptom) {
        restTemplate.delete(SERVER, symptom, Symptom.class);
    }
}
