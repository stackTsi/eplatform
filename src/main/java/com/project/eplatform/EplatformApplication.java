package com.project.eplatform;

import com.project.eplatform.model.Customer;
import com.project.eplatform.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@Component
public class EplatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(EplatformApplication.class, args);
    }

@Bean
    CommandLineRunner run(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(new Customer(0,"nguyen","asdf","Vo Ngoc Duy Nguyen","123@gmail.com","613","PhamTheHien","TP.HCM","50000","0919990145"));
        };

    }


}