package com.juaracoding.rrspringboot4.repo;

import com.juaracoding.rrspringboot4.model.KategoriProduk;
import com.juaracoding.rrspringboot4.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {

	Page<Supplier> findByNamaContainsIgnoreCase(String nama, Pageable pageable);
	Page<Supplier> findByAlamatContainsIgnoreCase(String nama, Pageable pageable);

	List<Supplier> findByNamaContainsIgnoreCase(String nama);
	List<Supplier> findByAlamatContainsIgnoreCase(String nama);

}
