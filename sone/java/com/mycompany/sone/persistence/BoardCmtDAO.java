package com.mycompany.sone.persistence;

import java.util.List;
import com.mycompany.sone.domain.BoardCmtVO;

public interface BoardCmtDAO {
	
	public void create(BoardCmtVO vo) throws Exception;

	public BoardCmtVO read(Integer comment_id) throws Exception;

	public void update(BoardCmtVO vo) throws Exception;

	public void delete(Integer comment_id) throws Exception;

	public List<BoardCmtVO> listByBoardId(Integer board_id) throws Exception; //List는 util
}
