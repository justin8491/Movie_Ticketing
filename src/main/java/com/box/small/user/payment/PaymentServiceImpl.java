package com.box.small.user.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	PaymentDAOImpl paymentDao; 
	
	@Override
	public PaymentDTO paymentdata() {
		
		return paymentDao.paymentdata();
	}

}
