package com.ttsr.spring_mvc.repository;

import com.ttsr.spring_mvc.dto.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepo {

    private static final AtomicLong identity = new AtomicLong(0L);
    private static final Map<Long, Product> productMap = new ConcurrentHashMap<>();
    private static final int PRODUCT_INIT_COUNT = 5;

    public ProductRepo() {
        initProducts();
    }

    private void initProducts() {
        for (int i = 1; i <= PRODUCT_INIT_COUNT; i++) {
            add(new Product(null, "Product" + i, new BigDecimal(i * 100)));
        }
    }

    public void add(Product product) {
        if (product.getId() == null) {
            product.setId(identity.incrementAndGet());
        }
        productMap.put(product.getId(), product);
    }

    public List<Product> findAll() {
        return new ArrayList<>((productMap.values()));
    }

    public Product findById(Long id) {
        return productMap.get(id);
    }
}
