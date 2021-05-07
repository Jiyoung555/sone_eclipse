package com.mycompany.sone.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mycompany.sone.domain.ItemVO;
import com.mycompany.sone.domain.MemberVO;
import com.mycompany.sone.domain.OrderItemVO;
import com.mycompany.sone.domain.OrderVO;
import com.mycompany.sone.dto.OrderDTO;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Inject
	private SqlSession sqlSession;

	private static String namespace = "OrderMapper";

	@Override
	public void create(OrderVO vo) throws Exception {
		sqlSession.insert(namespace+".create", vo);
	}
	
	@Override
	public void createOrderItem(OrderItemVO orderItem) throws Exception{
		sqlSession.insert(namespace+".createOrderItem", orderItem);
	}

	@Override
	public OrderVO read(Integer order_id) throws Exception {
		return sqlSession.selectOne(namespace + ".read", order_id);
	}

	@Override
	public OrderItemVO readOrderItem(Integer order_item_id) throws Exception {
		return sqlSession.selectOne(namespace + ".readOrderItem", order_item_id);
	}

//	@Override
//	public void update(OrderVO vo) throws Exception {
//		sqlSession.update(namespace+".update", vo);
//	}


	@Override
	public void delete(Integer order_id) throws Exception {
		sqlSession.delete(namespace+".delete", order_id);
	}
	
	@Override
	public void deleteOrderItem(Integer order_item_id) throws Exception {
		sqlSession.delete(namespace+".deleteOrderItem", order_item_id);
	}

//	@Override
//	public List<OrderVO> listAll() throws Exception {
//		return sqlSession.selectList(namespace + ".listAll");
//	}
	
	@Override
	public List<OrderItemVO> myListAll(MemberVO member) throws Exception{
		return sqlSession.selectList(namespace + ".myListAll");
	}
	
}
