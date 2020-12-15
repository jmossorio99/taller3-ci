package com.ossorio.barrera.taller4.test.delegate;

import com.ossorio.barrera.taller4.delegate.implementation.UsvInstitutionDelegateImpl;
import com.ossorio.barrera.taller4.model.Symptomquestion;
import com.ossorio.barrera.taller4.model.UsvInstitution;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest()
public class UsvInstitutionsDelegateTest{

    private final String SERVER = "http://localhost:8080/institutions/";

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    @Autowired
    private UsvInstitutionDelegateImpl usvInstitutionDelegate;

    @Before
    public void beforeTest(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveTest(){
        final UsvInstitution institution1 = new UsvInstitution();
        institution1.setInstId(0);
        institution1.setInstAcademicserverurl("https://url.com");
        institution1.setInstAcadextradataurl("https://url.com");
        institution1.setInstAcadloginurl("https://url.com");
        institution1.setInstAcadpersoninfoidurl("https://url.com");
        institution1.setInstAcadphysicalspacesurl("https://url.com");
        institution1.setInstLdapurl("https://url.com");
        institution1.setInstName("Institution 1126");

        Mockito.when(restTemplate.getForObject(SERVER + institution1.getInstId(), UsvInstitution.class)).thenReturn(institution1);
        Mockito.when(restTemplate.postForEntity(SERVER, institution1, UsvInstitution.class)).thenReturn(new ResponseEntity<UsvInstitution>(institution1, HttpStatus.OK));

        usvInstitutionDelegate.save(institution1);

        UsvInstitution institution2 = usvInstitutionDelegate.findById(institution1.getInstId());

        assertEquals(institution1, institution2);
    }

    @Test
    public void findAllTest(){
        final UsvInstitution institution1 = new UsvInstitution();
        institution1.setInstId(0);
        institution1.setInstAcademicserverurl("https://url.com");
        institution1.setInstAcadextradataurl("https://url.com");
        institution1.setInstAcadloginurl("https://url.com");
        institution1.setInstAcadpersoninfoidurl("https://url.com");
        institution1.setInstAcadphysicalspacesurl("https://url.com");
        institution1.setInstLdapurl("https://url.com");
        institution1.setInstName("Institution 1126");

        final UsvInstitution institution2 = new UsvInstitution();
        institution2.setInstId(1);
        institution2.setInstAcademicserverurl("https://url.com");
        institution2.setInstAcadextradataurl("https://url.com");
        institution2.setInstAcadloginurl("https://url.com");
        institution2.setInstAcadpersoninfoidurl("https://url.com");
        institution2.setInstAcadphysicalspacesurl("https://url.com");
        institution2.setInstLdapurl("https://url.com");
        institution2.setInstName("Institution 1127");

        UsvInstitution[] mockList = {institution1, institution2};

        Mockito.when(restTemplate.getForObject(SERVER, UsvInstitution[].class)).thenReturn(mockList);


        List<UsvInstitution> institutions = usvInstitutionDelegate.findAll();

        assertEquals(institution1, institutions.get(0));
        assertEquals(institution2, institutions.get(1));

        Mockito.verify(restTemplate, Mockito.times(1)).getForObject(ArgumentMatchers.eq(SERVER), ArgumentMatchers.eq(UsvInstitution[].class));
    }

    @Test
    public void updateTest(){
        final UsvInstitution inst = new UsvInstitution();

        UsvInstitution updatedInst = inst;
        updatedInst.setInstName("updated name");

        Mockito.when(restTemplate.getForObject(SERVER + updatedInst.getInstId(), UsvInstitution.class)).thenReturn(updatedInst);

        Mockito.doNothing().when(restTemplate).put(SERVER, inst, UsvInstitution.class);

        usvInstitutionDelegate.update(updatedInst);

        Assert.assertEquals(updatedInst.getInstName(), usvInstitutionDelegate.findById(inst.getInstId()).getInstName());

        Mockito.verify(restTemplate, Mockito.times(1)).put(ArgumentMatchers.eq(SERVER),ArgumentMatchers.eq(inst), ArgumentMatchers.eq(UsvInstitution.class));
    }


    @Test
    public void deleteTest(){
        final UsvInstitution institution1 = new UsvInstitution();
        institution1.setInstId(0);
        institution1.setInstAcademicserverurl("https://url.com");
        institution1.setInstAcadextradataurl("https://url.com");
        institution1.setInstAcadloginurl("https://url.com");
        institution1.setInstAcadpersoninfoidurl("https://url.com");
        institution1.setInstAcadphysicalspacesurl("https://url.com");
        institution1.setInstLdapurl("https://url.com");
        institution1.setInstName("Institution 1126");


        Mockito.doNothing().when(restTemplate).delete(SERVER, institution1, UsvInstitution.class);

        usvInstitutionDelegate.delete(institution1);
        Mockito.verify(restTemplate, Mockito.times(1)).delete(ArgumentMatchers.eq(SERVER),ArgumentMatchers.eq(institution1), ArgumentMatchers.eq(UsvInstitution.class));
    }

}