package com.project.eplatform.service.implementation;

import com.project.eplatform.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class LoginServiceTests {
@Mock
CustomerRepository customerRepository;

@Mock
BCryptPasswordEncoder passwordEncoder;
    @Test
    void loginServiceTest(){




    }
}
