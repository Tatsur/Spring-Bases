package com.ttsr.service;

import com.ttsr.persist.Product;

import java.util.List;

public interface CartService {

    void addById(int id);

    void deleteById(int id);

    List<Product> getCartList();
}
