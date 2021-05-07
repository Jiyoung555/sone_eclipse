package com.mycompany.sone.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.mycompany.sone.domain.BoardVO;
import com.mycompany.sone.dto.PageDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "BoardMapper";

	//페이징
	@Override
	public Integer totalRows() throws Exception{
		return session.selectOne(namespace + ".totalRows");
	}

	@Override
	public List<BoardVO> listWithPage(PageDTO page) throws Exception{
		return session.selectList(namespace + ".listWithPage", page);
	}
	
	//-------------------------------------------
	
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(namespace+".create", vo);
	}

	@Override
	public BoardVO read(Integer board_id) throws Exception {
		return session.selectOne(namespace + ".read", board_id);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace+".update", vo);
	}

	@Override
	public void delete(Integer board_id) throws Exception {
		session.delete(namespace+".delete", board_id);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

}
