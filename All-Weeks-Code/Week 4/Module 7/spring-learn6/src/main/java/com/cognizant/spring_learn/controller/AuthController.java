package com.cognizant.spring_learn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Date;

@RestController
public class AuthController {

    private final String SECRET_KEY = "mySecretKey12345"; // Should be kept securely

    @RequestMapping(value = "/authenticate", method = RequestMethod.GET)
    public ResponseEntity<?> authenticate(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            return ResponseEntity.status(401).body("Missing or invalid Authorization header");
        }

        // Decode Basic Auth
        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String decodedCredentials = new String(decodedBytes);
        String[] parts = decodedCredentials.split(":", 2);

        String username = parts[0];
        String password = parts[1];

        // Hardcoded validation (replace with database/service lookup)
        if ("user".equals(username) && "pwd".equals(password)) {
            String token = Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10)) // 10 min expiry
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
                    .compact();

            return ResponseEntity.ok("{\"token\":\"" + token + "\"}");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
