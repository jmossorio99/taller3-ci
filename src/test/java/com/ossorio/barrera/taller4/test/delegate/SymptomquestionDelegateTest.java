package com.ossorio.barrera.taller4.test.delegate;

import com.ossorio.barrera.taller4.delegate.implementation.SymptomquestionDelegateImp;
import com.ossorio.barrera.taller4.model.Symptomquestion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest()
public class SymptomquestionDelegateTest {

    private String SERVER = "http://localhost:8080/questions/";

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    @Autowired
    private SymptomquestionDelegateImp delegate;

    @Before
    public void beforeTest(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByIdTest(){
        Symptomquestion sq = new Symptomquestion();
        sq.setSympquesId(1);

        Mockito.when(restTemplate.postForEntity(SERVER, sq, Symptomquestion.class)).thenReturn(new ResponseEntity<>(sq, HttpStatus.OK));
        Mockito.when(restTemplate.getForObject(SERVER + "1", Symptomquestion.class)).thenReturn(sq);

        delegate.save(sq);
        Symptomquestion testSq = delegate.findById((long)1);

        assertEquals(sq, testSq);
    }

    @Test
    public void findAllTest(){
        Symptomquestion sq = new Symptomquestion();
        sq.setSympquesId(1);
        Symptomquestion sq2 = new Symptomquestion();
        sq2.setSympquesId(2);

        Symptomquestion[] mockList = {sq, sq2};

        Mockito.when(restTemplate.getForObject(SERVER, Symptomquestion[].class)).thenReturn(mockList);

        List<Symptomquestion> result = delegate.findAll();

        assertEquals(2, result.size());
        assertEquals(sq, result.get(0));
        assertEquals(sq2, result.get(1));

        Mockito.verify(restTemplate, Mockito.times(1)).getForObject(ArgumentMatchers.eq(SERVER), ArgumentMatchers.eq(Symptomquestion[].class));
    }

    @Test
    public void updateTest(){
        Symptomquestion sq = new Symptomquestion();
        sq.setSympquesId(1);
        sq.setSympquesName("test name");

        Mockito.when(restTemplate.postForEntity(SERVER, sq, Symptomquestion.class)).thenReturn(new ResponseEntity<>(sq, HttpStatus.OK));
        delegate.save(sq);
        Symptomquestion updateSq = sq;
        updateSq.setSympquesName("updated test name");

        Mockito.when(restTemplate.getForObject(SERVER + updateSq.getSympquesId(), Symptomquestion.class)).thenReturn(updateSq);

        Mockito.doNothing().when(restTemplate).put(SERVER, sq, Symptomquestion.class);

        delegate.update(updateSq);

        Assert.assertEquals(updateSq.getSympquesName(), delegate.findById(sq.getSympquesId()).getSympquesName());

        Mockito.verify(restTemplate, Mockito.times(1)).put(ArgumentMatchers.eq(SERVER),ArgumentMatchers.eq(sq), ArgumentMatchers.eq(Symptomquestion.class));
    }

    @Test
    public void deleteTest(){
        Symptomquestion sq = new Symptomquestion();
        sq.setSympquesName("test name");

        Mockito.doNothing().when(restTemplate).delete(SERVER, sq, Symptomquestion.class);

        delegate.delete(sq);
        Mockito.verify(restTemplate, Mockito.times(1)).delete(ArgumentMatchers.eq(SERVER),ArgumentMatchers.eq(sq), ArgumentMatchers.eq(Symptomquestion.class));
    }


}
