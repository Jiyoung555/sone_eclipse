package com.mycompany.sone.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.mycompany.sone.domain.BoardCmtVO;
import com.mycompany.sone.persistence.BoardCmtDAO;


@Service
public class BoardCmtServiceImpl implements BoardCmtService {

	@Inject
	private BoardCmtDAO boardCmtDao;

	@Override
	public void regist(BoardCmtVO comment) throws Exception {
		boardCmtDao.create(comment);
	}

	@Override
	public BoardCmtVO read(Integer comment_id) throws Exception {
		return boardCmtDao.read(comment_id);
	}

	@Override
	public void modify(BoardCmtVO comment) throws Exception {
		boardCmtDao.update(comment);
	}

	@Override
	public void remove(Integer comment_id) throws Exception {
		boardCmtDao.delete(comment_id);
	}

	@Override
	public List<BoardCmtVO> listByBoardId(Integer board_id) throws Exception {
		return boardCmtDao.listByBoardId(board_id);
	}

}
