package com.bbs.test.Controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbs.test.Dao.BbsDaoMybatis;
import com.bbs.test.Dao.MemberDaoMybatis;
import com.bbs.test.Util.Utils;
import com.bbs.test.Vo.BbsVO;
import com.bbs.test.Vo.MemberVO;

@Controller
public class MainController {
	@Autowired
	private MemberDaoMybatis mm;
	
	@Autowired
	private BbsDaoMybatis bm; 
	
	@RequestMapping(value = "/join.do")
	public String join(){
		return "main/join.tiles";
	}
	
	@RequestMapping(value = "/joinOk.do",method = RequestMethod.POST)
	public String joinOk(Locale locale, Model model, MemberVO mVO,HttpServletRequest request) throws 
	 DataAccessException {
		String member_id = (String) request.getParameter("member_id");
		String member_pw = (String) request.getParameter("member_pw");
		
		mVO.setMember_id(Utils.toConvertString(member_id));
		mVO.setMember_pw(Utils.toConvertString(member_pw));

		try{
			mm.insertMember(mVO);	
		}catch (DataAccessException e){
			e.printStackTrace();
		}
		
		return "redirect:/main.do";
	}
	
	
	@RequestMapping(value = "/")
	public String main(Model model){
		List<BbsVO> bbsList = bm.selectBbsList();
		model.addAttribute("bbsList",bbsList);
		return "login.tiles";
	}
	
	@RequestMapping(value = "/main.do")
	public String main2(Model model){
		List<BbsVO> bbsList = bm.selectBbsList();
		model.addAttribute("bbsList",bbsList);
		return ".main";
	}
	
	
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(MemberVO mVO,HttpSession session){
		return "login.tiles";
	}
	
	@RequestMapping(value = "/loginOk.do",method = RequestMethod.POST) 
	public String loginOk(Model model, MemberVO mVO, HttpServletRequest request, HttpSession session){
		String member_id = (String) request.getParameter("member_id");
		String member_pw = (String) request.getParameter("member_pw");
		
		mVO.setMember_id(Utils.toConvertString(member_id));
		mVO.setMember_pw(Utils.toConvertString(member_pw));
		
		MemberVO resultMVo = mm.selectMember(mVO);
		System.out.println(resultMVo);
		if(resultMVo != null)
		{
			session.setAttribute("loginYn","Y");
			session.setAttribute("sessionMessage", "");
			List<BbsVO> bbsList = bm.selectBbsList();
			model.addAttribute("bbsList",bbsList);
			return "bbs/bbsView.tiles";
		}else if(resultMVo == null) {
			session.setAttribute("loginYn","N");
			session.setAttribute("sessionMessage", "아이디 또는 비밀번호 오류");
			System.out.println("로그인 실패");
			return "redirect:/";
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request, HttpSession session) {
		System.out.println("Logout!!!!!");
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/error404",method=RequestMethod.GET)
    public String error404(HttpServletResponse res, Model model) //throws Exception
    {
		System.out.println("여기로 여기로");
        res.setStatus(HttpServletResponse.SC_OK);
        model.addAttribute("contents","error/error404");
        return "redirect:/";
    }
}
