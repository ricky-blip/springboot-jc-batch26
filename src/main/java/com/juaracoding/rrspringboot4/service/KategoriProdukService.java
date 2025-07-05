package com.juaracoding.rrspringboot4.service;

import com.juaracoding.rrspringboot4.model.KategoriProduk;
import com.juaracoding.rrspringboot4.repo.KategoriProdukRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class KategoriProdukService {
	@Autowired
	private KategoriProdukRepo kategoriProdukRepo;

	public Object save(KategoriProduk kategoriProduk){

		kategoriProdukRepo.save(kategoriProduk);
		return "Data Berhasil Disimpan";
	}
}
