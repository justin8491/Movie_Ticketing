package com.box.small.user.payment;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDAOImpl implements PaymentDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public PaymentDTO paymentdata() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.box.small.memberMapper");
	}

}
