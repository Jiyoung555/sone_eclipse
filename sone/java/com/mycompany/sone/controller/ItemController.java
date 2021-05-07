package com.mycompany.sone.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.mycompany.sone.domain.ItemVO;
import com.mycompany.sone.service.ItemService;

@Controller
@RequestMapping(value = "/")
public class ItemController {

	@Inject
	private ItemService itemService;
	
	@RequestMapping(value= "/itemAll", method = RequestMethod.GET) 
	public String itemAll(Model model)throws Exception {
		model.addAttribute("list", itemService.listAll());
		return "items/itemAll";
	}
	
	//---------------------------------------------------
	
	@RequestMapping(value = "/itemForm", method = RequestMethod.GET) 
	public String itemFormGET(ItemVO item, Model model) throws Exception {
		return "items/itemForm";
	}

	@RequestMapping(value = "/itemForm", method = RequestMethod.POST) 
	public String itemFormPOST(ItemVO item, 
			@RequestParam("image") MultipartFile files) throws Exception { 

		//파일 제출
		if(!files.isEmpty()) {
			System.out.println("files: " + files.getOriginalFilename()); 
	        String uploadPath = "C:\\spring_item_img";
	        item.uploadImage(files, uploadPath);
	        System.out.println("이미지명 추가됐나요? " + item.getImagename());
		}
		
		System.out.println("itemForm: " + item.toString()); 
		itemService.regist(item);
	    return "redirect:/itemAll";
	}
	
	//---------------------------------------------------	

	@RequestMapping(value = "/itemShow", method = RequestMethod.GET) 
	public String read(@RequestParam("item_id") int item_id, Model model) throws Exception {
		model.addAttribute(itemService.read(item_id));
		return "items/itemShow";
	}
	
	//---------------------------------------------------	
	
	@RequestMapping(value = "/itemEdit", method = RequestMethod.GET) 
	public String modifyGET(int item_id, Model model) throws Exception {
		model.addAttribute(itemService.read(item_id));
		return "items/itemEdit";
	}

	@RequestMapping(value = "/itemEdit", method = RequestMethod.POST)
	public String modifyPUT(ItemVO item,
			@RequestParam("image") MultipartFile files) throws Exception {
		System.out.println("PUT매핑 테스트");
		
		//파일 제출
		if(!files.isEmpty()) {
			System.out.println("files: " + files.getOriginalFilename()); 
	        String uploadPath = "C:\\spring_item_img";
	        item.uploadImage(files, uploadPath);
	        System.out.println("이미지명 추가됐나요? " + item.getImagename());
		}
		
		itemService.modify(item);
		return "redirect:/itemAll";
	}
	
	//---------------------------------------------------	
	
	@RequestMapping(value = "/itemRemove", method = RequestMethod.POST)
	public String removePOST(@RequestParam("item_id") int item_id, RedirectAttributes rttr) throws Exception{
		itemService.remove(item_id);
		return "redirect:/itemAll";
	}
	
}
