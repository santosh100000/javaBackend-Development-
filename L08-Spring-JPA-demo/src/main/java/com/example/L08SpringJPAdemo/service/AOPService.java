package com.example.L08SpringJPAdemo.service;

import org.springframework.stereotype.Service;

@Service
public class AOPService {

    public String getData(){
        return "Hello from AOP :"+ Thread.currentThread().getName();
    }
}
