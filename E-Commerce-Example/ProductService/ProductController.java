package com.example.productservice.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.entity.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

	
	private Map<String, Product> productRepo = new HashMap<>();

    @PostMapping
    public String addProduct(@RequestBody Product product) {
        productRepo.put(product.getProductId(), product);
        return "Product added!";
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productRepo.get(id);
    }

    @PutMapping("/{id}/reduceStock")
    public String reduceStock(@PathVariable String id, @RequestParam int qty) {
        Product product = productRepo.get(id);
        if (product != null && product.getStock() >= qty) {
            product.setStock(product.getStock() - qty);
            return "Stock reduced!";
        } else {
            return "Insufficient stock!";
        }
    }

    @GetMapping
    public Collection<Product> getAllProducts() {
        return productRepo.values();
    }
}
