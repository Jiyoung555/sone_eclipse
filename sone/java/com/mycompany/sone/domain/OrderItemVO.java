package com.mycompany.sone.domain;

public class OrderItemVO {
	private Integer order_item_id;
	private Integer count;
	private Integer orderprice;
	private Integer totalprice;
	private Integer item_id;
	private Integer order_id;
	
	
	public Integer getOrder_item_id() {
		return order_item_id;
	}
	public void setOrder_item_id(Integer order_item_id) {
		this.order_item_id = order_item_id;
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
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	@Override
	public String toString() {
		return "OrderItemVO [order_item_id=" + order_item_id + ", count=" + count + ", orderprice=" + orderprice
				+ ", totalprice=" + totalprice + ", item_id=" + item_id + ", order_id=" + order_id + "]";
	}
	
	
}
