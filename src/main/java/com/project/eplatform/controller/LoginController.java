package com.project.eplatform.controller;

import com.project.eplatform.service.LoginService;
import com.project.eplatform.service.configuration.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final LoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<?> customerLogin(@RequestParam("email") String email,@RequestParam("password") String password){
        boolean isAuthenticated = loginService.login(email,password);
        if(isAuthenticated){
            String token = UUID.randomUUID().toString();
            return ResponseEntity.ok().body(new AuthenticationResponse(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
