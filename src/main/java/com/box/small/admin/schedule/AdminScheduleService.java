package com.box.small.admin.schedule;

import java.sql.SQLException;

import com.box.small.user.schedule.ScheduleDto;

public interface AdminScheduleService {

	void addSchedule(ScheduleDto schedule) throws SQLException;	// 스케줄추가
	
	void deleteSchedule(int sch_no) throws SQLException;	//	스케줄삭제
	
	void updateSchedule(ScheduleDto schedule) throws SQLException;	//	스케줄수정
	
}
