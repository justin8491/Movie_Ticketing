package com.box.small.user.schedule;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO{
	private final static String namespace = "com.box.small.theaterMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ScheduleDto> sellectAllSchedule() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScheduleDto sellectSchedule(int sch_no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScheduleDto selectScreenSchedule(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".selectScreenSchedule", map);
	}

	@Override
	public List<ScheduleDto> selectScreen(int th_no) {
		// TODO Auto-generated method stub
		return sqlSession .selectList(namespace+".selectScreen", th_no);
	}


	
}
