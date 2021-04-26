package com.ttsr.service;


import com.ttsr.persist.Product;
import com.ttsr.persist.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Cart implements CartService {

    private final ProductRepo productRepo;

    private final AtomicInteger identity = new AtomicInteger(0);
    private final Map<Integer, Product> productMap = new ConcurrentHashMap<>();

    @Autowired
    public Cart(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public void addById(int id) {
        Product product = productRepo.getById(id);
        productMap.put(identity.incrementAndGet(), product);
    }

    @Override
    public void deleteById(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> getCartList() {
        return new ArrayList<>(productMap.values());
    }
}
