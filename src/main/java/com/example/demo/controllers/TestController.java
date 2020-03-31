package com.example.demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("test")
	public String test2() {
		return "test2";
	}

	@GetMapping("")
	public String get() {
		return "méthode GET";
	}

	@PostMapping("")
	public String post() {
		return "méthode POST";
	}

	@PutMapping("")
	public String put() {
		return "method PUT";
	}

	@DeleteMapping("")
	public String delete() {
		return "method DELETE";
	}
}
