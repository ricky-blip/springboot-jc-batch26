package com.juaracoding.rrspringboot4.controller;

import com.juaracoding.rrspringboot4.example.ClassStudent;

import com.juaracoding.rrspringboot4.model.User;
import com.juaracoding.rrspringboot4.utils.ClassIOC;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
		try {
			classIOC.syncData();
		} catch (InterruptedException e) {
			System.out.println("Error "+e.getMessage());
		}
		return classIOC.getData()+random.nextInt(100)+"---"+cumiGoreng;
	}


	@GetMapping("datajson")
	public Map<String, Object> datajson(){
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

	/** JSON -> Content-Type : application/json */
	@PostMapping("/coba1")
	public String postCoba1(@Valid @RequestBody User user){

		System.out.println("User nya : "+ user.getUsername());
		System.out.println("Password nya : "+ user.getPassword());
		return "OK Test Coba 1";
	}

	//batch request
	/** Multipart -> Content-Type : multipart/form-data */
	@PostMapping("/coba2")
	public String postCoba2(
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam MultipartFile file){

		System.out.println("User nya : "+username);
		System.out.println("Password nya : "+password);
		System.out.println("file nya : "+file.getOriginalFilename());

		return "OK Test Coba 2";
	}

	/** Multipart -> Content-Type : multipart/form-data */
	@PostMapping("/coba3")
	public String postCoba3(
			@RequestParam(value = "user-name") String[] username,//JAVA ? ONTA camelCase
			@RequestParam String[] password,
			@RequestParam MultipartFile[] file){

		if(username.length != 0 && password.length != 0 && file.length != 0){
			int checkArr = username.length;
			if(checkArr < 5 ){
				if(password.length == checkArr && file.length == checkArr){
					for(int i = 0; i < checkArr; i++){
						System.out.println("User nya yang ke "+(i+1)+ username[i]);
						System.out.println("Password nya yang ke "+(i+1)+password[i]);
						System.out.println("File nya yang ke "+(i+1)+file[i].getOriginalFilename());
						System.out.println("==================");
					}
					return "OK Test Coba 3";
				}
			}
		}

		return "Gagal Test Coba 3";
	}

	@GetMapping("/coba4/{id}/{nama-lengkap}")
	public String getCoba4(
			@PathVariable Integer id,
			@PathVariable(value = "nama-lengkap") String namaLengkap
	){

		System.out.println("ID : "+ id);
		System.out.println("Nama Lengkap : "+ namaLengkap);
		return "OK Test Coba 4";
	}

	@GetMapping("/coba5")
	public String getCoba5(
			@RequestParam Long id,
			@RequestParam(value = "nama-lengkap") String namaLengkap,
			@RequestHeader String coba
	){

		System.out.println("ID : "+id);
		System.out.println("Nama Lengkap : "+namaLengkap);
		System.out.println("Coba Value : "+coba);
		return "OK Test Coba 5";
	}

}
