package com.example.actvite33.repository;

import com.example.actvite33.enitity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface repositoryCustomer extends JpaRepository<Customer,Long> {
}
