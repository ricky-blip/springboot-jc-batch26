package com.juaracoding.rrspringboot4.controller;

import com.juaracoding.rrspringboot4.example.ClassStudent;
import com.juaracoding.rrspringboot4.utils.ClassIOC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/")
public class DefaultController {
	@Autowired
	ClassIOC classIOC;

	@Autowired
	Random random;

	@Value("cumi.goreng")
	String cumiGoreng ;

	//localhost:8080
	@GetMapping
	public String getData(){
	//return "Hello World";
		try {
			classIOC.syncData();
		} catch (InterruptedException e) {
			System.out.println("Error "+e.getMessage());
		}
		return classIOC.getData()+random.nextInt(100)+"---"+cumiGoreng;
	}


	@GetMapping("datajson")
	public Map<String, Object> datajson(){
//		Map<String, Object> map = new HashMap<>();
//		map.put("Data", "Hello World");
//		map.put("Timestamp", System.currentTimeMillis());
//		map.put("Version", "1.0.0");
//		return map;
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("data", "Hello World");
		map.put("timestamp", System.currentTimeMillis());
		map.put("version",1);
		map.put("list",new ArrayList<String>());
		map.put("cs",new ClassStudent("Paul","Bogor"));
		for(Map.Entry<String,Object> entry : map.entrySet()){
			System.out.println("key "+entry.getKey()+" - value :"+entry.getValue());
		}
		return map;
	}
}
