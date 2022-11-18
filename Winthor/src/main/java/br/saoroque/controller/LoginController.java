package br.saoroque.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.saoroque.controller.payloads.LoginPayload;
import br.saoroque.exception.ErrorDetails;
import br.saoroque.services.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/auth")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity getAllTabPedidos(@RequestBody LoginPayload usuario) {
        try {
            String token = userService.getToken(usuario);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (Exception e) {            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorDetails(new Date(), e.getMessage(), null));
            
        }
    }
}
