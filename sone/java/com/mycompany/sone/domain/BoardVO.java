package com.mycompany.sone.domain;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private Integer board_id;
	private String title;
	private String content;
	private String imagename;
	private Timestamp date;
	private Integer member_id;

    public void uploadImage(MultipartFile files, String uploadPath) throws IOException {
        UUID uuid = UUID.randomUUID(); 
        String filename = uuid.toString() + "_" + files.getOriginalFilename();
        String filePath = uploadPath + File.separator + filename;
        File file = new File(filePath);
        files.transferTo(file); // c 드라이브 안에 넣음
        this.imagename = filename;
    }
    
    //게터 세터 toString
	
	public Integer getBoard_id() {
		return board_id;
	}
	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	@Override
	public String toString() {
		return "BoardVO [board_id=" + board_id + ", title=" + title + ", content=" + content + ", imagename="
				+ imagename + ", date=" + date + ", member_id=" + member_id + "]";
	}
	
	

}
