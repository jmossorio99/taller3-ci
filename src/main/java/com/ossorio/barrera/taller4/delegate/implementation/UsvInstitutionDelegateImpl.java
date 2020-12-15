package com.ossorio.barrera.taller4.delegate.implementation;

import com.ossorio.barrera.taller4.delegate.interfaces.UsvInstitutionDelegate;
import com.ossorio.barrera.taller4.model.UsvInstitution;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class UsvInstitutionDelegateImpl implements UsvInstitutionDelegate {

    private final String SERVER = "http://localhost:8080/institutions/";
    RestTemplate restTemplate;

    public UsvInstitutionDelegateImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<UsvInstitution> findAll() {
        try {
            List<UsvInstitution> institutions = Arrays.asList(restTemplate.getForObject(SERVER, UsvInstitution[].class));
            return institutions;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UsvInstitution findById(Long id) {
        UsvInstitution institution = restTemplate.getForObject(SERVER + id, UsvInstitution.class);
        return institution;
    }

    @Override
    public UsvInstitution findByName(String name) {
        UsvInstitution institution = restTemplate.getForObject(SERVER + name, UsvInstitution.class);
        return institution;
    }

    @Override
    public UsvInstitution save(UsvInstitution institution) {
        return restTemplate.postForEntity(SERVER, institution, UsvInstitution.class).getBody();
    }

    @Override
    public UsvInstitution update(UsvInstitution institution) {
        restTemplate.put(SERVER, institution, UsvInstitution.class);
        return institution;
    }

    @Override
    public UsvInstitution delete(UsvInstitution institution) {
        restTemplate.delete(SERVER, institution, UsvInstitution.class);
        return institution;
    }
}
