package com.ossorio.barrera.taller4.test.delegate;

import com.ossorio.barrera.taller4.delegate.implementation.EpidemeventDelegateImpl;
import com.ossorio.barrera.taller4.model.Epidemevent;
import com.ossorio.barrera.taller4.model.UsvInstitution;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void findAllTest(){
        Epidemevent epidemevent = new Epidemevent();
        epidemevent.setEpieveId(1);
        Epidemevent epidemevent2 = new Epidemevent();
        epidemevent.setEpieveId(2);

        Epidemevent[] epidemevents = {epidemevent, epidemevent2};

        Mockito.when(restTemplate.postForEntity(SERVER, epidemevent, Epidemevent.class)).thenReturn(new ResponseEntity<>(epidemevent, HttpStatus.OK));
        Mockito.when(restTemplate.postForEntity(SERVER, epidemevent2, Epidemevent.class)).thenReturn(new ResponseEntity<>(epidemevent2, HttpStatus.OK));

        Mockito.when(restTemplate.getForObject(SERVER, Epidemevent[].class)).thenReturn(epidemevents);

        delegate.save(epidemevent);
        delegate.save(epidemevent2);

        List<Epidemevent> epidemevents2 = delegate.findAll();

        Assert.assertEquals(epidemevents2.size(), epidemevents.length);
    }

    @Test
    public void deleteTest(){

        Epidemevent epidemevent = new Epidemevent();
        epidemevent.setEpieveId(1);

        Mockito.doNothing().when(restTemplate).delete(SERVER, epidemevent, Epidemevent.class);

        delegate.delete(epidemevent);

        Mockito.verify(restTemplate, Mockito.times(1)).delete(ArgumentMatchers.eq(SERVER),ArgumentMatchers.eq(epidemevent), ArgumentMatchers.eq(Epidemevent.class));

    }

    @Test
    public void saveTest(){

        Epidemevent epidemevent = new Epidemevent();
        epidemevent.setEpieveId(1);

        Mockito.when(restTemplate.postForEntity(SERVER, epidemevent, Epidemevent.class)).thenReturn(new ResponseEntity<>(epidemevent, HttpStatus.OK));
        Mockito.when(restTemplate.getForObject(SERVER + epidemevent.getEpieveId(), Epidemevent.class)).thenReturn(epidemevent);

        delegate.save(epidemevent);

        Assert.assertEquals(epidemevent, delegate.findById(epidemevent.getEpieveId()));

    }

}
