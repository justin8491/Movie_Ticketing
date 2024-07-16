package com.box.small.dto;

public class Support {
	private int bo_no;
	private int cat_no;
	private String bo_writerId;
	private String bo_title;
	private String bo_content;
	private String bo_createAt;
	private int bo_status;
	
	public Support(int bo_no, int cat_no, String bo_writerId, String bo_title, String bo_content, String bo_createAt,
			int bo_status) {
		super();
		this.bo_no = bo_no;
		this.cat_no = cat_no;
		this.bo_writerId = bo_writerId;
		this.bo_title = bo_title;
		this.bo_content = bo_content;
		this.bo_createAt = bo_createAt;
		this.bo_status = bo_status;
	}

	public int getBo_no() {
		return bo_no;
	}

	public void setBo_no(int bo_no) {
		this.bo_no = bo_no;
	}

	public int getCat_no() {
		return cat_no;
	}

	public void setCat_no(int cat_no) {
		this.cat_no = cat_no;
	}

	public String getBo_writerId() {
		return bo_writerId;
	}

	public void setBo_writerId(String bo_writerId) {
		this.bo_writerId = bo_writerId;
	}

	public String getBo_title() {
		return bo_title;
	}

	public void setBo_title(String bo_title) {
		this.bo_title = bo_title;
	}

	public String getBo_content() {
		return bo_content;
	}

	public void setBo_content(String bo_content) {
		this.bo_content = bo_content;
	}

	public String getBo_createAt() {
		return bo_createAt;
	}

	public void setBo_createAt(String bo_createAt) {
		this.bo_createAt = bo_createAt;
	}

	public int getBo_status() {
		return bo_status;
	}

	public void setBo_status(int bo_status) {
		this.bo_status = bo_status;
	}

	@Override
	public String toString() {
		return "Support [bo_no=" + bo_no + ", cat_no=" + cat_no + ", bo_writerId=" + bo_writerId + ", bo_title="
				+ bo_title + ", bo_content=" + bo_content + ", bo_createAt=" + bo_createAt + ", bo_status=" + bo_status
				+ "]";
	}
	
	
	
	
	

}
