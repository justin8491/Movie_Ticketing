package com.box.small.admin.movie;

import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.box.small.user.movie.MovieDto;

@Service
public class AdminMovieServiceImpl implements AdminMovieService{
	
	@Inject
	AdminMovieDAO dao;
	
	@Override
	public void addMovie(MovieDto movie) throws SQLException {
		dao.addMovie(movie);
	}

	@Override
	public void deleteMovie(int mo_no) throws SQLException {
		dao.deleteMovie(mo_no);
	}

	@Override
	public void updateMovie(MovieDto movie) throws SQLException {
		dao.updateMovie(movie);
	}

}
