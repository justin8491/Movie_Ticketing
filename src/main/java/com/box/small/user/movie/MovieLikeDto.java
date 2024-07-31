package com.box.small.user.movie;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieLikeDto {
    private int ml_no;
    private int mo_no;
    private String mem_id;
    private int ml_status;
    
    public MovieLikeDto() {}
    
	public MovieLikeDto(int ml_no, int mo_no, String mem_id, int ml_status) {
		super();
		this.ml_no = ml_no;
		this.mo_no = mo_no;
		this.mem_id = mem_id;
		this.ml_status = ml_status;
	}
	public int getMl_no() {
		return ml_no;
	}
	public void setMl_no(int ml_no) {
		this.ml_no = ml_no;
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
	public int getMl_status() {
		return ml_status;
	}
	public void setMl_status(int ml_status) {
		this.ml_status = ml_status;
	}

	@Override
	public String toString() {
		return "MovieLikeDto [ml_no=" + ml_no + ", mo_no=" + mo_no + ", mem_id=" + mem_id + ", ml_status=" + ml_status
				+ "]";
	}
    
    
	
}
