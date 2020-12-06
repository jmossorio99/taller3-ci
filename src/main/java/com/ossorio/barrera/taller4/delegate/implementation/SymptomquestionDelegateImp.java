package com.ossorio.barrera.taller4.delegate.implementation;

import com.ossorio.barrera.taller4.delegate.interfaces.SymptomquestionDelegate;
import com.ossorio.barrera.taller4.model.Symptomquestion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class SymptomquestionDelegateImp implements SymptomquestionDelegate {

    private final String SERVER = "https://localhost:8081/";
    private final RestTemplate restTemplate;

    public SymptomquestionDelegateImp(){
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<Symptomquestion> getAll() {
        try{
            ResponseEntity<Symptomquestion[]> response = restTemplate.getForEntity(SERVER + "questions/", Symptomquestion[].class);
            return  Arrays.asList(response.getBody());
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Symptomquestion findById(Long id) {
        return restTemplate.getForObject(SERVER + "questions/" + id, Symptomquestion.class);
    }

    @Override
    public Symptomquestion save(Symptomquestion symptomquestion, Long symptomId, Long pollId) {
        return restTemplate.postForObject(SERVER + "questions/", symptomquestion, Symptomquestion.class);
    }

    @Override
    public Symptomquestion update(Symptomquestion symptomquestion, Long symptomId, Long pollId) {
        restTemplate.put(SERVER+ "questions/", symptomquestion, Symptomquestion.class);
        return symptomquestion;
    }

    @Override
    public void delete(Symptomquestion symptomquestion) {
        restTemplate.delete(SERVER + "questions/" + symptomquestion.getSympquesId());
    }
}
