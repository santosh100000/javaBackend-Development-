package com.example.L06springbootmvcdemo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/app")
public class AppController {

    private static Logger LOGGER =  LoggerFactory.getLogger(AppController.class);

    //Request Params
    @GetMapping("/product")
    public ResponseEntity<Product> getProduct(@RequestParam String name){
          return ResponseEntity.ok(new Product( name, 10000));
    }

    //Path Params
    @GetMapping("/product-path-param/{id}")
    public ResponseEntity<Product> getProductWithPathParams(@PathVariable Integer id){
        return ResponseEntity.ok(new Product(id, "macbook", 3600));
    }

    //Request Body
    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        //LOGGER.info("Request Data: {}", product);

        System.out.println("Creating product "+ product);
        return ResponseEntity.ok().build();
    }



}
