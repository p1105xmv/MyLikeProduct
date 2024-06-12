package com.myProduct.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/")
	public String test() {
		return "Test";
	}
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("/create")
	public String search() {
		return "create";
	}

}