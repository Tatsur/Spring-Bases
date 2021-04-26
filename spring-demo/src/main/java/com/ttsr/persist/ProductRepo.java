package com.ttsr.persist;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductRepo {

    private final AtomicInteger identity = new AtomicInteger(0);
    private final Map<Integer, Product> productMap = new ConcurrentHashMap<>();
    private static final int PRODUCT_INIT_COUNT = 5;

    public ProductRepo() {
        initProducts();
    }

    private void initProducts() {
        for (int i = 1; i <= PRODUCT_INIT_COUNT; i++) {
            saveOrUpdate(new Product(0, "Product" + i, new BigDecimal(i * 100)));
        }
    }

    public void saveOrUpdate(Product product) {
        if (product.getId() == 0) {
            product.setId(identity.incrementAndGet());
        }
        productMap.put(product.getId(), product);
    }

    public List<Product> findAll() {
        return new ArrayList<>((productMap.values()));
    }

    public Product getById(int id) {
        return productMap.get(id);
    }
}
