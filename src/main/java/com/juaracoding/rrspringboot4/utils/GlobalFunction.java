package com.juaracoding.rrspringboot4.utils;

import com.juaracoding.rrspringboot4.config.OtherConfig;

public class GlobalFunction {
	public static void print(Object object){
		if(OtherConfig.getEnablePrint().equals("y")){
			System.out.println(object);
		}
	}
}
