package com.juaracoding.rrspringboot4.repo;

import com.juaracoding.rrspringboot4.model.Produk;
import com.juaracoding.rrspringboot4.model.Produk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProdukRepo extends JpaRepository<Produk, Long> {

	Page<Produk> findByNamaContainsIgnoreCase(String nama, Pageable pageable);
	Page<Produk> findByDeskripsiContainsIgnoreCase(String nama, Pageable pageable);
	Page<Produk> findByModelContainsIgnoreCase(String nama, Pageable pageable);
	Page<Produk> findByWarnaContainsIgnoreCase(String nama, Pageable pageable);
	Page<Produk> findByMerkContainsIgnoreCase(String nama, Pageable pageable);
	@Query(value = "SELECT p FROM Produk p WHERE cast(p.stok as string) LIKE concat('%',?1,'%') ")
	Page<Produk> cariStok(String nama, Pageable pageable);

	List<Produk> findByNamaContainsIgnoreCase(String nama);
	List<Produk> findByDeskripsiContainsIgnoreCase(String nama);
	List<Produk> findByModelContainsIgnoreCase(String nama);
	List<Produk> findByWarnaContainsIgnoreCase(String nama);
	List<Produk> findByMerkContainsIgnoreCase(String nama);

	@Query(value = "SELECT p FROM Produk p WHERE cast(p.stok as string) LIKE concat('%',?1,'%') ")
	List<Produk> cariStok(String nama);

}
