package com.ttsr.persist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductRepo {
    private final AtomicInteger identity = new AtomicInteger(0);
    private final HashMap<Integer,Product> productMap = new HashMap<>();

    public void saveOrUpdate(Product product){
        if(product.getId() == 0){
           product.setId(identity.incrementAndGet());
        }
        productMap.put(product.getId(),product);
    }
    public List<Product> findAll() {
        return new ArrayList<>((productMap.values()));
    }
}
