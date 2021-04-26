package com.ttsr.spring;

import com.ttsr.persist.ProductRepo;
import com.ttsr.service.Cart;
import com.ttsr.service.CartService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"com.ttsr.service", "com.ttsr.persist"})
public class ComponentMainConfig {

    @Bean("cart")
    @Scope("prototype")
    public CartService cartService(ProductRepo productRepo) {
        return new Cart(productRepo);
    }
}
