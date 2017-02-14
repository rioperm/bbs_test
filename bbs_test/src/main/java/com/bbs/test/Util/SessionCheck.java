package com.bbs.test.Util;

import javax.servlet.http.HttpSession;

public class SessionCheck {
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
}
