package com.box.small.user.schedule;

public class ScreenDto {
	private int sc_no;
	private int th_no;
	private int sc_status;
	private String sc_name;
	
	
	
	@Override
	public String toString() {
		return "ScreenDto [sc_no=" + sc_no + ", th_no=" + th_no + ", sc_status=" + sc_status + ", sc_name=" + sc_name
				+ "]";
	}
	public ScreenDto() {
		super();
	}
	public ScreenDto(int sc_no, int th_no, int sc_status, String sc_name) {
		super();
		this.sc_no = sc_no;
		this.th_no = th_no;
		this.sc_status = sc_status;
		this.sc_name = sc_name;
	}
	public int getSc_no() {
		return sc_no;
	}
	public void setSc_no(int sc_no) {
		this.sc_no = sc_no;
	}
	public int getTh_no() {
		return th_no;
	}
	public void setTh_no(int th_no) {
		this.th_no = th_no;
	}
	public int getSc_status() {
		return sc_status;
	}
	public void setSc_status(int sc_status) {
		this.sc_status = sc_status;
	}
	public String getSc_name() {
		return sc_name;
	}
	public void setSc_name(String sc_name) {
		this.sc_name = sc_name;
	}
	
	
	
}
