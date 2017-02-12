package com.bbs.test.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbs.test.Dao.BbsDaoMybatis;
import com.bbs.test.Vo.BbsVO;



@Controller
public class BbsController {
	
	@Autowired
	private BbsDaoMybatis bm;
	
	@RequestMapping(value = "/bbs.do", method = RequestMethod.GET)
	public String bbs(Locale locale, Model model){
		List<BbsVO> bbsList = bm.selectBbsList();
		model.addAttribute("bbsList",bbsList);
		return "bbs/bbsView";
	}
	
	@RequestMapping(value="/bbsWrite.do",method=RequestMethod.GET)
	public String bbsWrite(Model model){
		return "bbs/bbsWrite";
	}
	
	@RequestMapping(value="/bbsWriteOk.do",method = RequestMethod.POST)
	public String bbsWriteOk(BbsVO bVO, Model model,HttpServletRequest request) throws 
	 UnsupportedEncodingException {
		String title = (String) request.getParameter("title");
		String content = (String) request.getParameter("content");
		title = new String(title.getBytes("8859_1"),"UTF-8");
		content = new String(content.getBytes("8859_1"),"UTF-8");
		
		bVO.setBbs_title(title);
		bVO.setBbs_content(content);
		bm.insertBbs(bVO);
		return "redirect:/bbs.do";
	}
	
	@RequestMapping(value="/bbsRead.do")
	public String bbsRead(BbsVO bVO, Model model, HttpServletRequest request){
		String select_id = (String) request.getParameter("readId");
		bVO.setBbs_id(select_id);
		BbsVO readOne = bm.selectBbsOne(bVO);
		model.addAttribute("readOne",readOne);
		return "bbs/bbsRead";
	}
	
	@RequestMapping(value="/bbsDelete.do",method = RequestMethod.POST)
	public String bbsDelete(BbsVO bVO, HttpServletRequest request) {
		String deleteId = (String) request.getParameter("deleteId");
		bVO.setBbs_id(deleteId);
		bm.deleteBbs(bVO);
		return "redirect:/bbs.do";
	}
	
	//modify 할 게시글 1개 read - get 방식
	@RequestMapping(value="/bbsModify.do")
	public String bbsModify(BbsVO bVO, Model model, HttpServletRequest request){
		String modifyId = (String) request.getParameter("modifyId");
		bVO.setBbs_id(modifyId);
		model.addAttribute("modifyBbs",bm.selectBbsOne(bVO));
		return "bbs/bbsModify";
	}

	@RequestMapping(value="/bbsModifyOk.do",method = RequestMethod.POST)
	public String bbsModifyOk(BbsVO bVO, Model model, HttpServletRequest request)  throws 
	 UnsupportedEncodingException {
		String modifyId = (String) request.getParameter("modifyId");
		String title = (String) request.getParameter("title");
		String content = (String) request.getParameter("content");
		title = new String(title.getBytes("8859_1"),"UTF-8");
		content = new String(content.getBytes("8859_1"),"UTF-8");
		bVO.setBbs_id(modifyId);
		bVO.setBbs_title(title);
		bVO.setBbs_content(content);
		bm.modifyBbs(bVO);
		model.addAttribute("readOne",bm.selectBbsOne(bVO));
		return "bbs/bbsRead";
	}
	
	@RequestMapping(value="/test.do")
	public String test(BbsVO bVO, Model model){
		
		bm.selectBbsList();
		
		//model.addAttribute("readList",bm.selectBbsList());
		return "bbs/bbsView";
	}
}
