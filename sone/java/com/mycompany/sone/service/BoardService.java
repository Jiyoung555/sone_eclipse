package com.mycompany.sone.service;

import java.util.List;
import com.mycompany.sone.domain.BoardVO;
import com.mycompany.sone.dto.PageDTO;

public interface BoardService {
		//전체 게시물 조회
		public Integer totalRows() throws Exception;
	
		//페이지 조회
		public List<BoardVO> listWithPage(PageDTO page) throws Exception;

	//-------------------------------------------------
	
	  public void regist(BoardVO board) throws Exception;

	  public BoardVO read(Integer board_id) throws Exception;

	  public void modify(BoardVO board) throws Exception;

	  public void remove(Integer board_id) throws Exception;

	  public List<BoardVO> listAll() throws Exception;

}
