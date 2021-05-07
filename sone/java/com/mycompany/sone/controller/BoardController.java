package com.mycompany.sone.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.sone.domain.BoardCmtVO;
import com.mycompany.sone.domain.BoardVO;
import com.mycompany.sone.domain.ItemVO;
import com.mycompany.sone.domain.MemberVO;
import com.mycompany.sone.dto.BoardCmtDTO;
import com.mycompany.sone.dto.BoardDTO;
import com.mycompany.sone.service.BoardCmtService;
import com.mycompany.sone.service.BoardService;
import com.mycompany.sone.service.MemberService;

@Controller
@RequestMapping(value = "/")
public class BoardController {

	@Inject
	private BoardService boardService;
	@Inject
	private BoardCmtService commentService;
	@Inject
	private MemberService memberService;

	//---------------------------------------------------	

	@RequestMapping(value = "/boardForm", method = RequestMethod.GET) 
	public String boardFormGET() throws Exception {
		return "boards/boardForm";
	}

	@RequestMapping(value = "/boardForm", method = RequestMethod.POST) 
	public String boardFormPOST(BoardVO board, 
			@RequestParam("image") MultipartFile files,
			HttpSession session) throws Exception { 

		MemberVO member = (MemberVO) session.getAttribute("member");
		if(member == null) {
			return "redirect:/login";
		}
		board.setMember_id(member.getMember_id());
		
		//파일 제출
		if(!files.isEmpty()) {
			System.out.println("files: " + files.getOriginalFilename()); 
	        String uploadPath = "C:\\spring_board_img";
	        board.uploadImage(files, uploadPath);
	        System.out.println("이미지명 추가됐나요? " + board.getImagename());
		}
		
		boardService.regist(board);
	    return "redirect:/boardAll";
	}


	//---------------------------------------------------	
	
	@RequestMapping(value= "/boardAll", method = RequestMethod.GET) 
	public String listAll(Model model)throws Exception {
		
		List<BoardVO> boardVOList = boardService.listAll();
		List<BoardDTO> boardList = new ArrayList();
		
		for(BoardVO board : boardVOList) {
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
		return "boards/boardAll";
	}
		
	
	
	//---------------------------------------------------	

	@RequestMapping(value = "/boardShow", method = RequestMethod.GET) 
	public String read(@RequestParam("board_id") int board_id, Model model) throws Exception {
		
		BoardVO board = boardService.read(board_id);
		MemberVO member = memberService.read(board.getMember_id());
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBoard_id(board.getBoard_id());
		boardDTO.setTitle(board.getTitle());
		boardDTO.setContent(board.getContent());
		boardDTO.setImagename(board.getImagename());
		boardDTO.setDate(board.getDate());
		boardDTO.setMember_id(board.getMember_id());
		boardDTO.setWriter(member.getName()); //이거 때문에 BoardDTO 만듦
		model.addAttribute("board", boardDTO);
		
		List<BoardCmtVO> commentList = commentService.listByBoardId(board.getBoard_id());
		List<BoardCmtDTO> comments = new ArrayList();
		for(BoardCmtVO commentVO : commentList) {
			BoardCmtDTO comment = new BoardCmtDTO();
			comment.setComment_id(commentVO.getComment_id());
			comment.setContent(commentVO.getContent());
			comment.setBoard_id(commentVO.getBoard_id());
			comment.setMember_id(commentVO.getMember_id());
			
			MemberVO memberCmt = memberService.read(commentVO.getMember_id());
			comment.setWriter(memberCmt.getName());//이거 때문에 DTO
			comments.add(comment);
			System.out.println("comment : " + comment.getContent());
		}
		model.addAttribute("comments", comments);
		System.out.println("comments : " + comments.size());
		
		return "boards/boardShow";
	}
	
	//---------------------------------------------------	

	@RequestMapping(value = "/boardEdit", method = RequestMethod.GET) 
	public String boardEdit(@RequestParam("board_id") int board_id, 
			Model model, HttpSession session) throws Exception {
		
		MemberVO member_login = (MemberVO) session.getAttribute("member");
		BoardVO boardVO = boardService.read(board_id);
		MemberVO member_board = memberService.read(boardVO.getMember_id());
		
		if(member_login == null ||
				! member_login.getMember_id().equals(member_board.getMember_id())) {
			return "redirect:/login";
		}
		model.addAttribute("board", boardVO);
		return "boards/boardEdit";
	}
	
	//**form 제출시, input name값 꼭 적어주고, 그걸 담는 객체 필드값과 명칭 동일
	@RequestMapping(value = "/boardEdit", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board,
			@RequestParam("image") MultipartFile files) throws Exception {
		
		Timestamp updateDate = Timestamp.valueOf(LocalDateTime.now());
		board.setDate(updateDate);
		
		//파일 제출
		if(!files.isEmpty()) {
			System.out.println("files: " + files.getOriginalFilename()); 
	        String uploadPath = "C:\\spring_board_img";
	        board.uploadImage(files, uploadPath);
	        System.out.println("이미지명 추가됐나요? " + board.getImagename());
		}
		
		System.out.println("수정 board? " + board.getTitle());
		boardService.modify(board);
		return "redirect:/boardAll";
	}
	
	//---------------------------------------------------	
	
	@RequestMapping(value = "/boardDelete", method = RequestMethod.POST)
	public String removePOST(@RequestParam("board_id") int board_id,
			HttpSession session) throws Exception{
		MemberVO member_login = (MemberVO) session.getAttribute("member");
		BoardVO boardVO = boardService.read(board_id);
		MemberVO member_board = memberService.read(boardVO.getMember_id());
		
		if(member_login == null ||
				! member_login.getMember_id().equals(member_board.getMember_id())) {
			return "redirect:/login";
		}
		
		//FK를 가지는 댓글들 먼저 삭제
		List<BoardCmtVO> commentList = commentService.listByBoardId(board_id);
		for(BoardCmtVO comment : commentList) {
			commentService.remove(comment.getComment_id());
		}
		//게시글 삭제
		boardService.remove(board_id);
		return "redirect:/boardAll";
	}

}
