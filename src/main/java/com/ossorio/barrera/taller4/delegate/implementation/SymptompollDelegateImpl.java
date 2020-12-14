package com.ossorio.barrera.taller4.delegate.implementation;

import com.ossorio.barrera.taller4.delegate.interfaces.SymptompollDelegate;
import com.ossorio.barrera.taller4.model.Symptompoll;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class SymptompollDelegateImpl implements SymptompollDelegate {

    private final String SERVER = "http://localhost:8080/symptompolls/";
    private final RestTemplate restTemplate;

    public SymptompollDelegateImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<Symptompoll> findAll() {
        try {
            return Arrays.asList(restTemplate.getForObject(SERVER, Symptompoll[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Symptompoll findById(Long id) {
        Symptompoll symptompoll = restTemplate.getForObject(SERVER + id, Symptompoll.class);
        return symptompoll;
    }

    @Override
    public List<Symptompoll> findByDate(String startDate, String endDate) {
        try {
            return Arrays.asList(restTemplate.getForObject(SERVER + "find-by-date?startDate=" + startDate + "&endDate=" + endDate, Symptompoll[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Symptompoll> findByDateOrdered(String date) {
        try {
            return Arrays.asList(restTemplate.getForObject(SERVER + "find-by-date-ordered?date=" + date, Symptompoll[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Symptompoll> listZeroWeightQuestions() {
        try {
            return Arrays.asList(restTemplate.getForObject(SERVER + "zero-questions", Symptompoll[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Symptompoll save(Symptompoll symptompoll) {
        return restTemplate.postForEntity(SERVER, symptompoll, Symptompoll.class).getBody();
    }

    @Override
    public Symptompoll update(Symptompoll symptompoll) {
        restTemplate.put(SERVER, symptompoll, Symptompoll.class);
        return symptompoll;
    }

    @Override
    public void delete(Symptompoll symptompoll) {
        restTemplate.delete(SERVER, symptompoll, Symptompoll.class);
    }
}
