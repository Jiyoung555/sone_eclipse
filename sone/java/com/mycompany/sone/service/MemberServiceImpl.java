package com.mycompany.sone.service;

import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.mycompany.sone.controller.HomeController;
import com.mycompany.sone.domain.MemberVO;
import com.mycompany.sone.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject //spring에서의 @Autowired 비슷 (구글링)
	private MemberDAO dao;

	@Override
	public void regist(MemberVO member) throws Exception {
		System.out.println("회원가입 시도중 : " + member.getEmail());
		dao.create(member);
	}

	@Override
	public MemberVO read(Integer member_id) throws Exception {
		return dao.read(member_id);
	}

	@Override
	public void modify(MemberVO member) throws Exception {
		dao.update(member);
	}

	@Override
	public void remove(Integer member_id) throws Exception {
		dao.delete(member_id);
	}

	@Override
	public List<MemberVO> listAll() throws Exception {
		return dao.listAll();
	}
	
	//----------------------------------------------
	
	@Override
	public MemberVO getMember(MemberVO member) throws Exception {
		System.out.println("member name : " + member.getName());
		return dao.getMember(member);
	}	
	
	@Override
	public String loginAuth(MemberVO member, Model model, HttpSession session) throws Exception{
		
		System.out.println("서비스로 이동");
		
		MemberVO member_db = this.getMember(member); 
		//같은 클래스 내 메소드 사용시, 그냥 바로 메소드 써도 되고
		//어색하면, this.메소드() 이렇게 사용
		
		if(member_db == null) {
			model.addAttribute("loginResult", "비회원입니다. 회원가입을 해주세요.");
			return "members/loginResult";
		}
		
		String password_login = member.getPassword();
		String password_db = member_db.getPassword(); 
	    
		//틀린 비밀번호
		if(! password_login.equals(password_db)) {
			model.addAttribute("loginResult", "틀린 비밀번호");
	    	return "members/loginResult";
	    }
		
		//옳은 비밀번호
		session.setAttribute("member", member_db);
	    return "redirect:/";
	}

}
