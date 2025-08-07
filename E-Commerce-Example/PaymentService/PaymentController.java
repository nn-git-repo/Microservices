package com.example.PaymentService.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PaymentService.entity.PaymentRequest;


	@RestController
	@RequestMapping("/payments")
	public class PaymentController {

	    @PostMapping
	    public String processPayment(@RequestBody PaymentRequest request) {
	        // Simulating payment success
	        return "SUCCESS";
	    }
	}


