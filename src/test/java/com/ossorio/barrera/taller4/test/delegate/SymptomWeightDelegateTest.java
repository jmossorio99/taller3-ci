package com.ossorio.barrera.taller4.test.delegate;

import com.ossorio.barrera.taller4.delegate.implementation.EpidemeventDelegateImpl;
import com.ossorio.barrera.taller4.delegate.implementation.SymptomWeightDelegateImp;
import com.ossorio.barrera.taller4.model.Epidemevent;
import com.ossorio.barrera.taller4.model.Sympweightbyday;
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

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest()
public class SymptomWeightDelegateTest {

    private final String SERVER = "http://localhost:8080/weights/";

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    @Autowired
    private SymptomWeightDelegateImp delegate;

    @Before
    public void beforeTest(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByIdTest(){
        Sympweightbyday sympweightbyday = new Sympweightbyday();
        sympweightbyday.setSympweidaysId(1);

        Mockito.when(restTemplate.getForObject(SERVER + "1", Sympweightbyday.class)).thenReturn(sympweightbyday);

        Sympweightbyday sympweightbyday1 = delegate.findById((long)1);

        Assert.assertEquals(sympweightbyday, sympweightbyday1);
    }

    @Test
    public void findAllTest(){
        Sympweightbyday sympweightbyday = new Sympweightbyday();
        sympweightbyday.setSympweidaysId(1);
        Sympweightbyday sympweightbyday1 = new Sympweightbyday();
        sympweightbyday.setSympweidaysId(2);

        Sympweightbyday[] sympweightbydays = {sympweightbyday, sympweightbyday1};

        Mockito.when(restTemplate.getForObject(SERVER, Sympweightbyday[].class)).thenReturn(sympweightbydays);

        List<Sympweightbyday> sympweightbydays2 = delegate.findAll();

        Assert.assertEquals(sympweightbydays2.size(), sympweightbydays.length);
    }

    @Test
    public void deleteTest(){

        Sympweightbyday sympweightbyday = new Sympweightbyday();
        sympweightbyday.setSympweidaysId(1);

        Mockito.doNothing().when(restTemplate).delete(SERVER, sympweightbyday, Sympweightbyday.class);

        delegate.delete(sympweightbyday);

        Mockito.verify(restTemplate, Mockito.times(1)).delete(ArgumentMatchers.eq(SERVER),ArgumentMatchers.eq(sympweightbyday), ArgumentMatchers.eq(Sympweightbyday.class));

    }

    @Test
    public void saveTest(){

        Sympweightbyday sympweightbyday = new Sympweightbyday();
        sympweightbyday.setSympweidaysId(1);

        Mockito.when(restTemplate.postForEntity(SERVER, sympweightbyday, Sympweightbyday.class)).thenReturn(new ResponseEntity<>(sympweightbyday, HttpStatus.OK));
        Mockito.when(restTemplate.getForObject(SERVER + sympweightbyday.getSympweidaysId(), Sympweightbyday.class)).thenReturn(sympweightbyday);

        delegate.save(sympweightbyday);

        Assert.assertEquals(sympweightbyday, delegate.findById(sympweightbyday.getSympweidaysId()));

    }

    @Test
    public void updateTest(){

        Sympweightbyday sympweightbyday = new Sympweightbyday();
        sympweightbyday.setSympweidaysId(1);

        Mockito.doNothing().when(restTemplate).put(SERVER, sympweightbyday, Sympweightbyday.class);

        delegate.update(sympweightbyday);

        Mockito.verify(restTemplate, Mockito.times(1)).put(ArgumentMatchers.eq(SERVER),ArgumentMatchers.eq(sympweightbyday), ArgumentMatchers.eq(Sympweightbyday.class));
    }

}
