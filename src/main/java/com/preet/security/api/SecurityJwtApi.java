package com.preet.security.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api")
@Slf4j
public class SecurityJwtApi {

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
            request.getParameter("user");
            String userName = (String) request.getAttribute("userName");
            log.info("userName : {} authenticated successfully", userName);
            return ResponseEntity.ok().body("Token authenticated successfully");
    }
}
