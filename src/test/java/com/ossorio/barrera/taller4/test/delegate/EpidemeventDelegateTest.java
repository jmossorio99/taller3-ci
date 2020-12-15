package com.ossorio.barrera.taller4.test.delegate;

import com.ossorio.barrera.taller4.delegate.implementation.EpidemeventDelegateImpl;
import com.ossorio.barrera.taller4.model.Epidemevent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest()
public class EpidemeventDelegateTest {

    private String SERVER = "http://localhost:8080/epidemevent/";

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    @Autowired
    private EpidemeventDelegateImpl delegate;

    @Before
    public void beforeTest(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByIdTest(){
        Epidemevent epidemevent = new Epidemevent();
        epidemevent.setEpieveId(1);
        Mockito.when(restTemplate.postForEntity(SERVER, epidemevent, Epidemevent.class)).thenReturn(new ResponseEntity<>(epidemevent, HttpStatus.OK));
        Mockito.when(restTemplate.getForObject(SERVER + "1", Epidemevent.class)).thenReturn(epidemevent);

        delegate.save(epidemevent);
        Epidemevent epidemevent1 = delegate.findById((long)1);

        Assert.assertEquals(epidemevent, epidemevent1);
    }

}
