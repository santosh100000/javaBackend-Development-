package com.example.L14springsecuritydemo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    @Value("${api.wait.time:400}")
    private Long apiWaitTime;


    private Map<Long,Product> dataStore = new HashMap<>();

     private Long nextId = 0l;


     @PostConstruct
     public void init(){
         Product product = new Product();
         product.setId(++nextId);
         product.setName("LAptop");
         product.setCost(40000.00);
         dataStore.put(product.getId(), product);

     }

    public Product createProduct(Product product){

        product.setId(++nextId);
        /*
          add product to database;
         */
       dataStore.put(product.getId(),product);
        return product;
    }

    public Product getProduct(Long id){

        Product product = dataStore.get(id);
        /*
        if product == null
            read from database
            store in redis
         */
        return product;
    }

    public Product deleteProduct(Long id){
        String key = "product:"+id;
        /*
         delete from DB;
         */
        Product product = dataStore.get(id);;
        if(product != null) {
            dataStore.remove(id);
        }
        return product;
    }

}
