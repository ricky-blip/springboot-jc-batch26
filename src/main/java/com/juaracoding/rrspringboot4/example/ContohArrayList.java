package com.juaracoding.rrspringboot4.example;

import java.util.ArrayList;
import java.util.List;

public class ContohArrayList {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		for (String str : list) {
			System.out.println(str);
		}
		System.out.println("==============");
		list.clear();
//        ArrayList<String> listX  = new ArrayList<>();
		list.add("X");
		list.add("Y");
		list.add("Z");
		list.add("H");
		for (String str : list) {
			System.out.println(str);
		}

		List<ClassStudent> acs = new ArrayList<>();
		acs.add(new ClassStudent("A", "B"));
		acs.add(new ClassStudent("B", "C"));
		acs.add(new ClassStudent("C", "D"));
		System.out.println(acs);
		System.out.println(acs.get(0));
		System.out.println(acs.get(0).getNama());
		System.out.println(acs.get(0).getAlamat());
		System.out.println("=======");
		acs.get(0).setNama("Paul");
		acs.get(0).setAlamat("Bogor");
		System.out.println(acs.get(0));
		System.out.println(acs.get(0).getNama());
		System.out.println(acs.get(0).getAlamat());
		System.out.println("============================");
		acs.set(0, new ClassStudent("Kevin", "Jakarta"));
		System.out.println(acs.get(0));
		System.out.println(acs.get(0).getNama());
		System.out.println(acs.get(0).getAlamat());
		System.out.println(acs);


		ArrayList<String> acs2 = new ArrayList<>();
		acs2.add("A");
		acs2.add("B");
		acs2.add("C");
		acs2.add("D");
		for (String str : acs2) {
			System.out.println(str);
		}

	}
}
