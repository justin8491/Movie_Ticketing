package com.box.small.user.theater;

import java.sql.SQLException;
import java.util.List;


public interface TheaterService {
	
	List<TheaterDto> sellectAlltheater() throws SQLException;	//	영화관 전체 조회
	
	TheaterDto sellectTheater(int th_no) throws SQLException;	//	영화관 선택조회

}
