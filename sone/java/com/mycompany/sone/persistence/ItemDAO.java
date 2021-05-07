package com.mycompany.sone.persistence;

import java.util.List;
import com.mycompany.sone.domain.ItemVO;
import com.mycompany.sone.domain.OrderItemVO;

public interface ItemDAO {
	public void create(ItemVO vo) throws Exception;

	public ItemVO read(Integer item_id) throws Exception;

	public void update(ItemVO vo) throws Exception;

	public void delete(Integer item_id) throws Exception;

	public List<ItemVO> listAll() throws Exception; //List는 util
	
	//--------------------------------------
	
	public void removeCount(OrderItemVO orderItem) throws Exception;
	public void addCount(OrderItemVO orderItem) throws Exception;
}
