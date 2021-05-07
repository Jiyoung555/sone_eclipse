package com.mycompany.sone.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.mycompany.sone.domain.MemberVO;

public interface MemberService {

	  public void regist(MemberVO member) throws Exception;

	  public MemberVO read(Integer member_id) throws Exception;

	  public void modify(MemberVO member) throws Exception;

	  public void remove(Integer member_id) throws Exception;

	  public List<MemberVO> listAll() throws Exception;
	  
	  //---------------------------------------------
	  
	  public MemberVO getMember(MemberVO member) throws Exception;

	  public String loginAuth(MemberVO member, Model model, HttpSession session) throws Exception;
}
