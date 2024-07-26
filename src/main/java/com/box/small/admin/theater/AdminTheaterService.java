package com.box.small.admin.theater;

import java.sql.SQLException;

import com.box.small.user.movie.MovieDto;
import com.box.small.user.theater.TheaterDto;

public interface AdminTheaterService {
	
	void addTheater(TheaterDto theater) throws SQLException;	//	영화추가
	
	void deleteTheater(int th_no) throws SQLException;	//	영화삭제
	
	void updateTheater(TheaterDto theater) throws SQLException;	//	영화수정
}
