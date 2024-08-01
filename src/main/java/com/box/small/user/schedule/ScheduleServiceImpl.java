package com.box.small.user.schedule;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired
	ScheduleDAO dao;


	@Override
	public List<ScheduleDto> selectAllSchedule() throws SQLException {
		return dao.selectAllSchedule();
	}

	@Override
	public ScheduleDto selectSchedule(int sch_no) throws SQLException {
		return dao.selectSchedule(sch_no);
	}

	@Override
	public List<ScheduleDto> selectScreenSchedule(Map<String, Object> map) {
		
		return dao.selectScreenSchedule(map);
	}

	@Override
	public ScreenDto selectScreen(int sc_no) {
		
		return dao.selectScreen(sc_no);
	}

	@Override
	public List<ScreenDto> selectAllScreen() {
		return dao.selectAllScreen();
	}

	@Override
	public List<ScreenDto> selectScreenTh_no(String th_no) {
		return dao.selectScreenTh_no(th_no);
	}

}
