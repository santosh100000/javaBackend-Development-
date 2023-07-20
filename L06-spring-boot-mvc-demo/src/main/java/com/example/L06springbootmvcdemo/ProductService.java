package com.example.L06springbootmvcdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private static Logger LOGGER =  LoggerFactory.getLogger(ProductService.class);

    public List<Product> getAllProduct(){
        LOGGER.info("Processing getAll products");
        List<Product> list = new ArrayList<>();
        list.add(new Product(12, "macbook", 3600));
        list.add(new Product( 23,"laptop", 3600));
        list.add(new Product(1661, "Car", 10000));
        return list;
    }
}
