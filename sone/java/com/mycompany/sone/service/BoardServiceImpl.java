package com.mycompany.sone.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.mycompany.sone.domain.BoardVO;
import com.mycompany.sone.dto.PageDTO;
import com.mycompany.sone.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDao;

	//-----------------페이징----------------
	@Override
	public Integer totalRows() throws Exception{
	    return boardDao.totalRows();
	}

	@Override
	public List<BoardVO> listWithPage(PageDTO page) throws Exception{
	    return boardDao.listWithPage(page);
	}

	//--------------------------------------------
	
	@Override
	public void regist(BoardVO board) throws Exception {
		boardDao.create(board);
	}

	@Override
	public BoardVO read(Integer board_id) throws Exception {
		return boardDao.read(board_id);
	}

	@Override
	public void modify(BoardVO board) throws Exception {
		boardDao.update(board);
	}

	@Override
	public void remove(Integer board_id) throws Exception {
		boardDao.delete(board_id);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return boardDao.listAll();
	}

}
