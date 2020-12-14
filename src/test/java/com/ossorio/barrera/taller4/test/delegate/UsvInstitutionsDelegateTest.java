package com.ossorio.barrera.taller4.test.delegate;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ossorio.barrera.taller4.Taller4;
import com.ossorio.barrera.taller4.delegate.implementation.UsvInstitutionDelegateImpl;
import com.ossorio.barrera.taller4.model.UsvInstitution;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

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
    public void test(){
        final UsvInstitution institution1 = new UsvInstitution();
        institution1.setInstId(0);
        institution1.setInstAcademicserverurl("https://url.com");
        institution1.setInstAcadextradataurl("https://url.com");
        institution1.setInstAcadloginurl("https://url.com");
        institution1.setInstAcadpersoninfoidurl("https://url.com");
        institution1.setInstAcadphysicalspacesurl("https://url.com");
        institution1.setInstLdapurl("https://url.com");
        institution1.setInstName("Institution 1126");

        Mockito.when(restTemplate.postForEntity(SERVER, institution1, UsvInstitution.class)).thenReturn(new ResponseEntity<UsvInstitution>(institution1, HttpStatus.OK));
        Mockito.when(restTemplate.getForObject(SERVER + institution1.getInstId(), UsvInstitution.class)).thenReturn(institution1);

        usvInstitutionDelegate.save(institution1);

        UsvInstitution institution2 = usvInstitutionDelegate.findById(institution1.getInstId());

        assertEquals(institution1, institution2);
    }

//    @Autowired
//    private RestTemplate restTemplate;

//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    private MockRestServiceServer mockRestServiceServer;
//
//    @Before
//    public void init(){
//        mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
//
//    }
//
//    @Test
//    public void findByIdTest(){
//        final UsvInstitution institution1 = new UsvInstitution();
//        institution1.setInstId(0);
//        institution1.setInstAcademicserverurl("https://url.com");
//        institution1.setInstAcadextradataurl("https://url.com");
//        institution1.setInstAcadloginurl("https://url.com");
//        institution1.setInstAcadpersoninfoidurl("https://url.com");
//        institution1.setInstAcadphysicalspacesurl("https://url.com");
//        institution1.setInstLdapurl("https://url.com");
//        institution1.setInstName("Institution 1126");
//        String json = "";
//        try {
//            json = this.objectMapper.writeValueAsString(institution1);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//
//        this.mockRestServiceServer
//                .expect(requestTo("/institutions/0"))
//                .andRespond(withSuccess(json, MediaType.APPLICATION_JSON));
//
//        UsvInstitution result = usvInstitutionDelegate.findById(0L);
//
//        assertEquals("Institution 1126", result.getInstName());
//    }

}