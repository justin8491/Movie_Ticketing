package com.box.small.user.movie;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface MovieDAO {
    
	List<MovieDto> sellectAllMovie() throws SQLException;	//	movie ���̺��� ��� ������ �������� �޼ҵ�
	
	MovieDto sellectMovie(int mo_id) throws SQLException;	//	movie ���̺��� mo_id �� ���� Ư�� ��ȭ�� ������ ��������� �޼ҵ�
	
	void sellectAlltheater() throws SQLException;	//	theater���̺��� ��� ������ �������� �޼ҵ�
	
	void sellectTheater(int th_id) throws SQLException;	//	theater���̺��� th_id�� ���ؼ� Ư�� ������ ������ �������� �޼ҵ�
	
	void addMovie(MovieDto movie) throws SQLException;	//	Movie���̺� ��ȭ�� �߰��ϴ� �޼ҵ�
	
	void deleteMovie(int mo_id) throws SQLException;	//	mo_id�� �̿��ؼ� movie�� status�� 0���� �ٲٴ� �޼ҵ�
	
	void updateMovie(int mo_id, MovieDto movie) throws SQLException;	//	mo_id�� �̿��ؼ� movie�� ������ �����ϴ� �޼ҵ�
	
}
