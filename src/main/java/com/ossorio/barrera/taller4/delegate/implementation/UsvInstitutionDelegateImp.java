package com.ossorio.barrera.taller4.delegate.implementation;

import com.ossorio.barrera.taller4.delegate.interfaces.UsvInstitutionDelegate;
import com.ossorio.barrera.taller4.model.UsvInstitution;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class UsvInstitutionDelegateImp implements UsvInstitutionDelegate {

    private final String SERVER = "http://localhost:8081/";
    private final RestTemplate restTemplate;

    public UsvInstitutionDelegateImp() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<UsvInstitution> getAll() {
        try {
            List<UsvInstitution> institutions = Arrays.asList(restTemplate.getForObject(SERVER + "institutions", UsvInstitution[].class));
            return institutions;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UsvInstitution findById(Long id) {
        UsvInstitution institution = restTemplate.getForObject(SERVER + "institutions/" + id, UsvInstitution.class);
        return institution;
    }

    @Override
    public UsvInstitution findByName(String name) {
        UsvInstitution institution = restTemplate.getForObject(SERVER + "institutions/" + name, UsvInstitution.class);
        return institution;
    }

    @Override
    public UsvInstitution save(UsvInstitution institution) {
        return restTemplate.postForEntity(SERVER + "institutions/", institution, UsvInstitution.class).getBody();
    }

    @Override
    public UsvInstitution update(UsvInstitution institution) {
        restTemplate.put(SERVER + "institutions/", institution, UsvInstitution.class);
        return institution;
    }

    @Override
    public void delete(UsvInstitution institution) {
        restTemplate.delete(SERVER + "institutions/" + institution.getInstId());
    }
}
