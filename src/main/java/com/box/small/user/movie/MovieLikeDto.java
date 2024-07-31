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
}
