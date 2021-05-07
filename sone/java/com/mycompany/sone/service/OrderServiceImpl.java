package com.mycompany.sone.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.mycompany.sone.domain.ItemVO;
import com.mycompany.sone.domain.MemberVO;
import com.mycompany.sone.domain.OrderItemVO;
import com.mycompany.sone.domain.OrderVO;
import com.mycompany.sone.dto.OrderDTO;
import com.mycompany.sone.persistence.ItemDAO;
import com.mycompany.sone.persistence.OrderDAO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Inject
	private OrderDAO orderDao;
	
	@Inject
	private ItemDAO itemDao;

	@Override
	public void regist(OrderVO order) throws Exception {
		orderDao.create(order);
	}

	@Override
	public void registOrderItem(OrderItemVO orderItem) throws Exception{
		orderDao.createOrderItem(orderItem);
	}
	
	@Override
	public OrderVO read(Integer order_id) throws Exception {
		return orderDao.read(order_id);
	}
	
	@Override
	public OrderItemVO readOrderItem(Integer order_item_id) throws Exception {
		return orderDao.readOrderItem(order_item_id);
	}

//	@Override
//	public void modify(OrderVO order) throws Exception {
//		orderDao.update(order);
//	}

	@Override
	public void remove(Integer order_id) throws Exception {
		orderDao.delete(order_id);
	}
	
	@Override
	public void removeOrderItem(Integer order_item_id) throws Exception {
		orderDao.deleteOrderItem(order_item_id);
	}

//	@Override
//	public List<OrderVO> listAll() throws Exception {
//		return orderDao.listAll();
//	}
	
	@Override
	public List<OrderItemVO> myListAll(MemberVO member) throws Exception {
		return orderDao.myListAll(member);
	}
}
