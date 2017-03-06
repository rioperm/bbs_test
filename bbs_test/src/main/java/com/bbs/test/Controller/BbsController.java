package com.bbs.test.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbs.test.Dao.BbsDaoMybatis;
import com.bbs.test.Util.Utils;
import com.bbs.test.Vo.BbsVO;

@Controller
public class BbsController {
	
	@Autowired
	private BbsDaoMybatis bbsDaoMybatis; 
	
	@RequestMapping(value = "/bbs.do", method = RequestMethod.GET)
	public String bbs(BbsVO bVO, Model model, HttpServletRequest request){
		
		int totalCount = bbsDaoMybatis.selectBbsCount();
		model.addAttribute("totalCount",totalCount);
		System.out.println("여기가 토탈 카운트여 " + totalCount);
		
		int numberPerPage = 10;
		int totalPage = (totalCount / numberPerPage < 0) ? 1 : ((totalCount % numberPerPage > 0) ? (totalCount/numberPerPage)+1:(totalCount/numberPerPage));
//		int viewPage = ((Integer)request.getAttribute("viewPage")).intValue();
		int startIndex = 0 ;
		
				
		System.out.println("startIndex : " + startIndex + "   NUM : " + numberPerPage);
		
		bVO.setNumberPerPage(numberPerPage);
		bVO.setStartIndex(startIndex);
		
		List<BbsVO> bbsList = bbsDaoMybatis.selectBbsList(bVO);
		model.addAttribute("bbsList",bbsList);
		return "bbs/bbsView.tiles";
	}
	
	@RequestMapping(value="/bbsWrite.do",method=RequestMethod.GET)
	public String bbsWrite(Model model){
		return "bbs/bbsWrite.tiles";
	}
	
	@RequestMapping(value="/bbsWriteOk.do",method = RequestMethod.POST)
	public String bbsWriteOk(BbsVO bVO, Model model,HttpServletRequest request, HttpSession session) throws 
	 UnsupportedEncodingException {
		String title = (String) request.getParameter("title");
		String content = (String) request.getParameter("content");
		
		bVO.setBbs_title(Utils.toConvertString(title));
		bVO.setBbs_content(Utils.toConvertString(content));
		bVO.setMember_nid((String)session.getAttribute("loginNID"));
		
		bbsDaoMybatis.insertBbs(bVO);
		return "redirect:/bbs.do";
	}
	
	@RequestMapping(value="/bbsRead.do")
	public String bbsRead(BbsVO bVO, Model model, HttpServletRequest request){
		String select_id = (String) request.getParameter("readId");
		
		bVO.setBbs_id(select_id);
		BbsVO readOne = bbsDaoMybatis.selectBbsOne(bVO);
		// '2017-02-12 20:13:50' bbs_date 값을 '2017-02-12'로 변경 
		// 띄어쓰기 로 구분된 형태 
		readOne.setBbs_date(Utils.splitDate(readOne.getBbs_date()));
		model.addAttribute("readOne",readOne);
		return "bbs/bbsRead.tiles";
	}
	
	@RequestMapping(value="/bbsDelete.do",method = RequestMethod.POST)
	public String bbsDelete(BbsVO bVO, HttpServletRequest request) {
		String deleteId = (String) request.getParameter("deleteId");
		
		bVO.setBbs_id(deleteId);
		bbsDaoMybatis.deleteBbs(bVO);
		return "redirect:/bbs.do";
	}
	
	//modify 할 게시글 1개 read 
	@RequestMapping(value="/bbsModify.do")
	public String bbsModify(BbsVO bVO, Model model, HttpServletRequest request){
		String modifyId = (String) request.getParameter("modifyId");
		
		bVO.setBbs_id(modifyId);
		model.addAttribute("modifyBbs",bbsDaoMybatis.selectBbsOne(bVO));
		return "bbs/bbsModify.tiles";
	}

	@RequestMapping(value="/bbsModifyOk.do",method = RequestMethod.POST)
	public String bbsModifyOk(BbsVO bVO, Model model, HttpServletRequest request)  throws 
	 UnsupportedEncodingException {
		String modifyId = (String) request.getParameter("modifyId");
		String title = (String) request.getParameter("title");
		String content = (String) request.getParameter("content");
		
		bVO.setBbs_id(modifyId);
		bVO.setBbs_title(Utils.toConvertString(title));
		bVO.setBbs_content(Utils.toConvertString(content));
		
		bbsDaoMybatis.modifyBbs(bVO);
		model.addAttribute("readOne",bbsDaoMybatis.selectBbsOne(bVO));
		return "bbs/bbsRead.tiles";
	}
	
}
