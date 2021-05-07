package com.mycompany.sone.controller;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mycompany.sone.domain.BoardVO;
import com.mycompany.sone.domain.MemberVO;
import com.mycompany.sone.dto.BoardDTO;
import com.mycompany.sone.dto.PageDTO;
import com.mycompany.sone.service.BoardCmtService;
import com.mycompany.sone.service.BoardService;
import com.mycompany.sone.service.MemberService;

@Controller
@RequestMapping(value = "/")
public class PageController {

	@Inject
	private BoardService boardService;
	@Inject
	private MemberService memberService;
	
//	@RequestMapping(value = "/board/init", method = RequestMethod.GET) 
//	public String boardInit() throws Exception { 
//		BoardVO board = new BoardVO();
//		for(int i = 1; i <= 100; i++) {
//			board.setMember_id(3);
//			board.setTitle("제목");
//			board.setContent("내용");
//			boardService.regist(board);			
//		}
//	    return "redirect:/boardAll";
//	}	

	@GetMapping("/board/list")
	public String list(Model model, PageDTO page) throws Exception {
	    //----------페이징------------
	    Integer totalRows = boardService.totalRows(); //전체 게시글 수
	    System.out.println("totalRows : " + totalRows);
	    System.out.println("현재 페이지 : " + page.getPageNum());
	    
	    //Page 객체 생성
	    if( page.getPageNum() == 0) { //현재 페이지 0이면 (최초)
	        page = new PageDTO (1, 10, 10, totalRows); 
	        
	    } else { //현재 페이지가 0이 아니면
	        page = new PageDTO (page.getPageNum(), 10, 10, totalRows); 
	    }
	    
	    model.addAttribute("page", page);
		System.out.println("endPage : " + page.getEndPage());
		
	    //----------------------
		List<BoardVO> boardVOList = boardService.listWithPage(page);

		List<BoardDTO> boardList = new ArrayList();
		for(BoardVO board : boardVOList) {
			System.out.println("board_id : " + board.getBoard_id());
			
			MemberVO member = memberService.read(board.getMember_id());
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setBoard_id(board.getBoard_id());
			boardDTO.setTitle(board.getTitle());
			boardDTO.setContent(board.getContent());
			boardDTO.setImagename(board.getImagename());
			boardDTO.setDate(board.getDate());
			boardDTO.setMember_id(board.getMember_id());
			boardDTO.setWriter(member.getName()); //이거 때문에 BoardDTO 만듦
			boardList.add(boardDTO);
		}
		model.addAttribute("boardList", boardList);


	    return "boards/boardList";
	}
	
}
