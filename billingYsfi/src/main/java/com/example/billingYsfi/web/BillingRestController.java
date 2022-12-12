package com.example.billingYsfi.web;

import com.example.billingYsfi.entity.Bill;
import com.example.billingYsfi.exeption.ProductItemNotFoundException;
import com.example.billingYsfi.feign.CustomerServiceClient;
import com.example.billingYsfi.feign.InventoryServiceClient;
import com.example.billingYsfi.model.Customer;
import com.example.billingYsfi.model.Product;
import com.example.billingYsfi.repository.BillRepository;
import com.example.billingYsfi.repository.ProductItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillingRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerServiceClient customerServiceClient;
    private InventoryServiceClient inventoryServiceClient;

    public BillingRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerServiceClient customerServiceClient, InventoryServiceClient inventoryServiceClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerServiceClient = customerServiceClient;
        this.inventoryServiceClient = inventoryServiceClient;
    }
    @GetMapping(path="fullBill/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Bill getBill(@PathVariable(name="id") Long id) throws ProductItemNotFoundException {
        Bill bill =billRepository.findById(id).get();

        Customer customer=customerServiceClient.findCustomerById(bill.getCustomerId());
        customerServiceClient.findAll().forEach(System.out::println);
        System.out.println(customer.getName());
        bill.setCustomer(customer);

        bill.getProductItems().forEach(pi->{
            System.out.println("id est "+pi.getId());
            Product product=inventoryServiceClient.getProductById(pi.getProductID());
            pi.setProduct(product);
            pi.setProductName(product.getName());
        });
       return bill;
    }
    @GetMapping(path="fullBill")
    public List<Bill> getAllorder() throws ProductItemNotFoundException {
        List<Bill> bill =billRepository.findAll();
        return bill;
    }

    @GetMapping(path="order/{id}")
    public List<Bill> getorder(@PathVariable(name="id") Long id) throws ProductItemNotFoundException {
        List<Bill> bill =billRepository.findByCustomerId(id);
        return bill;
    }

    @PostMapping(path="postProduct}")
    public ResponseEntity<Void> createPost(@RequestBody Product postRequest) {
        ResponseEntity product=inventoryServiceClient.save(postRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
