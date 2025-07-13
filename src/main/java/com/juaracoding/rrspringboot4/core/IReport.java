package com.juaracoding.rrspringboot4.core;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface IReport<G> {
	//angka-angka maksudnya untuk dokumentasi error code
	public ResponseEntity<Object> uploadExcel(MultipartFile file, HttpServletRequest request);//101-110
	public List<G> convertListWorkBookToListEntity(List<Map<String,String>> workBookData, Long userId);//111-120
	public Object downloadReportExcel(String column, String value, HttpServletRequest request, HttpServletResponse response);//121-130
	public Object downloadReportPDF(String column, String value, HttpServletRequest request, HttpServletResponse response);//131-140
}
