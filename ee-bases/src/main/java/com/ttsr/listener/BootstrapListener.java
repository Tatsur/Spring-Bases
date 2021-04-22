package com.ttsr.listener;

import com.ttsr.persist.Product;
import com.ttsr.persist.ProductRepo;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.math.BigDecimal;

@WebListener
public class BootstrapListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductRepo productRepo = new ProductRepo();
        for (int i = 1; i < 11; i++) {
            productRepo.saveOrUpdate(new Product(0,"Product "+i, new BigDecimal(i*100)));
        }
        sce.getServletContext().setAttribute("productRepo",productRepo);
    }
}
