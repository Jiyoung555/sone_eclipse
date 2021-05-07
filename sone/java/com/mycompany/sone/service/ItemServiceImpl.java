package com.mycompany.sone.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.mycompany.sone.domain.ItemVO;
import com.mycompany.sone.domain.OrderItemVO;
import com.mycompany.sone.persistence.ItemDAO;


@Service
public class ItemServiceImpl implements ItemService {
	
	@Inject
	private ItemDAO dao;

	@Override
	public void regist(ItemVO item) throws Exception {
		dao.create(item);
	}

	@Override
	public ItemVO read(Integer item_id) throws Exception {
		return dao.read(item_id);
	}

	@Override
	public void modify(ItemVO item) throws Exception {
		dao.update(item);
	}

	@Override
	public void remove(Integer item_id) throws Exception {
		dao.delete(item_id);
	}

	@Override
	public List<ItemVO> listAll() throws Exception {
		return dao.listAll();
	}
	
	@Override
	public void removeCount(OrderItemVO orderItem) throws Exception {
		dao.removeCount(orderItem); //item 재고 수량 빼기
	}

	@Override
	public void addCount(OrderItemVO orderItem) throws Exception {
		dao.addCount(orderItem); //item 재고 수량 살리기
	}
}
