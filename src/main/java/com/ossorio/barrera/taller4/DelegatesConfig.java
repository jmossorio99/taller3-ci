package com.ossorio.barrera.taller4;

import com.ossorio.barrera.taller4.delegate.implementation.*;
import com.ossorio.barrera.taller4.delegate.interfaces.*;
import com.ossorio.barrera.taller4.model.Sympweightbyday;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DelegatesConfig {

    @Bean
    public UsvInstitutionDelegate usvInstitutionDelegate() {
        return new UsvInstitutionDelegateImpl();
    }

    @Bean
    public SymptompollDelegate symptompollDelegate() {
        return new SymptompollDelegateImpl();
    }

    @Bean
    public SymptomquestionDelegate symptomquestionDelegate() {
        return new SymptomquestionDelegateImp();
    }

    @Bean
    public SymptomWeightDelegate symptomWeightDelegate() {
        return new SymptomWeightDelegateImp();
    }

    @Bean
    public PersonDelegate personDelegate(){
        return new PersonDelegateImpl();
    }

    @Bean
    public SymptomDelegate symptomDelegate() {
        return new SymptomDelegateImpl();
    }

    @Bean
    public EpidemeventDelegate epidemeventDelegate(){
        return new EpidemeventDelegateImpl();
    }

    @Bean
    public PersonFenceDelegate personFenceDelegate(){
        return new PersonFenceDelegateImpl();
    }

    @Bean
    public ContactfenceDelegate contactfenceDelegate(){
        return new ContactfenceDelegateImpl();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
