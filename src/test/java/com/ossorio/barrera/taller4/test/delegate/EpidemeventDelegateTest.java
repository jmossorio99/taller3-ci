package com.ossorio.barrera.taller4.test.delegate;

import com.ossorio.barrera.taller4.Taller4;
import com.ossorio.barrera.taller4.delegate.implementation.EpidemeventDelegateImpl;
import com.ossorio.barrera.taller4.delegate.interfaces.EpidemeventDelegate;
import com.ossorio.barrera.taller4.model.Epidemevent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller4.class)
public class EpidemeventDelegateTest {

    @LocalServerPort
    private int port;

    private final String SERVER = "http://localhost:"+ port +"/epidemevent/";

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private EpidemeventDelegate delegate = new EpidemeventDelegateImpl(port);

    @Test
    public void findByIdTest(){
        Epidemevent epidemevent = new Epidemevent();
        epidemevent.setEpieveId(1);
        Mockito.when(restTemplate.getForEntity(SERVER + "1", Epidemevent.class)).thenReturn(new ResponseEntity<>(epidemevent, HttpStatus.OK));
        Epidemevent epidemevent1 = delegate.findById((long)1);
        Assertions.assertEquals(epidemevent, epidemevent1);
    }

}
