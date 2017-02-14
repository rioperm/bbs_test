package com.bbs.test.Util;

import java.io.UnsupportedEncodingException;

public class Utils {
	public static String toConvertString(String string) {
		try{
			string = new String(string.getBytes("8859_1"),"UTF-8");
		}catch (UnsupportedEncodingException e){
			return null;
		}
		return string; 
	}
}
