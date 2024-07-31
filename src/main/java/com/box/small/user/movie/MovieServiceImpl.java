package com.box.small.user.movie;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieDAO dao;
	
	@Override
	public List<MovieDto> selectAllMovie() throws SQLException {
		return dao.selectAllMovie();
	}

	@Override
	public MovieDto selectMovie(int mo_no) throws SQLException {
		return dao.selectMovie(mo_no);
	}

	@Override
	public String category(int cat_no) {
		return dao.category(cat_no);
	}

	@Override
	public List<CategoryDto> allCategory() {
		return dao.allCategory();
	}

	@Override
	public boolean checkMovieLike(MovieLikeDto ml) {
		return dao.checkMovieLike(ml);
	}

	@Override
	public int insertMovieLike(MovieLikeDto ml) {
		return dao.insertMovieLike(ml);
	}

	@Override
	public int updateMovieLike(MovieLikeDto ml) {
		return dao.updateMovieLike(ml);
	}

	@Override
	public MovieLikeDto MovieLikeStatus(MovieLikeDto ml) {
		return dao.MovieLikeStatus(ml);
	}


}
