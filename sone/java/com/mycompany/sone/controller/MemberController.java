package com.mycompany.sone.controller;
import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.mycompany.sone.domain.MemberVO;
import com.mycompany.sone.security.UserMapper;
import com.mycompany.sone.service.MemberService;

@Controller
@RequestMapping(value = "/") // 주소 패턴
public class MemberController {

	@Inject
	private MemberService memberService;
	
	//---------------------------------------------------	
	
	@RequestMapping(value= "/memberAll", method = RequestMethod.GET) 
	public String memberAll(Model model)throws Exception {
		model.addAttribute("list", memberService.listAll());
		return "members/memberAll";
	}
	
	//---------------------------------------------------
	
//	//GET 방식으로 페이지 호출
//	@RequestMapping(value = "/signup", method = RequestMethod.GET) 
//	public String signupGET(MemberVO member, Model model) throws Exception {
//		return "members/signup";
//	}
//
//	//POST방식으로 내용 전송
//	@RequestMapping(value = "/signup", method = RequestMethod.POST) 
//	public String signupPOST(MemberVO member, RedirectAttributes rttr) throws Exception { 
//		//RedirectAttributes: redirect로 이동시에 model처럼 값 가져갈 수 있음 //현재 사용 x
//		memberService.regist(member);
//	    return "redirect:/memberAll";
//	}
	
	//---------------------------------------------------	
	//GET 방식으로 페이지 호출
	@RequestMapping(value = "/memberShow", method = RequestMethod.GET) 
	public String read(@RequestParam("member_id") int member_id, Model model) throws Exception {
		model.addAttribute(memberService.read(member_id));
		return "members/memberShow";
	}
	
	//---------------------------------------------------	
	
	//GET 방식으로 페이지 호출
	@RequestMapping(value = "/modify", method = RequestMethod.GET) 
	public String modifyGET(int member_id, Model model) throws Exception {
		model.addAttribute(memberService.read(member_id)); // 수정을 위한 글읽기 서비스 호출
		return "members/memberEdit";
	}

	//POST방식으로 데이터 전송
	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	public String modifyPOST(MemberVO member, RedirectAttributes rttr) throws Exception {
		System.out.println("PUT매핑 테스트");
		memberService.modify(member); //글수정 서비스 호출
		return "redirect:/memberAll"; //수정이 완료된 후, 목록페이지로 리턴
	}
	
	//---------------------------------------------------	
	
	//POST방식으로 데이터 전송
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removePOST(@RequestParam("member_id") int member_id, RedirectAttributes rttr) throws Exception{
		memberService.remove(member_id); //글삭제 서비스 호출
		return "redirect:/memberAll"; //삭제가 완료된 후, 목록페이지로 리턴
	}
	
	//---------------------------------------------------

//	@RequestMapping(value = "/login", method = RequestMethod.GET) 
//	public String loginGET() throws Exception {		
//		return "members/login";
//	}
//
//	@RequestMapping(value = "/login", method = RequestMethod.POST) 
//	public String loginPOST(MemberVO member, Model model, HttpSession session) throws Exception { 
//		//memberService.loginAuth(member, model, session); //이렇게 하면 에러남
//		return memberService.loginAuth(member, model, session);
//		//페이지, url 리턴값은 서비스가 아닌, 컨트롤러가 담당하도록
//	}	
	
	

}
