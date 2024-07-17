package com.box.small.user.theater;

public class TheaterDto {
	
	private int th_no;
	private String th_location;
	private String th_name;
	private int th_status;
	private String th_photo;
	
	@Override
	public String toString() {
		return "TheaterDto [th_no=" + th_no + ", th_location=" + th_location + ", th_name=" + th_name + ", th_status="
				+ th_status + ", th_photo=" + th_photo + "]";
	}

	public TheaterDto(int th_no, String th_location, String th_name, int th_status, String th_photo) {
		super();
		this.th_no = th_no;
		this.th_location = th_location;
		this.th_name = th_name;
		this.th_status = th_status;
		this.th_photo = th_photo;
	}

	public TheaterDto() {
		super();
	}

	public int getTh_no() {
		return th_no;
	}

	public void setTh_no(int th_no) {
		this.th_no = th_no;
	}

	public String getTh_location() {
		return th_location;
	}

	public void setTh_location(String th_location) {
		this.th_location = th_location;
	}

	public String getTh_name() {
		return th_name;
	}

	public void setTh_name(String th_name) {
		this.th_name = th_name;
	}

	public int getTh_status() {
		return th_status;
	}

	public void setTh_status(int th_status) {
		this.th_status = th_status;
	}

	public String getTh_photo() {
		return th_photo;
	}

	public void setTh_photo(String th_photo) {
		this.th_photo = th_photo;
	}
	
	
	
}
