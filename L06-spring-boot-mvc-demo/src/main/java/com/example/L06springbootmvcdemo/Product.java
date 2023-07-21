package com.example.L06springbootmvcdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Integer id;

    private String name;

    private double cost;

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
}
