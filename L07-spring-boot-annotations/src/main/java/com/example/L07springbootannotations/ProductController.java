package com.example.L07springbootannotations;

import org.gfg.analyzer.KeywordAnalyzerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Value("${company.name}")
    private String companyName;

    @Autowired
//    @Qualifier("keywordAnalyzerImpl") , if we want to use bean of other than primary or not bean is annoated primary
    private KeywordAnalyzerInterface keywordAnalyzerInterface;

    @Autowired
    private ProductService productService;

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>>  getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

//    @PostMapping("/addProducts")
//    public


    @GetMapping("/keywords")
    public ResponseEntity<List<String>> getAllKeywords(@RequestParam String keyword){
        keywordAnalyzerInterface.recordKeyword(keyword);
        return ResponseEntity.ok(keywordAnalyzerInterface.getAllKeyword());
    }


    @GetMapping("/getName")
    public ResponseEntity<String> getCompanyName(){
        return ResponseEntity.ok(companyName);
    }
}
