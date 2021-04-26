package com.ttsr.persist;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Product {

    private int id;
    private String title;
    private BigDecimal cost;

}
