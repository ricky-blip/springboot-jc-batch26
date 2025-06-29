package com.juaracoding.rrspringboot4.example;

public class ContohThrow {
	public static void main(String[] args) {
		try {
			execute(13);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("kode berjalan dengan benar");
	}

	private static void execute(Integer x ) throws InterruptedException{
		Thread.sleep(1000L);
	}
}
