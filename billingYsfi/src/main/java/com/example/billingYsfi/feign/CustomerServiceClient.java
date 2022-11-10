package com.example.billingYsfi.feign;

import com.example.billingYsfi.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customer-service")
public interface CustomerServiceClient {
    @GetMapping("/customers/{id}?projection=fullCustomer")
    Customer findCustomerById(@PathVariable("id") Long id);
    @GetMapping("/customers")
    Customer getCustomerById(@PathVariable(name="id") Long id);
}
