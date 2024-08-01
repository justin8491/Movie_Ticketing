package com.box.small.user.reservation;


public class ReservationDto {
	
	private int res_no; 
	private String mem_id; 
	private int msh_id; 
	private int ts_no; 
	private int mo_no; 
	private int pay_no;
	private int sch_no;
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
	public int getTs_no() {
		return ts_no;
	}
	public void setTs_no(int ts_no) {
		this.ts_no = ts_no;
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
	public int getSch_no() {
		return sch_no;
	}
	public void setSch_no(int sch_no) {
		this.sch_no = sch_no;
	}
	public ReservationDto(int res_no, String mem_id, int msh_id, int ts_no, int mo_no, int pay_no, int sch_no) {
		this.res_no = res_no;
		this.mem_id = mem_id;
		this.msh_id = msh_id;
		this.ts_no = ts_no;
		this.mo_no = mo_no;
		this.pay_no = pay_no;
		this.sch_no = sch_no;
	}
	public ReservationDto() {
	}
	@Override
	public String toString() {
		return "ReservationDto [res_no=" + res_no + ", mem_id=" + mem_id + ", msh_id=" + msh_id + ", ts_no=" + ts_no
				+ ", mo_no=" + mo_no + ", pay_no=" + pay_no + ", sch_no=" + sch_no + "]";
	}
	
	
	

	

	
	
}
