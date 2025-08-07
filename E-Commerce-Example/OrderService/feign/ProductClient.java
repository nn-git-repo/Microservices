package com.example.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.productservice.entity.Product;

@FeignClient(name = "ProductService1")
public interface ProductClient {

	  @GetMapping("/products/{id}")
	    Product getProductById(@PathVariable String id);

	    @PutMapping("/products/{id}/reduceStock")
	    String reduceStock(@PathVariable String id, @RequestParam int qty);
}
