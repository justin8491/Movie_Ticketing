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
    private int rev_id;
    private String rev_content;
    private Timestamp rev_createdAt;
    private int rev_rating;
    private int rev_status;
    private int mo_no;
    private String mem_id;
}
