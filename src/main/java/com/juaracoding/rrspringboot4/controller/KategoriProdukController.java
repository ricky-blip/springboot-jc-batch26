package com.juaracoding.rrspringboot4.controller;

import com.juaracoding.rrspringboot4.dto.validasi.ValKategoriProdukDTO;
import com.juaracoding.rrspringboot4.service.KategoriProdukService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("kategoriproduk")
public class KategoriProdukController {
	@Autowired
	KategoriProdukService kategoriProdukService;

	@PostMapping
	@PreAuthorize("hasAuthority('Kategori-Produk')")
	public Object save(@Valid @RequestBody ValKategoriProdukDTO valKategoriProdukDTO,
	                   HttpServletRequest request){
		return kategoriProdukService.save(kategoriProdukService.mapToModelMapper(valKategoriProdukDTO),request);
	}
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('Kategori-Produk')")
	public Object update(
			@PathVariable Long id,
			@Valid @RequestBody ValKategoriProdukDTO valKategoriProdukDTO,
			HttpServletRequest request){
		return kategoriProdukService.update(id,kategoriProdukService.mapToModelMapper(valKategoriProdukDTO),request);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('Kategori-Produk')")
	public Object delete(
			@PathVariable Long id,
			HttpServletRequest request){
		return kategoriProdukService.delete(id,request);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('Kategori-Produk')")
	public Object findById(
			@PathVariable Long id,
			HttpServletRequest request){
		return kategoriProdukService.findById(id,request);
	}

	@PostMapping("/upload-excel")
	@PreAuthorize("hasAuthority('Kategori-Produk')")
	public Object uploadExcel(
			@RequestParam MultipartFile file,
			HttpServletRequest request){
//        return kategoriProdukService.uploadExcel(file,request);
		return kategoriProdukService.uploadExcelManual(file,request);
	}

	@GetMapping
	@PreAuthorize("hasAuthority('Kategori-Produk')")
	public Object findAll(HttpServletRequest request){
		Pageable pageable = PageRequest.of(0,50, Sort.by("id"));
		return kategoriProdukService.findAll(pageable,request);
	}

	/**
	 * Fungsional API ini untuk Filter maupun Sorting
	 * @param request
	 * @return
	 */
	@GetMapping("/{sort}/{sort-by}/{page}")
	@PreAuthorize("hasAuthority('Kategori-Produk')")
	public Object findByParam(
			@PathVariable Integer page,
			@PathVariable(value = "sort-by") String sortBy,
			@PathVariable String sort,
			@RequestParam Integer size,
			@RequestParam String column,
			@RequestParam String value,
			HttpServletRequest request){
		if(sort.length()>4){

		}
		Pageable pageable = null;
//        if(sortBy.equals("umur")){
//            sort=sort.equals("asc")?"desc":"asc";
//        }
		sortBy = switchColumnSorting(sortBy);//sudah di filter agar aplikasi tidak error

		if(sort.equals("asc")){
			pageable = PageRequest.of(page,size, Sort.by(sortBy));
		}else {
			pageable = PageRequest.of(page,size, Sort.by(sortBy).descending());
		}
		return kategoriProdukService.findByParam(pageable,column,value,request);
	}
	//    http://localhost:8081/kategoriproduk/download-excel?column=id&size=2&value=aa
	@GetMapping("/download-excel")
	@PreAuthorize("hasAuthority('Kategori-Produk')")
	public Object downloadExcel(
			@RequestParam String column,
			@RequestParam String value,
			HttpServletRequest request,
			HttpServletResponse response){
		return kategoriProdukService.downloadReportExcel(column,value,request,response);
	}
	//    http://localhost:8081/kategoriproduk/download-excel-manual?column=id&size=2&value=aa
	@GetMapping("/download-excel-manual")
	@PreAuthorize("hasAuthority('Kategori-Produk')")
	public Object downloadExcelManual(
			@RequestParam String column,
			@RequestParam String value,
			HttpServletRequest request,
			HttpServletResponse response){
		return kategoriProdukService.downloadReportExcelManual(column,value,request,response);
	}

	//    http://localhost:8081/kategoriproduk/download-pdf?column=id&size=2&value=aa
	@GetMapping("/download-pdf")
	@PreAuthorize("hasAuthority('Kategori-Produk')")
	public Object downloadPDF(
			@RequestParam String column,
			@RequestParam String value,
			HttpServletRequest request,
			HttpServletResponse response){
		return kategoriProdukService.downloadReportPDF(column,value,request,response);
	}
	//    http://localhost:8081/kategoriproduk/download-pdf-manual?column=id&size=2&value=aa
	@GetMapping("/download-pdf-manual")
	@PreAuthorize("hasAuthority('Kategori-Produk')")
	public Object downloadPDFManual(
			@RequestParam String column,
			@RequestParam String value,
			HttpServletRequest request,
			HttpServletResponse response){
		return kategoriProdukService.downloadReportPDFManual(column,value,request,response);
	}

	private String switchColumnSorting(String sortBy){
		switch(sortBy){
			case "nama":sortBy = "nama";
			case "deskripsi":sortBy = "deskripsi";
//            case "umur":sortBy = "tanggalLahir";
			default:sortBy = "id";
		}
		return sortBy;
	}
}
