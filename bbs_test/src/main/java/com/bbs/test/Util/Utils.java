package com.bbs.test.Util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

public class Utils {
	public static String toConvertString(String string) {
		try{
			string = new String(string.getBytes("8859_1"),"UTF-8");
		}catch (UnsupportedEncodingException e){
			return null;
		}
		return string; 
	}
	
	public static boolean sessionCheck(HttpSession session){
		System.out.println("session check : " + session);
		if(session!=null){
			if(session.getAttribute("loginYn")=="Y"){
				return true;				
			}else
				return false;
		}else
		return false;
	}
	
	public static String toConvertSHA256(String string) {
		String SHA = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(string.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i<byteData.length; i++){
				sb.append(Integer.toString((byteData[i]&0xff)+0x100,16).substring(1));
			}
			SHA = sb.toString();
			
		}catch (NoSuchAlgorithmException e){
			e.printStackTrace();
			SHA = null;
		}
		return SHA;
	}
	
	
	
}
