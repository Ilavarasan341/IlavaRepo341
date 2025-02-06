package com.express.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.express.modelDTO.PaymentDTO;
import com.express.service.PaymentService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("create/payment/{bookingId}")
	public Object createPayment(@PathVariable int bookingId ,@RequestBody PaymentDTO paymentDTO) {		
		return paymentService.createPayment(bookingId,paymentDTO);
		
	}
}
