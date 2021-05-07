package com.mycompany.sone.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.sone.domain.ItemVO;
import com.mycompany.sone.domain.MemberVO;
import com.mycompany.sone.domain.OrderItemVO;
import com.mycompany.sone.domain.OrderVO;
import com.mycompany.sone.dto.MyOrderDTO;
import com.mycompany.sone.dto.OrderDTO;
import com.mycompany.sone.service.ItemService;
import com.mycompany.sone.service.MemberService;
import com.mycompany.sone.service.OrderService;

@Controller
@RequestMapping(value = "/")
public class OrderController {

	@Inject
	private OrderService orderService;
	
	@Inject
	private ItemService itemService;
	
	@RequestMapping(value= "/orderAll", method = RequestMethod.GET) 
	public String orderAll(Model model, HttpSession session)throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		if(member == null) {
			return "redirect:/login";
		}
		
		List<MyOrderDTO> myOrderList = new ArrayList<MyOrderDTO>();//★
		List<OrderItemVO> orderItemList = orderService.myListAll(member);
		for(OrderItemVO orderItem : orderItemList) {
			OrderVO order = orderService.read(orderItem.getOrder_id());
			ItemVO item = itemService.read(orderItem.getItem_id());
			
			MyOrderDTO myOrder = new MyOrderDTO();//★나의 주문 상세정보 DTO 객체 생성
			myOrder.setOrder_id(order.getOrder_id());//order
			myOrder.setDate(order.getDate());
			myOrder.setOrderStatus(order.getOrderStatus());
			myOrder.setOrder_item_id(orderItem.getOrder_item_id());//orderItem
			myOrder.setCount(orderItem.getCount());
			myOrder.setOrderprice(orderItem.getOrderprice());
			myOrder.setTotalprice(orderItem.getTotalprice());
			myOrder.setName(item.getName());//item
			myOrder.setImagename(item.getImagename());
			myOrderList.add(myOrder);
		}
	
		model.addAttribute("myOrderList", myOrderList);
		return "orders/orderAll";
	}
	
	//---------------------------------------------------
	
	@RequestMapping(value = "/orderForm", method = RequestMethod.GET) 
	public String orderFormGET(OrderVO order, Model model) throws Exception {
		return "orders/orderForm";
	}

	@RequestMapping(value = "/orderForm", method = RequestMethod.POST) 
	public String orderFormPOST(OrderDTO orderDTO, HttpSession session) throws Exception { 
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		if(member == null) {
			return "redirect:/login";
		}
		
		//insert Order
		OrderVO orderVO = orderDTO.toOrderVO(member.getMember_id());
		orderService.regist(orderVO); 
		int order_id = orderVO.getOrder_id();
		System.out.println("insert 후 id값 반환됨 : " + orderVO.getOrder_id());//orderVO의 order_id에 반환됨
	    
		//insert OrderItem
		ItemVO item = itemService.read(orderDTO.getItem_id());
		OrderItemVO orderItem = orderDTO.toOrderItemVO(item, order_id);
		orderService.registOrderItem(orderItem);
		itemService.removeCount(orderItem);//★item 재고 수량 빼기
		
		return "redirect:/orderAll";
	}

	//---------------------------------------------------	

	@RequestMapping(value = "/orderShow", method = RequestMethod.GET) 
	public String orderShow(@RequestParam("order_item_id") int order_item_id, 
			Model model, HttpSession session) throws Exception {
	
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		if(member == null) {
			return "redirect:/login";
		}
		
		OrderItemVO orderItem = orderService.readOrderItem(order_item_id);
		OrderVO order = orderService.read(orderItem.getOrder_id());
		ItemVO item = itemService.read(orderItem.getItem_id());
		
		MyOrderDTO myOrder = new MyOrderDTO();//★나의 주문 상세정보 DTO 객체 생성
		myOrder.setOrder_id(order.getOrder_id());//order
		myOrder.setDate(order.getDate());
		myOrder.setOrderStatus(order.getOrderStatus());
		myOrder.setOrder_item_id(orderItem.getOrder_item_id());//orderItem
		myOrder.setCount(orderItem.getCount());
		myOrder.setOrderprice(orderItem.getOrderprice());
		myOrder.setTotalprice(orderItem.getTotalprice());
		myOrder.setName(item.getName());//item
		myOrder.setImagename(item.getImagename());		
		
		model.addAttribute("myOrder", myOrder);
		return "orders/orderShow";
	}	
	
	//---------------------------------------------------		

	@RequestMapping(value = "/orderDelete", method = RequestMethod.POST)
	public String orderDelete(@RequestParam("order_item_id") int order_item_id,
			HttpSession session) throws Exception{
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		if(member == null) {
			return "redirect:/login";
		}
		
		OrderItemVO orderItem = orderService.readOrderItem(order_item_id);
		OrderVO order = orderService.read(orderItem.getOrder_id());
		ItemVO item = itemService.read(orderItem.getItem_id());
		
		if(order.getOrderStatus().equals("ORDERED")) {
			return "redirect:/";
		}
		
		if(order.getOrderStatus().equals("PREPARING")) {
			orderService.removeOrderItem(orderItem.getOrder_item_id());
			System.out.println("order_id : " + order.getOrder_id());
			orderService.remove(order.getOrder_id());
			itemService.addCount(orderItem);//★item 재고 수량 살리기
		}
		
		return "redirect:/orderAll";
	}
}
