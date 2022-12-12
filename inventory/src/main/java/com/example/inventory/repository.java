package com.example.inventory;

import com.example.inventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface repository extends JpaRepository<Product,Long> {

}
