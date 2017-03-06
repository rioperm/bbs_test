package com.bbs.test.Controller;

import java.util.List;
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
	private MemberDaoMybatis memberDaoMybatis;
	
	@Autowired
	private BbsDaoMybatis bbsDaoMybatis;
	
	@RequestMapping(value = "/join.do")
	public String join(){
		return "join.tiles";
	}
	
	@RequestMapping(value = "/joinOk.do",method = RequestMethod.POST)
	public String joinOk(Model model, MemberVO mVO,HttpServletRequest request) {
		String member_id = (String) request.getParameter("member_id");
		String member_pw = (String) request.getParameter("member_pw");
		
		mVO.setMember_id(Utils.toConvertString(member_id));
		mVO.setMember_pw(Utils.toConvertSHA256(Utils.toConvertString(member_pw)));
		
		
		
		
		try{
			memberDaoMybatis.insertMember(mVO);	
		}catch (DataAccessException e){
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(MemberVO mVO,HttpSession session){
		if(Utils.sessionCheck(session)){
			return "redirect:/bbs.do";
		}
		return "login.tiles";
	}
	
	@RequestMapping(value = "/loginOk.do",method = RequestMethod.POST) 
	public String loginOk(BbsVO bVO, Model model, MemberVO mVO, HttpServletRequest request, HttpSession session){
		String member_id = (String) request.getParameter("member_id");
		String member_pw = (String) request.getParameter("member_pw");
		
		mVO.setMember_id(Utils.toConvertString(member_id));
		mVO.setMember_pw(Utils.toConvertSHA256(Utils.toConvertString(member_pw)));
//		mVO.setMember_pw(Utils.toConvertString(member_pw));
		
		MemberVO resultMVo = memberDaoMybatis.selectMember(mVO);
		if(resultMVo != null)
		{
			session.setAttribute("loginYn","Y");
			session.setAttribute("loginNID",resultMVo.getMember_nid());
			session.setAttribute("sessionMessage", "");
			List<BbsVO> bbsList = bbsDaoMybatis.selectBbsList(bVO);
			model.addAttribute("bbsList",bbsList); 
			return "redirect:/bbs.do";
		}
		
		session.setAttribute("loginYn","N");
		session.setAttribute("sessionMessage", "아이디 또는 비밀번호 오류");
		System.out.println("로그인 실패");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request, HttpSession session) {
		System.out.println("Logout!!!!!");
		// 특정 세션 값 제거
		session.removeAttribute("loginYn");
		session.removeAttribute("loginNID");
		// 세션 전체 무효화
//		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/checkId.do")
	public String checkId(HttpServletRequest request, MemberVO mVO, Model model, String checkId){
		checkId = (String) request.getParameter("checkId");
		mVO.setMember_id(Utils.toConvertString(checkId));
		String resultId = memberDaoMybatis.selectMemberOne(mVO);
		
		String joinAbleYn="NO";
		if(checkId.equals(resultId)){
			joinAbleYn = "NO";
		}else{
			joinAbleYn = "YES";
		}
		model.addAttribute("joinAbleYn",joinAbleYn);
		
		return "checkId.tiles";
	}
	
	@RequestMapping(value="/test.do")
	public String test(){
		return ".main";
	}
	
//	@RequestMapping(value="/error404.do",method=RequestMethod.GET)
//    public String error404(HttpServletResponse res, HttpSession session) //throws Exception
//    {
//		System.out.println("404 여기로");
//		//응답 코드를 정상값 (200) 으로 변경해 줌
//        res.setStatus(HttpServletResponse.SC_OK);
//        session.setAttribute("sessionMessage", "404 에러 발생");
//        return "redirect:/";
//    }
//	
//	@RequestMapping(value="/error405.do",method=RequestMethod.GET)
//	public String error405(HttpServletResponse res, HttpSession session) //throws Exception
//	{
//		System.out.println("405 여기로");
//		res.setStatus(HttpServletResponse.SC_OK);
//		session.setAttribute("sessionMessage", "405 에러 발생. 접근 방식 잘못 됨");
//		return "redirect:/";
//	}
}
