package com.ossorio.barrera.taller4.test.delegate;

import com.ossorio.barrera.taller4.delegate.implementation.SymptompollDelegateImpl;
import com.ossorio.barrera.taller4.model.Epidemevent;
import com.ossorio.barrera.taller4.model.Symptompoll;
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
public class SymptompollDelegateTest {

    private String SERVER = "http://localhost:8080/symptompolls/";

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    @Autowired
    SymptompollDelegateImpl symptompollDelegate;

    @Before
    public void beforeTest(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByIdTest(){
        Symptompoll symptompoll = new Symptompoll();
        symptompoll.setSympollId(1);

        Mockito.when(restTemplate.getForObject(SERVER + "1", Symptompoll.class)).thenReturn(symptompoll);

        Symptompoll symptompoll1 = symptompollDelegate.findById((long)1);

        Assert.assertEquals(symptompoll, symptompoll1);
    }

    @Test
    public void findAllTest(){
        Symptompoll symptompoll = new Symptompoll();
        symptompoll.setSympollId(1);
        Symptompoll symptompoll1 = new Symptompoll();
        symptompoll1.setSympollId(2);

        Symptompoll[] symptompolls = {symptompoll, symptompoll1};

        Mockito.when(restTemplate.postForEntity(SERVER, symptompoll, Symptompoll.class)).thenReturn(new ResponseEntity<>(symptompoll, HttpStatus.OK));
        Mockito.when(restTemplate.postForEntity(SERVER, symptompoll1, Symptompoll.class)).thenReturn(new ResponseEntity<>(symptompoll1, HttpStatus.OK));

        Mockito.when(restTemplate.getForObject(SERVER, Symptompoll[].class)).thenReturn(symptompolls);

        symptompollDelegate.save(symptompoll);
        symptompollDelegate.save(symptompoll1);

        List<Symptompoll> symptompolls2 = symptompollDelegate.findAll();

        Assert.assertEquals(symptompolls2.size(), symptompolls.length);
    }

    @Test
    public void deleteTest(){

        Symptompoll symptompoll = new Symptompoll();
        symptompoll.setSympollId(1);

        Mockito.doNothing().when(restTemplate).delete(SERVER, symptompoll, Symptompoll.class);

        symptompollDelegate.delete(symptompoll);

        Mockito.verify(restTemplate, Mockito.times(1)).delete(ArgumentMatchers.eq(SERVER),ArgumentMatchers.eq(symptompoll), ArgumentMatchers.eq(Symptompoll.class));

    }

    @Test
    public void saveTest(){

        Symptompoll symptompoll = new Symptompoll();
        symptompoll.setSympollId(1);

        Mockito.when(restTemplate.postForEntity(SERVER, symptompoll, Symptompoll.class)).thenReturn(new ResponseEntity<>(symptompoll, HttpStatus.OK));
        Mockito.when(restTemplate.getForObject(SERVER + symptompoll.getSympollId(), Symptompoll.class)).thenReturn(symptompoll);

        symptompollDelegate.save(symptompoll);

        Assert.assertEquals(symptompoll, symptompollDelegate.findById(symptompoll.getSympollId()));

    }

}
