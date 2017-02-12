package com.bbs.test.Controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbs.test.Dao.MemberDaoMybatis;

@Controller
public class LoginController {
	@Autowired
	private MemberDaoMybatis mm;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String bbs(Locale locale, Model model){
		return "login/login";
	}
	
}
