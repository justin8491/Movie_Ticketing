package com.box.small.user.schedule;

public class BookingDto {

	int mo_no;
	String sch_no;
	int th_no;
	
	
	
	public BookingDto(int mo_no, String sch_no, int th_no) {
		super();
		this.mo_no = mo_no;
		this.sch_no = sch_no;
		this.th_no = th_no;
	}
	
	public int getMo_no() {
		return mo_no;
	}
	public void setMo_no(int mo_no) {
		this.mo_no = mo_no;
	}
	public String getSch_no() {
		return sch_no;
	}
	public void setSch_no(String sch_no) {
		this.sch_no = sch_no;
	}
	public int getTh_no() {
		return th_no;
	}
	public void setTh_no(int th_no) {
		this.th_no = th_no;
	}
	
	
}
