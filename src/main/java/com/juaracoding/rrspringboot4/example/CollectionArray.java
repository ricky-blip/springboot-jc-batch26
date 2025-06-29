package com.juaracoding.rrspringboot4.example;

public class CollectionArray {
	public static void main(String[] args) {
		ClassStudent [] csArr = new ClassStudent[2];
		csArr[0] = new ClassStudent("Paul","Bogor");
		csArr[1] = new ClassStudent("Kevin","Jakarta");

		StringBuilder sBuild = new StringBuilder();
		String s = sBuild.
				append("A").append(1).append("B").append(2).append("C").toString();
		sBuild.setLength(0);
		String c = new StringBuilder().append("v").append("h").toString();

		System.out.println(csArr[0]);
		System.out.println(csArr[0].getNama());
		System.out.println(csArr[0].getAlamat());
		System.out.println("========================");
		System.out.println(csArr[1]);
		System.out.println(csArr[1].getNama());
		System.out.println(csArr[1].getAlamat());
		csArr = null;
		System.out.println(csArr[0]);
		System.out.println(csArr[0].getNama());
		System.out.println(csArr[0].getAlamat());
		System.out.println("========================");
		System.out.println(csArr[1]);
		System.out.println(csArr[1].getNama());
		System.out.println(csArr[1].getAlamat());
	}
}
