package com.mycompany.sone.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.mycompany.sone.domain.ItemVO;
import com.mycompany.sone.domain.MemberVO;
import com.mycompany.sone.domain.OrderItemVO;

@Repository
public class ItemDAOImpl implements ItemDAO {

	@Inject
	private SqlSession sqlSession;

	private static String namespace = "ItemMapper";

	@Override
	public void create(ItemVO vo) throws Exception {
		sqlSession.insert(namespace+".create", vo);
	}

	@Override
	public ItemVO read(Integer item_id) throws Exception {
		return sqlSession.selectOne(namespace + ".read", item_id);
	}


	@Override
	public void update(ItemVO vo) throws Exception {
		sqlSession.update(namespace+".update", vo);
	}


	@Override
	public void delete(Integer item_id) throws Exception {
		sqlSession.delete(namespace+".delete", item_id);
	}

	@Override
	public List<ItemVO> listAll() throws Exception {
		return sqlSession.selectList(namespace + ".listAll");
	}
	
	//-----------------------------------
	
	@Override //재고 수량 빼기
	public void removeCount(OrderItemVO orderItem) throws Exception{
		sqlSession.update(namespace+".removeStock", orderItem);
	}

	@Override //재고 수량 살리기
	public void addCount(OrderItemVO orderItem) throws Exception{
		sqlSession.update(namespace+".addStock", orderItem);
	}	
}
