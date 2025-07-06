package com.juaracoding.rrspringboot4.service;

import com.juaracoding.rrspringboot4.core.IService;
import com.juaracoding.rrspringboot4.core.IReport;
import com.juaracoding.rrspringboot4.dto.response.RespKategoriProdukDTO;
import com.juaracoding.rrspringboot4.dto.validasi.ValKategoriProdukDTO;
import com.juaracoding.rrspringboot4.model.KategoriProduk;
import com.juaracoding.rrspringboot4.repo.KategoriProdukRepo;
import com.juaracoding.rrspringboot4.utils.GlobalResponse;
import com.juaracoding.rrspringboot4.utils.LoggingFile;
import com.juaracoding.rrspringboot4.utils.TransformPagination;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Platform : Training -> TRN
 * Modul Code : 01
 * FV - FE --> fv = failed validation, fe = failed error
 */
@Service
@Transactional
public class KategoriProdukService implements IService<KategoriProduk>, IReport<KategoriProduk> {

	@Autowired
	private KategoriProdukRepo kategoriProdukRepo;

	@Autowired
	private ModelMapper modelMapper ;

	private String className = "KategoriProdukService";

	@Autowired
	private TransformPagination transformPagination;

	@Override
	public ResponseEntity<Object> save(KategoriProduk kategoriProduk, HttpServletRequest request) {
		if(kategoriProduk==null){
			return GlobalResponse.objectNull("TRN01FV001",request);
		}
		try{
			kategoriProdukRepo.save(kategoriProduk);
		}catch (Exception e){
			LoggingFile.logException(className,"save(KategoriProduk kategoriProduk, HttpServletRequest request) SQLException",e);
			return GlobalResponse.internalServerError("TRN01FE001",request);
		}

		return GlobalResponse.dataBerhasilDisimpan(request);
	}

	@Override
	public ResponseEntity<Object> update(Long id, KategoriProduk kategoriProduk, HttpServletRequest request) {
		if(kategoriProduk==null){
			return GlobalResponse.objectNull("TRN01FV011",request);
		}
		try{

		}catch (Exception e){
			return GlobalResponse.internalServerError("TRN01FE011",request);
		}
		return GlobalResponse.dataBerhasilDisimpan(request);
	}

	@Override
	public ResponseEntity<Object> delete(Long id, HttpServletRequest request) {
		return null;
	}

	@Override
	public ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request) {
		Page<KategoriProduk> pageData = null;
		Map<String,Object> mapResponse = null;
		try{
			pageData =  kategoriProdukRepo.findAll(pageable);
			if(pageData.isEmpty()){
				return GlobalResponse.dataTidakDitemukan("TRN01FV031",request);
			}
			mapResponse = transformPagination.transform(mapToModelMapper(pageData.getContent()),
					pageData,"id",null);

		}catch (Exception e){
			return GlobalResponse.internalServerError("TRN01FE031",request);
		}
		return GlobalResponse.dataDitemukan(mapResponse,request);
	}

	@Override
	public ResponseEntity<Object> findById(Long id, HttpServletRequest request) {
		return null;
	}

	@Override
	public ResponseEntity<Object> findByParam(Pageable pageable, String column, String value, HttpServletRequest request) {
		return null;
	}

	@Override
	public ResponseEntity<Object> uploadExcel(MultipartFile file, HttpServletRequest request) {
		return null;
	}

	@Override
	public List<KategoriProduk> convertListWorkBookToListEntity(List<Map<String, String>> workBookData, Long userId) {
		return List.of();
	}

	@Override
	public void downloadReportExcel(String column, String value, HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public void downloadReportPDF(String column, String value, HttpServletRequest request, HttpServletResponse response) {

	}

	/** cara manual untuk dto validasi request dalam bentuk single object */
	public KategoriProduk mapToModel(ValKategoriProdukDTO valKategoriProdukDTO){
		KategoriProduk kategoriProduk = new KategoriProduk();
		kategoriProduk.setNama(valKategoriProdukDTO.getNama());
		kategoriProduk.setDeskripsi(valKategoriProdukDTO.getDeskripsi());
		kategoriProduk.setNotes(valKategoriProdukDTO.getNotes());
		return kategoriProduk;
	}

	/** cara manual untuk dto response dalam bentuk multi object array */
	public List<RespKategoriProdukDTO> mapToModel(List<KategoriProduk> kategoriProdukList){
		List<RespKategoriProdukDTO> list = new ArrayList<RespKategoriProdukDTO>();
		for (KategoriProduk kategoriProduk : kategoriProdukList) {
			RespKategoriProdukDTO respKategoriProdukDTO = new RespKategoriProdukDTO();
			respKategoriProdukDTO.setId(kategoriProduk.getId());
			respKategoriProdukDTO.setNama(kategoriProduk.getNama());
			//respKategoriProdukDTO.setDeskripsi(kategoriProduk.getDeskripsi());
			list.add(respKategoriProdukDTO);
		}
		return list;
	}

	public KategoriProduk mapToModelMapper(ValKategoriProdukDTO valKategoriProdukDTO){
		return modelMapper.map(valKategoriProdukDTO, KategoriProduk.class);
	}
	public List<RespKategoriProdukDTO> mapToModelMapper(List<KategoriProduk> kategoriProdukList){
		return modelMapper.map(kategoriProdukList, new TypeToken<List<RespKategoriProdukDTO>>(){}.getType());
	}
}
