package com.juaracoding.rrspringboot4.example;

import java.util.ArrayList;
import java.util.HashSet;

public class ContohHashSet {
	public static void main(String[] args) {
		ArrayList<String> acs2 = new ArrayList<>();
		acs2.add("A");
		acs2.add("B");
		acs2.add("C");
		acs2.add("D");
		acs2.add("D");
		for (String str : acs2) {
			System.out.println(str);
		}
		System.out.println("========================");
		HashSet<String> hashSet = new HashSet<>();
		hashSet.add("A");
		hashSet.add("B");
		hashSet.add("C");
		hashSet.add("D");
		hashSet.add("D");
		for (String str : hashSet) {
			System.out.println(str);
		}

		System.out.println("CONTOH OBJECT===============");
		ArrayList<ClassStudent> acs1 = new ArrayList<>();
		ClassStudent cs = new ClassStudent("Paul","Bogor");
		acs1.add(cs);
		acs1.add(cs);
		acs1.add(cs);
		acs1.add(cs);
		for (ClassStudent c: acs1) {
			System.out.println(c);
		}
		System.out.println("=============");
		HashSet<ClassStudent> hashSet1 = new HashSet<>();
		hashSet1.add(cs);
		hashSet1.add(cs);
		hashSet1.add(cs);
		hashSet1.add(cs);
		for (ClassStudent c: hashSet1) {
			System.out.println(c);
		}

	}
}
