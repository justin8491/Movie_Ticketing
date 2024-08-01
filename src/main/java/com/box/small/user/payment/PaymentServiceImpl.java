package com.box.small.user.payment;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	PaymentDAOImpl paymentDao; 
	
	@Override
	public PaymentDto paymentdata() {
		
		return paymentDao.paymentdata();
	}

	@Override
	public CardDto selectCardList(Map<Object, Object> params) {
		// TODO Auto-generated method stub
		return paymentDao.selectCardList(params);
	}

	@Override
	public PaymentDto insertPayment(Map<Object, Object> params) {
		// TODO Auto-generated method stub
		return paymentDao.insertPayment(params);
	}

	@Override
	public PaymentDto selectPayment(Map<Object, Object> params) {
		// TODO Auto-generated method stub
		return paymentDao.selectPayment(params);
	}

	@Override
	public void canclePayment(Map<String, Object> params) {
		paymentDao.canclePayment(params);
		
	}

	

}
