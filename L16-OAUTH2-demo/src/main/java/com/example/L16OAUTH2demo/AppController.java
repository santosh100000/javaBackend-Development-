package com.example.L16OAUTH2demo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController

public class AppController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello from "+Thread.currentThread().getName());
    }

    @GetMapping("/user")
    public Map<String, Object> user(){
       OAuth2User user = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       Map<String, Object> response = new HashMap<>();
       response.put("name", user.getAttributes().get("name") );
       response.put("company", user.getAttributes().get("name"));
       return response;
    }

    @GetMapping("/user-details")
    public Map<String, Object> userDetails(){
        OAuth2User user = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getAttributes();
    }

}
