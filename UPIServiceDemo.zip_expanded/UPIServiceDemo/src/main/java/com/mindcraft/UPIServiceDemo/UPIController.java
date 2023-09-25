package com.mindcraft.UPIServiceDemo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/upi")
public class UPIController {

	@Autowired
	RestTemplate template;
	
	@GetMapping(path="/getBalance", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> upiCheckBalance() {
//		GET: getForObject, POST: postForObject, PUT: putForObject
		Map<String, Object> map = template.getForObject("desktop-6brd481://ACCOUNT-SERVICE/api/account/balance", HashMap.class);
//		you will get a JSON like {balance: 6000} -> map
		map.put("name", "UPI App");
		return map;
		
	}
	
	@GetMapping(path="/123", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> Balance() {
//		GET: getForObject, POST: postForObject, PUT: putForObject
//		Map<String, Object> map = template.getForObject("http://ACCOUNT-SERVICE/api/account/balance", HashMap.class);
//		you will get a JSON like {balance: 6000} -> map
		Map<String, Object> map = new HashMap<>(); 
		map.put("name", "UPI App");
		
		return map;
		
	}
	
}
