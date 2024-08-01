package com.box.small.admin.admin;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class AdminDto {
    private String a_id;
    private String a_password;
    
	@Override
	public String toString() {
		return "AdminDto [a_id=" + a_id + ", a_password=" + a_password + "]";
	}
	public AdminDto() {
		super();
	}
	public AdminDto(String a_id, String a_password) {
		super();
		this.a_id = a_id;
		this.a_password = a_password;
	}
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getA_password() {
		return a_password;
	}
	public void setA_password(String a_password) {
		this.a_password = a_password;
	}
    
    
    
}
