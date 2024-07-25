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
	public List<ScheduleDto> sellectAllSchedule() throws SQLException {
		return dao.sellectAllSchedule();
	}

	@Override
	public ScheduleDto sellectSchedule(int sch_no) throws SQLException {
		return dao.sellectSchedule(sch_no);
	}

	@Override
	public ScheduleDto selectScreenSchedule(Map<String, Object> map) {
		
		return dao.selectScreenSchedule(map);
	}

	@Override
	public List<ScheduleDto> selectScreen(int th_no) {
		
		return dao.selectScreen(th_no);
	}

}
