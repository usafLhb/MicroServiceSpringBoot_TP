package com.example.inventory.service;

import com.example.inventory.entity.Product;
import com.example.inventory.repository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class ProductService {
    private final repository postRepository;
    public void save(Product postRequest) {
       postRepository.save(postRequest);
    }
}
