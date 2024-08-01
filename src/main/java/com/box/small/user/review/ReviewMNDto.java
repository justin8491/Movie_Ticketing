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
public class ReviewMNDto {

    private String mo_name;
    private int mo_no;
    private String mem_id;
    private int rev_no;
    private String rev_content;
    private int rev_rating;
    private Timestamp rev_createdAt;

    // 생성자, 게터, 세터
}
