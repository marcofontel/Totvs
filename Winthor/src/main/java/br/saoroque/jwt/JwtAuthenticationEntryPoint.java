package br.saoroque.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
	public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);
	    @Override
	    public void commence(HttpServletRequest httpServletRequest,
	                         HttpServletResponse httpServletResponse,
	                         AuthenticationException e) throws IOException, ServletException {
	        logger.error("Responding with unauthorized error. Message - {}", e.getMessage());
	        if(e instanceof BadCredentialsException) {
	            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);


				// Result invalidUserNameOrPassword = ControllerUtils.buildErrorResult(101, "Incorrect account or password");
				String invalidUserNameOrPassword = "Incorrect account or password";

	            httpServletResponse.getOutputStream().write(new ObjectMapper()
	                    .writeValueAsBytes(invalidUserNameOrPassword));
	        } else {
	            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,
	                    "Unauthorized access");	                   
	        }
	    }
	}