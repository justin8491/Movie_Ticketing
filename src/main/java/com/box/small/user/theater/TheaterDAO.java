package com.box.small.user.theater;

import java.sql.SQLException;
import java.util.List;

public interface TheaterDAO {

	List<TheaterDto> selectAllTheater() throws SQLException;	//	영화관 전체 조회
	
	TheaterDto selectTheater(int th_no) throws SQLException;	//	영화관 선택조회
	
	List<TheaterDto> selectAllTheaterLive();

	
}
