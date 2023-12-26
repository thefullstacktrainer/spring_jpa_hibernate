package com.excelr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class EmployeeController {
	@GetMapping("/")
	public String main() {
		return "dashboard";
	}

}
