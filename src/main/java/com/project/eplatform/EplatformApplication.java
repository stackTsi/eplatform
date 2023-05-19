package com.project.eplatform;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@Component
public class EplatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(EplatformApplication.class, args);
    }



}