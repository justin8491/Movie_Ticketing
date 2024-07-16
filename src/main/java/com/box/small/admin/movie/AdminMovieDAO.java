package com.box.small.admin.movie;

import java.sql.SQLException;

import com.box.small.user.movie.MovieDto;

public interface AdminMovieDAO {
	
	void addMovie(MovieDto movie) throws SQLException;	//	영화추가
	
	void deleteMovie(MovieDto movie) throws SQLException;	//	영화삭제
	
	void updateMovie(MovieDto movie) throws SQLException;	//	영화수정
}
