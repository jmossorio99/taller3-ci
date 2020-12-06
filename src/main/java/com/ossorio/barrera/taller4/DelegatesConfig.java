package com.ossorio.barrera.taller4;

import com.ossorio.barrera.taller4.delegate.implementation.UsvInstitutionDelegateImp;
import com.ossorio.barrera.taller4.delegate.interfaces.UsvInstitutionDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DelegatesConfig {

    @Bean
    public UsvInstitutionDelegate usvInstitutionDelegate(){
        return new UsvInstitutionDelegateImp();
    }

}
