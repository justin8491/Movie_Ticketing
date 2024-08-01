package com.box.small.user.payment;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDAOImpl implements PaymentDAO {

	private final static String namespace = "com.box.small.paymentMapper"; 
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public PaymentDto paymentdata() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.box.small.paymentMapper");
	}

	@Override
	public CardDto selectCardList(Map<Object, Object> params) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".selectCardList", params);
	}

	@Override
	public PaymentDto insertPayment(Map<Object, Object> params) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".insertPayment", params);
	}

	@Override
	public PaymentDto selectPayment(Map<Object, Object> params) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".selectPayment", params);
	}

	@Override
	public void canclePayment(Map<String, Object> params) {
		sqlSession.selectOne(namespace+".canclePayment", params);
	}



}
