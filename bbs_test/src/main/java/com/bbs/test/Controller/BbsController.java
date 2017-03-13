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
	
	@RequestMapping(value = "/bbs.do")
	public String bbs(BbsVO bVO, Model model, HttpServletRequest request){
		int totalCount = bbsDaoMybatis.selectBbsCount();
		
		int numberPerPage = 10 ;
		int viewPage = 1;
//		if(request.getParameter("numberPerPage") != null){
//			numberPerPage = Integer.parseInt((String)request.getParameter("numberPerPage"));
//		}
		
		if(request.getParameter("viewPage") != null){
			viewPage = Integer.parseInt((String)request.getParameter("viewPage"));
			if(request.getParameter("pageLinkSpan")!=null){
				String pageLinkSpan=request.getParameter("pageLinkSpan");
				if(pageLinkSpan.equals("pageLeft")){
					viewPage = ((viewPage-10)%10 )== 0 ? ((viewPage-10)/11)*10 +10 : ((viewPage-10)/10)*10+10; 
				}else if(pageLinkSpan.equals("pageRight")){
					viewPage = ((viewPage+10)%10 )== 0 ? ((viewPage+10)/11)*10 +1 : ((viewPage+10)/10)*10+1;
				}	
			}
		}
		
		int startIndex = (viewPage-1) * numberPerPage;

		int totalPageCheck = totalCount / numberPerPage; 
		int totalPage = (totalPageCheck < 0) ? 1 : ((totalCount % numberPerPage > 0) ? totalPageCheck+1:totalPageCheck);
		int startPage = ((startIndex / numberPerPage+1) / 10 > 0) ? (((startIndex / numberPerPage+1)%10==0) ?  (((startIndex / numberPerPage+1)/11)*10+1):((startIndex / numberPerPage+1) / 10) * 10 + 1) : 1;
				//현재 페이지 startIndex / numberPerPage+1;
		int lastPage = (startPage + 9) < totalPage ? (startPage+9) : totalPage;
		
//		int startPage = (viewPage / 10 > 0) ? ((viewPage%10==0) ?  ((viewPage/11)*10+1):(viewPage / 10) * 10 + 1) : 1; 
//		int lastPage = (startPage + 9) < totalPage ? (startPage+9) : totalPage; 
		
		bVO.setNumberPerPage(numberPerPage);
		bVO.setStartIndex(startIndex);
		
		System.out.println("토탈카운트 " + totalCount+ "  totalPage : " + totalPage+"  startIndex : " + startIndex);
		System.out.println("시작인덱스 " + startIndex+ "  viewPage : " + viewPage+"  startPage : " + startPage+"  lastPage : " + lastPage);
		List<BbsVO> bbsList = bbsDaoMybatis.selectBbsList(bVO);

		model.addAttribute("startPage",startPage);
		model.addAttribute("lastPage",lastPage);
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("numberPerPage",numberPerPage);
		model.addAttribute("viewPage",viewPage);
		model.addAttribute("bbsList",bbsList);
		return "bbs/bbsView.tiles";
	}
	
	@RequestMapping(value="/bbsWrite.do")
	public String bbsWrite(HttpServletRequest request, Model model){
		
		model.addAttribute("numberPerPage",request.getParameter("numberPerPage"));
		model.addAttribute("viewPage",request.getParameter("viewPage"));
		model.addAttribute("totalPage",request.getParameter("totalPage"));
		
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
		
		model.addAttribute("numberPerPage",request.getParameter("numberPerPage"));
		model.addAttribute("viewPage",request.getParameter("viewPage"));
		model.addAttribute("totalPage",request.getParameter("totalPage"));
		
		
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
		model.addAttribute("numberPerPage",request.getParameter("numberPerPage"));
		model.addAttribute("viewPage",request.getParameter("viewPage"));
		model.addAttribute("totalPage",request.getParameter("totalPage"));
		
		model.addAttribute("readOne",readOne);
		return "bbs/bbsRead.tiles";
	}
	
	@RequestMapping(value="/bbsDelete.do",method = RequestMethod.POST)
	public String bbsDelete(BbsVO bVO, Model model, HttpServletRequest request) {
		String deleteId = (String) request.getParameter("deleteId");
		
		model.addAttribute("numberPerPage",request.getParameter("numberPerPage"));
		model.addAttribute("viewPage",request.getParameter("viewPage"));
		model.addAttribute("totalPage",request.getParameter("totalPage"));
		
		bVO.setBbs_id(deleteId);
		bbsDaoMybatis.deleteBbs(bVO);
		return "redirect:/bbs.do";
	}
	
	//modify 할 게시글 1개 read 
	@RequestMapping(value="/bbsModify.do")
	public String bbsModify(BbsVO bVO, Model model, HttpServletRequest request){
		String modifyId = (String) request.getParameter("modifyId");
		model.addAttribute("numberPerPage",request.getParameter("numberPerPage"));
		model.addAttribute("viewPage",request.getParameter("viewPage"));
		model.addAttribute("totalPage",request.getParameter("totalPage"));
		
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
		
		model.addAttribute("numberPerPage",request.getParameter("numberPerPage"));
		model.addAttribute("viewPage",request.getParameter("viewPage"));
		model.addAttribute("totalPage",request.getParameter("totalPage"));
		
		bVO.setBbs_id(modifyId);
		bVO.setBbs_title(Utils.toConvertString(title));
		bVO.setBbs_content(Utils.toConvertString(content));
		
		bbsDaoMybatis.modifyBbs(bVO);
		model.addAttribute("readOne",bbsDaoMybatis.selectBbsOne(bVO));
		return "bbs/bbsRead.tiles";
	}
	
}
