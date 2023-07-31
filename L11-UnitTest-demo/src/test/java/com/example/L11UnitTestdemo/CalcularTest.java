package com.example.L11UnitTestdemo;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalcularTest {

    private  Calculator calculator;

    @BeforeEach
            public void setUp(){
        calculator = new Calculator();
    }


    @Test
    public void TestMultiply(){
        Integer a =3;
        Integer b =5;
        Integer resultExpected = 15;
//        calculator.multiply(a, b);
        assertThat(calculator.multiply(a, b)).isEqualTo(resultExpected);
    }

    @Test
    public void TestAdd(){
        Integer a =3;
        Integer b =5;
        Integer resultExpected = 8;
//        calculator.multiply(a, b);
        assertThat(calculator.add(a, b)).isEqualTo(resultExpected);
    }

}
