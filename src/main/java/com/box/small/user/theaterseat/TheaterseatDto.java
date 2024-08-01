package com.box.small.user.theaterseat;

public class TheaterseatDto {

	private int ts_no;
	private String ts_id;
	private int sc_no;
	private int ts_reservationStatus;
	private int sch_no;

	public int getTs_no() {
		return ts_no;
	}

	public void setTs_no(int ts_no) {
		this.ts_no = ts_no;
	}

	public String getTs_id() {
		return ts_id;
	}

	public void setTs_id(String ts_id) {
		this.ts_id = ts_id;
	}

	public int getSc_no() {
		return sc_no;
	}

	public void setSc_no(int sc_no) {
		this.sc_no = sc_no;
	}

	public int getTs_reservationStatus() {
		return ts_reservationStatus;
	}

	public void setTs_reservationStatus(int ts_reservationStatus) {
		this.ts_reservationStatus = ts_reservationStatus;
	}

	public int getSch_no() {
		return sch_no;
	}

	public void setSch_no(int sch_no) {
		this.sch_no = sch_no;
	}

	public TheaterseatDto(int ts_no, String ts_id, int sc_no, int ts_reservationStatus, int sch_no) {
		super();
		this.ts_no = ts_no;
		this.ts_id = ts_id;
		this.sc_no = sc_no;
		this.ts_reservationStatus = ts_reservationStatus;
		this.sch_no = sch_no;
	}

	public TheaterseatDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TheaterseatDto [ts_no=" + ts_no + ", ts_id=" + ts_id + ", sc_no=" + sc_no + ", ts_reservationStatus="
				+ ts_reservationStatus + ", sch_no=" + sch_no + "]";
	}

}