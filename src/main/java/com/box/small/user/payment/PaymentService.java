package com.box.small.user.payment;

import java.util.Map;

public interface PaymentService {

	public PaymentDto paymentdata();
	
	public CardDto selectCardList(Map<Object, Object> params);
	
	public PaymentDto insertPayment(Map<Object, Object> params);
	
	public PaymentDto selectPayment(Map<Object, Object> params);
	
	public void canclePayment(Map<String, Object> params);
}
