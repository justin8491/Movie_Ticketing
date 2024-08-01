package com.box.small.user.payment;

import java.util.Date;

public class CardDto {

	
	private String ca_id; 
	private String mem_id; 
	private int ca_password; 
	private int ca_cvc; 
	private Date ca_expirationDate; 
	private String ca_cardCompany;
	
	
	
	public CardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CardDto(int ca_password) {
		this.ca_password = ca_password;
	}
	
	public CardDto(String ca_id, String mem_id, int ca_password, int ca_cvc, Date ca_expirationDate,
			String ca_cardCompany) {
		super();
		this.ca_id = ca_id;
		this.mem_id = mem_id;
		this.ca_password = ca_password;
		this.ca_cvc = ca_cvc;
		this.ca_expirationDate = ca_expirationDate;
		this.ca_cardCompany = ca_cardCompany;
	}
	public String getCa_id() {
		return ca_id;
	}
	public void setCa_id(String ca_id) {
		this.ca_id = ca_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getCa_password() {
		return ca_password;
	}
	public void setCa_password(int ca_password) {
		this.ca_password = ca_password;
	}
	public int getCa_cvc() {
		return ca_cvc;
	}
	public void setCa_cvc(int ca_cvc) {
		this.ca_cvc = ca_cvc;
	}
	public Date getCa_expirationDate() {
		return ca_expirationDate;
	}
	public void setCa_expirationDate(Date ca_expirationDate) {
		this.ca_expirationDate = ca_expirationDate;
	}
	public String getCa_cardCompany() {
		return ca_cardCompany;
	}
	public void setCa_cardCompany(String ca_cardCompany) {
		this.ca_cardCompany = ca_cardCompany;
	}
	
	
	
	
}
