package com.ossorio.barrera.taller4;

import com.ossorio.barrera.taller4.delegate.implementation.SymptomWeightDelegateImp;
import com.ossorio.barrera.taller4.delegate.implementation.SymptompollDelegateImpl;
import com.ossorio.barrera.taller4.delegate.implementation.SymptomquestionDelegateImp;
import com.ossorio.barrera.taller4.delegate.implementation.UsvInstitutionDelegateImpl;
import com.ossorio.barrera.taller4.delegate.interfaces.SymptomWeightDelegate;
import com.ossorio.barrera.taller4.delegate.interfaces.SymptompollDelegate;
import com.ossorio.barrera.taller4.delegate.interfaces.SymptomquestionDelegate;
import com.ossorio.barrera.taller4.delegate.interfaces.UsvInstitutionDelegate;
import com.ossorio.barrera.taller4.model.Sympweightbyday;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

}
