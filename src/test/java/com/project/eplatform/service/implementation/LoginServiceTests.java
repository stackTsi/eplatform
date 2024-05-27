package com.project.eplatform.service.implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.project.eplatform.model.Customer;
import com.project.eplatform.repository.CustomerRepository;
import com.project.eplatform.service.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTests {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private LoginServiceImpl loginService;

    private Customer customer;
    private final String email = "test@example.com";
    private final String password = "password123";
    private final String encodedPassword = "$2a$10$7QJ1DFQbJFE.zC7IaQ9wGu6.TyP9zF5PAlX/zEAXOrlRr7gD4mpR6"; // Example of a BCrypt encoded password

    @BeforeEach
    public void setUp() {
        customer = new Customer();
        customer.setEmail(email);
        customer.setPassword(encodedPassword);
    }

    @Test
    public void testLoginSuccessful() {
        when(customerRepository.findByEmail(email)).thenReturn(customer);
        when(passwordEncoder.matches(password, encodedPassword)).thenReturn(true);

        boolean result = loginService.login(email, password);

        assertTrue(result);
        verify(customerRepository, times(1)).findByEmail(email);
        verify(passwordEncoder, times(1)).matches(password, encodedPassword);
    }

    @Test
    public void testLoginUnsuccessfulIncorrectPassword() {
        when(customerRepository.findByEmail(email)).thenReturn(customer);
        when(passwordEncoder.matches(password, encodedPassword)).thenReturn(false);

        boolean result = loginService.login(email, password);

        assertFalse(result);
        verify(customerRepository, times(1)).findByEmail(email);
        verify(passwordEncoder, times(1)).matches(password, encodedPassword);
    }

    @Test
    public void testLoginUnsuccessfulCustomerNotFound() {
        when(customerRepository.findByEmail(email)).thenReturn(null);

        boolean result = loginService.login(email, password);

        assertFalse(result);
        verify(customerRepository, times(1)).findByEmail(email);
        verify(passwordEncoder, times(0)).matches(anyString(), anyString());
    }
}
