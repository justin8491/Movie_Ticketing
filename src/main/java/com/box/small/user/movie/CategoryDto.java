package com.box.small.user.movie;

public class CategoryDto {
	 private int cat_no;
	 private String cat_name;
	 
	public int getCat_no() {
		return cat_no;
	}
	public void setCat_no(int cat_no) {
		this.cat_no = cat_no;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public CategoryDto(int cat_no, String cat_name) {
		super();
		this.cat_no = cat_no;
		this.cat_name = cat_name;
	}
	public CategoryDto() {
		super();
	}
	@Override
	public String toString() {
		return "CategoryDto [cat_no=" + cat_no + ", cat_name=" + cat_name + "]";
	}
	 
	
	 
}
