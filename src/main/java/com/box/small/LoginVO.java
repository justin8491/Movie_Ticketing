package com.box.small;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginVO {
    private String userID;
    private String name;

    public String toString(){
        return "LoginVO [ userID : " + userID + "name : " +name + "]";
    }

}
