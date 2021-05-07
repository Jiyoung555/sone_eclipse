package com.mycompany.sone.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.mycompany.sone.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;

	private static String namespace = "MemberMapper";

	@Override
	public void create(MemberVO vo) throws Exception {
		sqlSession.insert(namespace+".create", vo);
		//괄호 안: statement문
		//session 뒤 isert, selectOne, update, ... 메소드는 SqlSession에서 제공하는 메소드
	}

	@Override
	public MemberVO read(Integer member_id) throws Exception {
		return sqlSession.selectOne(namespace + ".read", member_id);
	}


	@Override
	public void update(MemberVO vo) throws Exception {
		sqlSession.update(namespace+".update", vo);
	}


	@Override
	public void delete(Integer member_id) throws Exception {
		sqlSession.delete(namespace+".delete", member_id);
	}

	@Override
	public List<MemberVO> listAll() throws Exception {
		return sqlSession.selectList(namespace + ".listAll");
	}
	
	//---------------------------------------
	
	@Override
	public MemberVO getMember(MemberVO vo) throws Exception {
		return sqlSession.selectOne(namespace+".getMember", vo);
	}

}
