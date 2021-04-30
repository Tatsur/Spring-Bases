package com.ttsr.spring_mvc.service;

import com.ttsr.spring_mvc.dto.Product;
import com.ttsr.spring_mvc.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductService {

    private final ProductRepo productRepo;

    public void add(Product product){
        log.debug("Adding product..");
        productRepo.add(product);
    }

    public List<Product> findAll(){
        log.debug("Looking for products...");
        return productRepo.findAll();
    }

    public Product findById(Long id){
        log.debug("Looking for product...");
        return productRepo.findById(id);
    }
}
