package com.example.L13redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private RedisTemplate<String, Product> redisTemplate;

    public Product createProduct(Product product){
        Long id = redisTemplate.opsForValue().increment("next:product:id");
        product.setId(id);
/*
      add Product to database
 */
        redisTemplate.opsForValue().set("product:"+id, product);
      return product;
    }

    public Product getProduct(Long id){
        String key = "product:"+id;
        Product product = redisTemplate.opsForValue().get(key);
    /*
   if product == null,
      read from db
     store in redis
        */
        return  product;
    }

    public Product deleteProduct(Long id) {
        String key = "product:"+id;
         /*
         Delete form database
          */
        Product product = redisTemplate.opsForValue().get(key);
       if(product != null){
           redisTemplate.delete(key);
       }
        return  product;
    }
}
