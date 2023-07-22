package com.example.L07jdbcdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {



    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product){
        product= productService.createProducts(product);
        URI uri = null;
        try {
             uri = new URI("/product/"+product.getId());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
//        return ResponseEntity.created(uri).build();
        return ResponseEntity.created(uri).body(product);
    }


    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id){
        Product product = productService.getById(id);
        if(product ==null){
            return ResponseEntity.notFound().build();
        }return ResponseEntity.ok(product);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Integer id, @RequestBody Product product){
      Product product1 = productService.updateProduct(id, product);

       if(product1 != null){
           return ResponseEntity.ok(product);
       }
       return ResponseEntity.notFound().build();
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable(value = "id") Integer productId){
    Product product = productService.deleteProduct(productId);
        if(product == null){
        return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>>  getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }






}
