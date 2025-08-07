package com.example.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.PaymentService.entity.PaymentRequest;

@FeignClient(name = "payment-service")
public interface PaymentClient {
	 @PostMapping("/payments")
	    String processPayment(@RequestBody PaymentRequest request);
}
