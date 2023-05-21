package com.project.eplatform.controller;

import com.project.eplatform.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> customerLogin(@RequestParam("email") String email,@RequestParam("password") String password){
        boolean isAuthenticated = loginService.login(email,password);
        if(isAuthenticated){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
