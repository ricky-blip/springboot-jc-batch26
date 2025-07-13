package com.juaracoding.rrspringboot4.repo;

import com.juaracoding.rrspringboot4.model.KategoriProduk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KategoriProdukRepo extends JpaRepository<KategoriProduk,Long> {

	//SELECT * FROM MstKategoriProduk WHERE toLower(nama) LIKE '%toLower(?)%'
	Page<KategoriProduk> findByNamaContainsIgnoreCase(String nama, Pageable pageable);
	//SELECT * FROM MstKategoriProduk WHERE toLower(nama) LIKE '%toLower(?)%'
	Page<KategoriProduk> findByDeskripsiContainsIgnoreCase(String nama, Pageable pageable);
	Page<KategoriProduk> findByNotesContainsIgnoreCase(String nama, Pageable pageable);

	/** ini khusus untuk report */
	List<KategoriProduk> findByNamaContainsIgnoreCase(String nama);
	//SELECT * FROM MstKategoriProduk WHERE toLower(nama) LIKE '%toLower(?)%'
	List<KategoriProduk> findByDeskripsiContainsIgnoreCase(String nama);
	List<KategoriProduk> findByNotesContainsIgnoreCase(String nama);
//    //SELECT * FROM MstKategoriProduk WHERE toLower(nama) LIKE '%toLower(?)%' OR toLower(deskripsi) LIKE '%toLower(?)%'
//    Page<KategoriProduk> findByNamaContainsIgnoreCaseOrDeskripsiContainsIgnoreCase(String nama,String deskripsi, Pageable pageable);

}