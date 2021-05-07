package com.mycompany.sone.dto;

public class BoardCmtDTO {
    private Integer comment_id;
    private String content;
    private Integer board_id;
    private Integer member_id;
    
    private String writer;
    
    //게터 세터 toString
    
	public Integer getComment_id() {
		return comment_id;
	}

	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getBoard_id() {
		return board_id;
	}

	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "BoardCommentDTO [comment_id=" + comment_id + ", content=" + content + ", board_id=" + board_id
				+ ", member_id=" + member_id + ", writer=" + writer + "]";
	}
    
    
    
}
