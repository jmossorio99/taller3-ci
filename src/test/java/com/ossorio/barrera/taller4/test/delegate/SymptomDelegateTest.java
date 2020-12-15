package com.ossorio.barrera.taller4.test.delegate;

import com.ossorio.barrera.taller4.delegate.implementation.SymptomDelegateImpl;
import com.ossorio.barrera.taller4.model.Symptom;
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

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest()
public class SymptomDelegateTest {

    private final String SERVER = "http://localhost:8080/symptoms/";

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    @Autowired
    private SymptomDelegateImpl delegate;

    @Before
    public void beforeTest(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveTest(){
        final Symptom s = new Symptom();
        s.setSympName("test symptom");

        Mockito.when(restTemplate.getForObject(SERVER + s.getSympId(), Symptom.class)).thenReturn(s);
        Mockito.when(restTemplate.postForEntity(SERVER, s, Symptom.class)).thenReturn(new ResponseEntity<Symptom>(s, HttpStatus.OK));

        delegate.save(s);
        Symptom result = delegate.findById(s.getSympId());

        assertEquals(s, result);
    }

    @Test
    public void findAllTest(){
        final Symptom s1 = new Symptom();
        final Symptom s2 = new Symptom();

        Symptom[] mockList = {s1, s2};

        Mockito.when(restTemplate.getForObject(SERVER, Symptom[].class)).thenReturn(mockList);

        List<Symptom> result = delegate.findAll();

        assertEquals(2, result.size());
    }

    @Test
    public void updateTest(){
        final Symptom s1 = new Symptom();
        s1.setSympId(1L);

        Mockito.when(restTemplate.getForObject(SERVER + 1L, Symptom.class)).thenReturn(s1);

        Mockito.doNothing().when(restTemplate).put(SERVER, s1, Symptom.class);

        delegate.update(s1);

        Assert.assertEquals(s1, delegate.findById(1L));
        Mockito.verify(restTemplate, Mockito.times(1)).put(ArgumentMatchers.eq(SERVER), ArgumentMatchers.eq(s1), ArgumentMatchers.eq(Symptom.class));
    }

    @Test
    public void deleteTest(){
        final Symptom s = new Symptom();

        Mockito.doNothing().when(restTemplate).delete(SERVER, s, Symptom.class);

        delegate.delete(s);
        Mockito.verify(restTemplate, Mockito.times(1)).delete(ArgumentMatchers.eq(SERVER), ArgumentMatchers.eq(s), ArgumentMatchers.eq(Symptom.class));
    }

}
