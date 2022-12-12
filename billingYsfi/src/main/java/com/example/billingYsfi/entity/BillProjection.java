package com.example.billingYsfi.entity;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name="fullname",types = Bill.class)
public interface BillProjection {
    Long getId();
    Date getCreatedAt();
    Long getCustomerId();


}
