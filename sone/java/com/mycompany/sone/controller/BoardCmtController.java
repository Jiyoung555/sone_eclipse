package com.mycompany.sone.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.sone.domain.BoardCmtVO;
import com.mycompany.sone.domain.BoardVO;
import com.mycompany.sone.domain.MemberVO;
import com.mycompany.sone.dto.BoardDTO;
import com.mycompany.sone.service.BoardCmtService;
import com.mycompany.sone.service.BoardService;
import com.mycompany.sone.service.MemberService;

@Controller
@RequestMapping(value = "/")
public class BoardCmtController {

	@Inject
	private BoardService boardService;
	@Inject
	private BoardCmtService boardCmtService;
	@Inject
	private MemberService memberService;
	
	//---------------------------------------------------

	@RequestMapping(value = "/boardCmtForm", method = RequestMethod.POST) 
	public String boardFormPOST(BoardCmtVO comment, HttpSession session) throws Exception { 

		MemberVO member = (MemberVO) session.getAttribute("member");
		if(member == null) {
			return "redirect:/login";
		}
		
		comment.setMember_id(member.getMember_id());

		boardCmtService.regist(comment);
	    return "redirect:/boardShow?board_id="+comment.getBoard_id();
	}
	
	//---------------------------------------------------	

	@RequestMapping(value = "/boardCmtEdit", method = RequestMethod.POST)
	public String modifyPOST(BoardCmtVO comment, HttpSession session) throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("member");
		if(member == null || !member.getMember_id().equals(comment.getMember_id())) {
			return "redirect:/login"; //비로그인 or 내 댓글 아닌 경우
		}
		boardCmtService.modify(comment);
		return "redirect:/boardShow?board_id="+comment.getBoard_id();
	}
	
	//---------------------------------------------------	
	
	//댓글삭제1) form 제출
	@RequestMapping(value = "/boardCmtDelete", method = RequestMethod.POST)
	public String removePOST(BoardCmtVO comment, HttpSession session) throws Exception{
		MemberVO member = (MemberVO) session.getAttribute("member");
		if(member == null || !member.getMember_id().equals(comment.getMember_id())) {
			System.out.println("비로그인 또는 내 댓글 아닌데 삭제 시도");
			return "redirect:/login"; //비로그인 or 내 댓글 아닌 경우
			//**form 제출시, input name값 꼭 적어주고, 그걸 담는 객체 필드값과 명칭 동일
		}
		boardCmtService.remove(comment.getComment_id());
		return "redirect:/boardShow?board_id="+comment.getBoard_id();		
	}
	
	//댓글삭제2) a 태그
	@RequestMapping(value = "/boardCmtDelete", method = RequestMethod.GET)
	public String removeGET(@RequestParam("comment_id") int comment_id, HttpSession session) throws Exception{
		BoardCmtVO comment = boardCmtService.read(comment_id);
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		if(member == null || !member.getMember_id().equals(comment.getMember_id())) {
			System.out.println("비로그인 또는 내 댓글 아닌데 삭제 시도");
			return "redirect:/login"; //비로그인 or 내 댓글 아닌 경우
			//**form 제출시, input name값 꼭 적어주고, 그걸 담는 객체 필드값과 명칭 동일
		}
		boardCmtService.remove(comment.getComment_id());
		return "redirect:/boardShow?board_id="+comment.getBoard_id();		
	}
	
}
