package com.landl.hcare.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    private static final Logger logger = LogManager.getLogger(JwtAuthenticationEntryPoint.class);
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        int internalErrorCode = 99;
        if(authException instanceof BadCredentialsException){
            internalErrorCode = 1;
            logger.debug("error_message: ");
            authException.printStackTrace();
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, String.valueOf(internalErrorCode));
    }
}