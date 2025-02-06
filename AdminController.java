package com.express.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.express.modelDTO.AdminDTO;
import com.express.modelDTO.AdminLoginDTO;
import com.express.service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("create/admin")
	public Object createAdmin(@RequestBody AdminDTO	 adminDTO) {
		return adminService.createAdmin(adminDTO);		
	}
		
	@GetMapping("admin/login")
	public Object adminLogin(@RequestBody AdminLoginDTO adminLoginDTO) {
		return adminService.adminLogin(adminLoginDTO);
		
	}	
}
