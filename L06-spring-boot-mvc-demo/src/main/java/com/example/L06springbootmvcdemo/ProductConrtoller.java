package com.example.L06springbootmvcdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductConrtoller {

    private static Logger LOGGER =  LoggerFactory.getLogger(ProductConrtoller.class);
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProduct(){
        LOGGER.info("from controller");
        List<Product> response = productService.getAllProduct();
        return ResponseEntity.ok(response);
    }
}
