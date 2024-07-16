package com.box.small.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String mem_id;
    private String mem_password;
    private String mem_name;
    private String mem_ssn;
    private String mem_poneNumber;
    private int mem_accumulatedAmount;
    private int mem_status;
    private String mem_address;

    public Member(String mem_id, String mem_password){
        this.mem_id = mem_id;
        this.mem_password = mem_password;
    }

}
