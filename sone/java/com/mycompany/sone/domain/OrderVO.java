package com.mycompany.sone.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class OrderVO {
	private Integer order_id;
	private Timestamp date;
	private String orderStatus;
	private Integer member_id;
	//private Integer delivery_id;
	
	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
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

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}

	@Override
	public String toString() {
		return "OrderVO [order_id=" + order_id + ", date=" + date + ", orderStatus=" + orderStatus + ", member_id="
				+ member_id + "]";
	}


	

}
