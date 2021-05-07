package com.mycompany.sone.service;

import java.util.List;
import com.mycompany.sone.domain.ItemVO;
import com.mycompany.sone.domain.MemberVO;
import com.mycompany.sone.domain.OrderItemVO;

public interface ItemService {
	  public void regist(ItemVO item) throws Exception;

	  public ItemVO read(Integer item_id) throws Exception;

	  public void modify(ItemVO item) throws Exception;

	  public void remove(Integer item_id) throws Exception;

	  public List<ItemVO> listAll() throws Exception;
	  
	  public void removeCount(OrderItemVO orderItem) throws Exception; //재고 수량 빼기
	  public void addCount(OrderItemVO orderItem) throws Exception; //재고 수량 살리기
	  
}
