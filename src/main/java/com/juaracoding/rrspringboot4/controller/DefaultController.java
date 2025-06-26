package com.juaracoding.rrspringboot4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/")
public class DefaultController {
	@GetMapping
	public String getData(){
		return "Hello World";
	}
	@GetMapping("datajson")
	public Map<String, Object> datajson(){
		Map<String, Object> map = new HashMap<>();
		map.put("Data", "Hello World");
		map.put("Timestamp", System.currentTimeMillis());
		map.put("Version", "1.0.0");
		return map;
	}
}
