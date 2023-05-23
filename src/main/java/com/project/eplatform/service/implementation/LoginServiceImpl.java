package com.project.eplatform.service.implementation;

import com.project.eplatform.model.Customer;
import com.project.eplatform.repository.CustomerRepository;
import com.project.eplatform.service.LoginService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean login(String email, String password) {
        Customer customer = customerRepository.findByEmail(email);
        if (customer!= null){
            String storedPassword = customer.getPassword();
            boolean passwordCheck = passwordEncoder.matches(password, storedPassword);
            return passwordCheck;
        }
        return false;
    }
}
