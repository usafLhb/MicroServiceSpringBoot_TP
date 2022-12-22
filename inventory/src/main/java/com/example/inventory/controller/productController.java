package com.example.inventory.controller;

import com.example.inventory.entity.Product;
import com.example.inventory.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class productController {
    private final ProductService productService;
    @PostMapping("post")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> createPost(@RequestBody Product postRequest){
        System.out.println("postRequest "+postRequest);
        productService.save(postRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
