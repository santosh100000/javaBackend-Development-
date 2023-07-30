package com.example.L11UnitTestdemo;

public class Calculator {
    public Integer multiply(Integer a, Integer b){
        Integer res = 0;
        for (int i = 1; i <=b; i++) {
            res = res +a;
            
        }
        return res;
    }

    public Integer add(Integer a, Integer b){
        Integer res = a + b;
        return res;
    }


}
