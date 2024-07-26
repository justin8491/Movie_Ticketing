package com.box.small.user.schedule;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface ScheduleService {
	
	List<ScheduleDto> sellectAllSchedule() throws SQLException;	//	스케줄 전체 조회
	
	ScheduleDto sellectSchedule(int sch_no) throws SQLException;	//	스케줄 선택조회

	ScheduleDto selectScreenSchedule(Map<String, Object> map);
	
	ScreenDto selectScreen(int sc_no); // 영화관으로 상영관 조회
	
	List<ScreenDto> sellectAllScreen();//상영관 전체조회
	
	ScreenDto selectScreenTh_no(int th_no);//영화관 번호로 상영관 조회
}
