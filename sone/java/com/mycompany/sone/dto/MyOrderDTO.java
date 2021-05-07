package com.mycompany.sone.dto;

import java.sql.Timestamp;

public class MyOrderDTO {
	private Integer order_id; //order
	private Timestamp date;
	private String orderStatus;
	
	private Integer order_item_id; //orderItem
	private Integer count; 
	private Integer orderprice;
	private Integer totalprice;
	
	private String name; //item
	private String imagename;
	
	
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(Integer orderprice) {
		this.orderprice = orderprice;
	}
	public Integer getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Integer totalprice) {
		this.totalprice = totalprice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public Integer getOrder_item_id() {
		return order_item_id;
	}
	public void setOrder_item_id(Integer order_item_id) {
		this.order_item_id = order_item_id;
	}
	@Override
	public String toString() {
		return "MyOrderDTO [order_id=" + order_id + ", date=" + date + ", orderStatus=" + orderStatus
				+ ", order_item_id=" + order_item_id + ", count=" + count + ", orderprice=" + orderprice
				+ ", totalprice=" + totalprice + ", name=" + name + ", imagename=" + imagename + "]";
	}

	
	
}
