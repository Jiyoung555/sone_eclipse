package com.mycompany.sone.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.mycompany.sone.domain.BoardCmtVO;
import com.mycompany.sone.domain.BoardVO;


@Repository
public class BoardCmtDAOImpl implements BoardCmtDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "BoardCmtMapper";

	@Override
	public void create(BoardCmtVO vo) throws Exception {
		session.insert(namespace+".create", vo);
	}

	@Override
	public BoardCmtVO read(Integer comment_id) throws Exception {
		return session.selectOne(namespace + ".read", comment_id);
	}

	@Override
	public void update(BoardCmtVO vo) throws Exception {
		session.update(namespace+".update", vo);
	}

	@Override
	public void delete(Integer comment_id) throws Exception {
		session.delete(namespace+".delete", comment_id);
	}

	@Override
	public List<BoardCmtVO> listByBoardId(Integer board_id) throws Exception {
		return session.selectList(namespace + ".listByBoardId", board_id);
	}

}