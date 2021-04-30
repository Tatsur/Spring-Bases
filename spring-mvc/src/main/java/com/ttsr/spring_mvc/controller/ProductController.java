package com.ttsr.spring_mvc.controller;

import com.ttsr.spring_mvc.dto.Product;
import com.ttsr.spring_mvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
@Log4j2
public class ProductController {

    private final ProductService productService;

    @RequestMapping("/add")
    public String showProductForm(){
        return "product/add";
    }
    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product){
        productService.add(product);
        return "redirect:../product";
    }

    @GetMapping
    @ModelAttribute("products")
    public List<Product> showProducts(){
        return productService.findAll();
    }
}
