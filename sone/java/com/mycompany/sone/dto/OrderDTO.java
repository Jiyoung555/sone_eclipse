package com.mycompany.sone.dto;

import java.sql.Timestamp;
import com.mycompany.sone.domain.ItemVO;
import com.mycompany.sone.domain.OrderItemVO;
import com.mycompany.sone.domain.OrderVO;

public class OrderDTO {
	private Integer item_id;
	private Integer member_id;
	private Timestamp date;
	private String orderStatus;
	
	public OrderVO toOrderVO(int member_id) {
		OrderVO orderVO = new OrderVO();
		orderVO.setMember_id(member_id);
		orderVO.setOrderStatus("ORDERED");
		//date는 db에서 현재 시간으로 default
		return orderVO;
	}
	
	public OrderItemVO toOrderItemVO(ItemVO item, int order_id) {
		OrderItemVO orderItem = new OrderItemVO();
		orderItem.setCount(2);
		orderItem.setOrderprice(item.getPrice());
		orderItem.setTotalprice(2 * item.getPrice());
		orderItem.setItem_id(item.getItem_id());
		orderItem.setOrder_id(order_id);
		return orderItem;
	}
	
	public OrderDTO() {}

	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}



	


}
