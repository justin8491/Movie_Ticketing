package com.box.small.admin.schedule;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.box.small.user.movie.MovieDto;
import com.box.small.user.schedule.ScheduleDto;

@Repository
public class AdminScheduleImpl implements AdminScheduleDAO{
	@Autowired
	private final static String namespace="com.box.small.adminMovieMapper";
	@Autowired
	private SqlSession sqlSession;
	@Override
	public void addSchedule(ScheduleDto schedule) throws SQLException {
		sqlSession.insert(namespace+".addSchedule", schedule);
		
	}
	@Override
	public void deleteSchedule(int sch_no) throws SQLException {
		sqlSession.update(namespace+".deleteSchedule", sch_no);
		
	}
	@Override
	public void updateSchedule(ScheduleDto schedule) throws SQLException {
		sqlSession.update(namespace+".updateSchedule", schedule);
	}
	


}
