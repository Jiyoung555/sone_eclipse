package com.mycompany.sone.service;

import java.util.List;

import com.mycompany.sone.domain.MemberVO;
import com.mycompany.sone.domain.OrderItemVO;
import com.mycompany.sone.domain.OrderVO;

public interface OrderService {
	  public void regist(OrderVO order) throws Exception;
	  public void registOrderItem(OrderItemVO orderItem) throws Exception;

	  public OrderVO read(Integer order_id) throws Exception;
	  public OrderItemVO readOrderItem(Integer order_item_id) throws Exception;

	  //public void modify(OrderVO order) throws Exception;

	  public void remove(Integer order_id) throws Exception;
	  public void removeOrderItem(Integer order_item_id) throws Exception;

	  //public List<OrderVO> listAll() throws Exception;
	  public List<OrderItemVO> myListAll(MemberVO member) throws Exception;
}
