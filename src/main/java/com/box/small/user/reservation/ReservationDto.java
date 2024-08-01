package com.box.small.user.reservation;


public class ReservationDto {
	
	private int res_no; 
	private String mem_id; 
	private int msh_id; 
	private String ts_id; 
	private int mo_no; 
	private int pay_no;
	
	
	
	public int getRes_no() {
		return res_no;
	}


	public void setRes_no(int res_no) {
		this.res_no = res_no;
	}


	public String getMem_id() {
		return mem_id;
	}


	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}


	public int getMsh_id() {
		return msh_id;
	}


	public void setMsh_id(int msh_id) {
		this.msh_id = msh_id;
	}


	public String getTs_id() {
		return ts_id;
	}


	public void setTs_id(String ts_id) {
		this.ts_id = ts_id;
	}


	public int getMo_no() {
		return mo_no;
	}


	public void setMo_no(int mo_no) {
		this.mo_no = mo_no;
	}


	public int getPay_no() {
		return pay_no;
	}


	public void setPay_no(int pay_no) {
		this.pay_no = pay_no;
	}


	public ReservationDto(int res_no, String mem_id, int msh_id, String ts_id, int mo_no, int pay_no) {
		this.res_no = res_no;
		this.mem_id = mem_id;
		this.msh_id = msh_id;
		this.ts_id = ts_id;
		this.mo_no = mo_no;
		this.pay_no = pay_no;
	}

	
public ReservationDto() {
	}
	

	
	
}
