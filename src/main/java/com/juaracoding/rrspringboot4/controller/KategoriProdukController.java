package com.juaracoding.rrspringboot4.controller;

import com.juaracoding.rrspringboot4.model.KategoriProduk;
import com.juaracoding.rrspringboot4.service.KategoriProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class KategoriProdukController {
	@Autowired
	KategoriProdukService kategoriProdukService;

	@PostMapping
	public Object save(@RequestBody KategoriProduk kategoriProduk){
		return kategoriProdukService.save(kategoriProduk);
	}
}
