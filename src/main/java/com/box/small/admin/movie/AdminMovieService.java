package com.box.small.admin.movie;

import java.sql.SQLException;

import com.box.small.user.movie.MovieDto;

public interface AdminMovieService {

	void addMovie(MovieDto movie) throws SQLException;	//	영화추가
	
	void deleteMovie(int mo_no) throws SQLException;	//	영화삭제
	
	void updateMovie(MovieDto movie) throws SQLException;	//	영화수정
	
}
