package com.ossorio.barrera.taller4.delegate.implementation;

import com.ossorio.barrera.taller4.delegate.interfaces.SymptomWeightDelegate;
import com.ossorio.barrera.taller4.model.Sympweightbyday;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class SymptomWeightDelegateImp implements SymptomWeightDelegate {

    private final String SERVER = "http://localhost:8081/weights/";
    private final RestTemplate restTemplate;

    public SymptomWeightDelegateImp() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public Sympweightbyday save(Sympweightbyday sympweightbyday, Long questionId) {
        return restTemplate.postForObject(SERVER, sympweightbyday, Sympweightbyday.class);
    }

    @Override
    public Sympweightbyday update(Sympweightbyday sympweightbyday, Long questionId) {
        restTemplate.put(SERVER, sympweightbyday, Sympweightbyday.class);
        return sympweightbyday;
    }

    @Override
    public Sympweightbyday findById(Long id) {
        return restTemplate.getForObject(SERVER + id, Sympweightbyday.class);
    }

    @Override
    public void delete(Sympweightbyday sympweightbyday) {
        restTemplate.delete(SERVER,sympweightbyday, Sympweightbyday.class);
    }

    @Override
    public List<Sympweightbyday> getAll() {
        try{
           ResponseEntity<Sympweightbyday[]> response = restTemplate.getForEntity(SERVER, Sympweightbyday[].class);
           return Arrays.asList(response.getBody());
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
