package com.mycompany.sone.persistence;

import java.util.List;

import com.mycompany.sone.domain.ItemVO;
import com.mycompany.sone.domain.MemberVO;
import com.mycompany.sone.domain.OrderItemVO;
import com.mycompany.sone.domain.OrderVO;
import com.mycompany.sone.dto.OrderDTO;

public interface OrderDAO {
	
	public void create(OrderVO vo) throws Exception;
	public void createOrderItem(OrderItemVO orderItem) throws Exception;
	
	public OrderVO read(Integer order_id) throws Exception;
	public OrderItemVO readOrderItem(Integer order_item_id) throws Exception;

	//public void update(OrderVO vo) throws Exception;

	public void delete(Integer order_id) throws Exception;
	public void deleteOrderItem(Integer order_item_id) throws Exception;
	
	//public List<OrderVO> listAll() throws Exception; //List는 util
	public List<OrderItemVO> myListAll(MemberVO member) throws Exception;
}
