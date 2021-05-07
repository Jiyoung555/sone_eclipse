package com.mycompany.sone.persistence;

import java.util.List;

import com.mycompany.sone.domain.MemberVO;

public interface MemberDAO {
	
	public void create(MemberVO vo) throws Exception;

	public MemberVO read(Integer member_id) throws Exception;

	public void update(MemberVO vo) throws Exception;

	public void delete(Integer member_id) throws Exception;

	public List<MemberVO> listAll() throws Exception; //List는 util
	
	//----------------------------------
	
	public MemberVO getMember(MemberVO vo) throws Exception;

}
