package com.mycompany.sone.persistence;

import java.util.List;

import com.mycompany.sone.domain.BoardVO;
import com.mycompany.sone.dto.PageDTO;

public interface BoardDAO {
	public Integer totalRows() throws Exception;

	public List<BoardVO> listWithPage(PageDTO page) throws Exception;

	//------------------------------------------------
	
	public void create(BoardVO vo) throws Exception;

	public BoardVO read(Integer board_id) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void delete(Integer board_id) throws Exception;

	public List<BoardVO> listAll() throws Exception; //List는 util

}
