package com.box.small.user.movie;

import java.sql.SQLException;
import java.util.List;

public interface MovieService {
	
	List<MovieDto> selectAllMovie() throws SQLException;	//	영화 전체조회
	
	MovieDto selectMovie(int mo_id) throws SQLException;	//	영화 선택 조회
}
