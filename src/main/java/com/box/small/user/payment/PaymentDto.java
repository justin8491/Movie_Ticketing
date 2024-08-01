package com.box.small.user.payment;

import java.time.LocalDateTime;
import java.util.Date;

public class PaymentDto {

	private int pay_no; 
	private String ca_id;
	private LocalDateTime pay_date; 
	private int pay_status; 
	private int pay_amount;
	

	
	
	public PaymentDto(int pay_no, String ca_id, LocalDateTime pay_date, int pay_status, int pay_amount) {
		this.pay_no = pay_no;
		this.ca_id = ca_id;
		this.pay_date = pay_date;
		this.pay_status = pay_status;
		this.pay_amount = pay_amount;
	}

	public PaymentDto( String ca_id, LocalDateTime pay_date,  int pay_amount) {
		this.ca_id = ca_id;
		this.pay_date = pay_date;		
		this.pay_amount = pay_amount;
	}

	public int getPay_no() {
		return pay_no;
	}

	public void setPay_no(int pay_no) {
		this.pay_no = pay_no;
	}

	public String getCa_id() {
		return ca_id;
	}

	public void setCa_id(String ca_id) {
		this.ca_id = ca_id;
	}

	public LocalDateTime getPay_date() {
		return pay_date;
	}

	public void setPay_date(LocalDateTime pay_date) {
		this.pay_date = pay_date;
	}

	public int getPay_status() {
		return pay_status;
	}

	public void setPay_status(int pay_status) {
		this.pay_status = pay_status;
	}

	public int getPay_amount() {
		return pay_amount;
	}

	public void setPay_amount(int pay_amount) {
		this.pay_amount = pay_amount;
	} 
	
	
}
