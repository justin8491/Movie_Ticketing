package com.box.small.dao.user.movie;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.box.small.dto.Movie;

public interface movieDAO {
    
	List<Movie> sellectAllMovie() throws SQLException;	//	movie 테이블에서 모든 정보를 가져오는 메소드
	
	Movie sellectMovie(int mo_id) throws SQLException;	//	movie 테이블에서 mo_id 를 통해 특정 영화의 정보만 가지고오는 메소드
	
	void sellectAlltheater() throws SQLException;	//	theater테이블에서 모든 정보를 가져오는 메소드
	
	void sellectTheater(int th_id) throws SQLException;	//	theater테이블에서 th_id를 통해서 특정 극장의 정보만 가져오는 메소드
	
	void addMovie(Movie movie) throws SQLException;	//	Movie테이블에 영화를 추가하는 메소드
	
	void deleteMovie(int mo_id) throws SQLException;	//	mo_id를 이용해서 movie의 status를 0으로 바꾸는 메소드
	
	void updateMovie(int mo_id, Movie movie) throws SQLException;	//	mo_id를 이용해서 movie의 정보를 수정하는 메소드
	
}
