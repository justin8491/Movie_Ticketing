package com.box.small.user.movie;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface MovieDAO {
    
	List<MovieDto> selectAllMovie() throws SQLException;	//	영화 전체조회
	
	MovieDto selectMovie(int mo_no) throws SQLException;	//	영화 선택 조회
	
	String category(int cat_no);
	
	List<CategoryDto> allCategory();

	MovieLikeDto insertOrUpdateMovieLike(MovieLikeDto ml);
}
