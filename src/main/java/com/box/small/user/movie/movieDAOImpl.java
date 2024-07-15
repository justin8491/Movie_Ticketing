package com.box.small.user.movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class movieDAOImpl implements movieDAO{	//	������ �Ǿ�� �����ֱ��ѵ� �ϴ� ���� �Ǿ��ٰ� �����ϰ� ��ɹ��� �����س���
	
	@Autowired
	DataSource ds;
	
	@Override
	public List<MovieDto> sellectAllMovie() throws SQLException {	//	movie ���̺��� ��� ������ �������� �޼ҵ�
		Connection conn = ds.getConnection();
		String sql = "select * from movie";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<MovieDto>list = new ArrayList<MovieDto>();
		while(rs.next()) {
			list.add(new MovieDto(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7),
					rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12)));
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}

	@Override
	public MovieDto sellectMovie(int mo_id) throws SQLException {	//	movie ���̺��� mo_id �� ���� Ư�� ��ȭ�� ������ ��������� �޼ҵ�
		Connection conn = ds.getConnection();
		MovieDto movie = null;
		String sql = "select * from movie where mo_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, mo_id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			movie = new MovieDto(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7),
					rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return movie;
	}

	@Override
	public void sellectAlltheater() throws SQLException {	//	theater���̺��� ��� ������ �������� �޼ҵ�
		Connection conn = ds.getConnection();
		
		String sql = "select * from theater";
	}

	@Override
	public void sellectTheater(int th_id) throws SQLException {	//	theater���̺��� th_id�� ���ؼ� Ư�� ������ ������ �������� �޼ҵ�
		Connection conn = ds.getConnection();
		String sql = "select * from theater where th_id = ?";
	}

	@Override
	public void addMovie(MovieDto movie) throws SQLException {	//	Movie���̺� ��ȭ�� �߰��ϴ� �޼ҵ�
		Connection conn = ds.getConnection();
		String sql = "INSERT INTO `movie`.`movie` (`mo_no`,`cat_no`,`mo_name`,`mo_releaseDate`,`mo_endDate`,`mo_runningTime`,";
				sql += "`mo_plot`,`mo_status`,`mo_director`,`mo_mainActor`,`mo_rating`,`mo_Photo`)";
				sql += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, movie.getMo_no());
		pstmt.setInt(2, movie.getCat_no());
		pstmt.setString(3, movie.getMo_name());
		pstmt.setString(4, movie.getMo_releaseDate());
		pstmt.setString(5, movie.getMo_endDate());
		pstmt.setInt(6, movie.getMo_runningTime());
		pstmt.setString(7, movie.getMo_plot());
		pstmt.setString(8, movie.getMo_status());
		pstmt.setString(9, movie.getMo_director());
		pstmt.setString(10, movie.getMo_mainActor());
		pstmt.setString(11, movie.getMo_rating());
		pstmt.setString(12, movie.getMo_Photo());
	}

	@Override
	public void deleteMovie(int mo_id) throws SQLException {	//	mo_id�� �̿��ؼ� movie�� status�� 0���� �ٲٴ� �޼ҵ�
		Connection conn = ds.getConnection();
		String sql = "update movie set mo_status = 0 where mo_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, mo_id);
	}

	@Override
	public void updateMovie(int mo_id, MovieDto movie) throws SQLException {	//	mo_id�� �̿��ؼ� movie�� ������ �����ϴ� �޼ҵ�
		Connection conn = ds.getConnection();
		String sql = "update movie  set";
		sql += "mo_name = ?";
		sql += "cat_category = ?";
		sql += "mo_releaseDate = ?";
		sql += "endDate = ?";
		sql += "runningTime = ?";
		sql += "mo_plot = ?";
		sql += "mo_status = ?";
		sql += "mo_director = ?";
		sql += "mo_mainActor = ?";
		sql += "mo_rating = ?";
		sql += "mo_Photo = ?";
		sql += "where";
		sql += "mo_id = ?";
	}

}
