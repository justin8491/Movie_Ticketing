package com.box.small.user.payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {

	private int pay_no; 
	private int ca_id;
	private int pay_date; 
	private String pay_method;
	private String pay_accountNumber;
	private int pay_status; 
	private int pay_amount; 
	
}
