package com.box.small.admin.schedule;

import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.box.small.user.movie.MovieDto;
import com.box.small.user.schedule.ScheduleDto;

@Service
public class AdminScheduleServiceImpl implements AdminScheduleService{
	
	@Inject
	AdminScheduleDAO dao;

	@Override
	public void addSchedule(ScheduleDto schedule) throws SQLException {
		dao.addSchedule(schedule);
	}

	@Override
	public void deleteSchedule(int sch_no) throws SQLException {
		dao.deleteSchedule(sch_no);
	}

	@Override
	public void updateSchedule(ScheduleDto schedule) throws SQLException {
		dao.updateSchedule(schedule);
	}
	


}
