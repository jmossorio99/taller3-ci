package com.ossorio.barrera.taller4.test.delegate;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ossorio.barrera.taller4.Taller4;
import com.ossorio.barrera.taller4.delegate.implementation.UsvInstitutionDelegateImpl;
import com.ossorio.barrera.taller4.model.UsvInstitution;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Taller4.class)
@RestClientTest(UsvInstitutionDelegateImpl.class)
public class UsvInstitutionsDelegateTest{

    @Autowired
    private UsvInstitutionDelegateImpl usvInstitutionDelegate;

    @Autowired
    private RestTemplate restTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private MockRestServiceServer mockRestServiceServer;

    @Before
    public void init(){
        mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);

    }

    @Test
    public void findByIdTest(){
        final UsvInstitution institution1 = new UsvInstitution();
        institution1.setInstId(0);
        institution1.setInstAcademicserverurl("https://url.com");
        institution1.setInstAcadextradataurl("https://url.com");
        institution1.setInstAcadloginurl("https://url.com");
        institution1.setInstAcadpersoninfoidurl("https://url.com");
        institution1.setInstAcadphysicalspacesurl("https://url.com");
        institution1.setInstLdapurl("https://url.com");
        institution1.setInstName("Institution 1126");
        String json = "";
        try {
            json = this.objectMapper.writeValueAsString(institution1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        this.mockRestServiceServer
                .expect(requestTo("/institutions/0"))
                .andRespond(withSuccess(json, MediaType.APPLICATION_JSON));

        UsvInstitution result = usvInstitutionDelegate.findById(0L);

        assertEquals("Institution 1126", result.getInstName());
    }

}