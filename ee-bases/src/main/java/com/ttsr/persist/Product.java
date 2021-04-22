package com.ttsr.persist;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private int id;
    private String title;
    private BigDecimal cost;

    public Product(int id, String title, BigDecimal cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }
}
