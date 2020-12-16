package com.ossorio.barrera.taller4.delegate.implementation;

import com.ossorio.barrera.taller4.delegate.interfaces.ContactfenceDelegate;
import com.ossorio.barrera.taller4.model.Contactfence;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class ContactfenceDelegateImpl implements ContactfenceDelegate {

    private final String SERVER = "http://localhost:8080/contactfences";
    RestTemplate restTemplate;

    public ContactfenceDelegateImpl(){
        this.restTemplate = new RestTemplate();
    }

    public Contactfence save(Contactfence cf){
        return restTemplate.postForEntity(SERVER, cf, Contactfence.class).getBody();
    }

    public Contactfence findById(Long id){
        return restTemplate.getForObject(SERVER + id, Contactfence.class);
    }

    public List<Contactfence> findAll(){
        return Arrays.asList(restTemplate.getForObject(SERVER, Contactfence[].class));
    }
}
