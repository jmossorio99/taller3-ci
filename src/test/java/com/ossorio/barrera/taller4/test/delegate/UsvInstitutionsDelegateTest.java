package com.ossorio.barrera.taller4.test.delegate;

import com.ossorio.barrera.taller4.delegate.interfaces.UsvInstitutionDelegate;
import com.ossorio.barrera.taller4.model.UsvInstitution;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class UsvInstitutionsDelegateTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private UsvInstitutionDelegate instDelegate;


}
