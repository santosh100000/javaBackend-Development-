package com.example.L11UnitTestdemo.controller;


import com.example.L11UnitTestdemo.service.AOPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AOPDemoController {

    @Autowired
    private AOPService aopService;

    @GetMapping
    public ResponseEntity<String> getData(){
        return ResponseEntity.ok(aopService.getData());
    }
}
