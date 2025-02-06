package com.express.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.express.modelDTO.CustomerDTO;
import com.express.modelDTO.LoginDTO;
import com.express.service.CustomerService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin
@RestController
public class CustomerController {

		@Autowired
		private CustomerService customerService;
				
		@PostMapping("create/customer")
		public Object createCustomer(@RequestBody CustomerDTO customersDTO){		
			return customerService.addAllCustomers(customersDTO);	
		}
				
		@PostMapping("login")
		public Object getById(@RequestBody LoginDTO loginDTO) {
			return customerService.loginPage(loginDTO);
			
		}	
}
