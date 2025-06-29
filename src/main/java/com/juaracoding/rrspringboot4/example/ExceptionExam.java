package com.juaracoding.rrspringboot4.example;

public class ExceptionExam {
	public static void main(String[] args) {

		int x = 0;

		try {
			x= 1/0;

			System.out.println("Proses Selesai");
		} catch (Exception e) {
			System.out.println("Masuk ke Catch");
			return;
		}finally {
			System.out.println("Di Print !!");
			// digunakan untuk menutup koneksi atau awal proses
		}

		String [] strArr = {"x","y"};
		System.out.println(strArr[3]);
	}
}
