package com.mycompany.sone.domain;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class ItemVO {
	
	private Integer item_id;
	private String name;
	private String content;
	private Integer price;
	private String imagename;
	private Integer stock;
	private String useyn;
	
    public void uploadImage(MultipartFile files, String uploadPath) throws IOException {
        UUID uuid = UUID.randomUUID(); 
        String filename = uuid.toString() + "_" + files.getOriginalFilename();
        String filePath = uploadPath + File.separator + filename;
        File file = new File(filePath);
        files.transferTo(file); // c 드라이브 안에 넣음
        this.imagename = filename;
    }

    
    //------------게터 세터 toString---------------
    
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getUseyn() {
		return useyn;
	}
	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}
	@Override
	public String toString() {
		return "ItemVO [item_id=" + item_id + ", name=" + name + ", content=" + content + ", price=" + price
				+ ", imagename=" + imagename + ", stock=" + stock + ", useyn=" + useyn + "]";
	}
	

}
