package com.preet.security.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.AuthenticationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class SecurityJwtApiTest {

    @InjectMocks
    private SecurityJwtApi securityJwtApi;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;

    @Test
    public void testCheckTokenAuthorization() throws IOException {

        securityJwtApi.checkTokenAuthorization(request,response);
    }

}