package com.mycompany.sone.service;

import java.util.List;
import com.mycompany.sone.domain.BoardCmtVO;

public interface BoardCmtService {
	
	  public void regist(BoardCmtVO comment) throws Exception;

	  public BoardCmtVO read(Integer comment_id) throws Exception;

	  public void modify(BoardCmtVO comment) throws Exception;

	  public void remove(Integer comment_id) throws Exception;

	  public List<BoardCmtVO> listByBoardId(Integer board_id) throws Exception;
}
