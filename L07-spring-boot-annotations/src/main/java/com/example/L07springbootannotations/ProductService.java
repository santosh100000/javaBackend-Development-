package com.example.L07springbootannotations;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private Integer nextId = 1;

    private List<Product> dataStore = new ArrayList<>();

    public ProductService() {
        dataStore.add(new Product(nextId, "laptop"));
        nextId++;
    }

    public List<Product> getAllProducts(){
        return dataStore;
    }



    public Product createProducts(Product product){
        product.setId(nextId);
        nextId++;
        dataStore.add(product);
        return product;
    }
}
