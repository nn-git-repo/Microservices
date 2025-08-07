package com.example.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PaymentService.entity.PaymentRequest;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.feign.PaymentClient;
import com.example.orderservice.feign.ProductClient;
import com.example.productservice.entity.Product;

@RestController
@RequestMapping("/orders")
public class OrderController {

	  @Autowired private ProductClient productClient;
	    @Autowired private PaymentClient paymentClient;

	    @PostMapping
	    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) {
	        Product product = productClient.getProductById(orderRequest.getProductId());
	        if (product.getStock() < orderRequest.getQuantity()) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient stock.");
	        }

	        double totalAmount = product.getPrice() * orderRequest.getQuantity();
	        String paymentStatus = paymentClient.processPayment(new PaymentRequest("O5001", totalAmount, "Credit Card"));

	        if ("SUCCESS".equals(paymentStatus)) {
	            productClient.reduceStock(product.getProductId(), orderRequest.getQuantity());
	            return ResponseEntity.ok("Order Confirmed! Total Amount: $" + totalAmount);
	        } else {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment Failed.");
	        }
	    }
}
