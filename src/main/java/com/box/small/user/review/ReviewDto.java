package com.box.small.user.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private int rev_no;
    private String rev_content;
    private Timestamp rev_createdAt;
    private int rev_rating;
    private int rev_status;
    private int mo_no;
    private String mem_id;
    
    public ReviewDto() {}
    
	public ReviewDto(int rev_no, String rev_content, Timestamp rev_createdAt, int rev_rating, int rev_status, int mo_no,
			String mem_id) {
		super();
		this.rev_no = rev_no;
		this.rev_content = rev_content;
		this.rev_createdAt = rev_createdAt;
		this.rev_rating = rev_rating;
		this.rev_status = rev_status;
		this.mo_no = mo_no;
		this.mem_id = mem_id;
	}
	public int getRev_no() {
		return rev_no;
	}
	public void setRev_no(int rev_no) {
		this.rev_no = rev_no;
	}
	public String getRev_content() {
		return rev_content;
	}
	public void setRev_content(String rev_content) {
		this.rev_content = rev_content;
	}
	public Timestamp getRev_createdAt() {
		return rev_createdAt;
	}
	public void setRev_createdAt(Timestamp rev_createdAt) {
		this.rev_createdAt = rev_createdAt;
	}
	public int getRev_rating() {
		return rev_rating;
	}
	public void setRev_rating(int rev_rating) {
		this.rev_rating = rev_rating;
	}
	public int getRev_status() {
		return rev_status;
	}
	public void setRev_status(int rev_status) {
		this.rev_status = rev_status;
	}
	public int getMo_no() {
		return mo_no;
	}
	public void setMo_no(int mo_no) {
		this.mo_no = mo_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
    
    
}
