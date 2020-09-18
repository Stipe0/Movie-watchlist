package com.watchlist.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class IndexController {

	@GetMapping("/")
	public String indexPage() {
		return "index";
	}

	@GetMapping("/registration")
	public String register() {
		return "Registration";
	}

}
