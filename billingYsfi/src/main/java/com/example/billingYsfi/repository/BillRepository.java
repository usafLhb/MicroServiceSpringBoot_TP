package com.example.billingYsfi.repository;

import com.example.billingYsfi.entity.Bill;
import com.example.billingYsfi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill,Long> {
//@RestResource(path="/byCustomersId")
List<Bill> findByCustomerId(Long customerId);
}
