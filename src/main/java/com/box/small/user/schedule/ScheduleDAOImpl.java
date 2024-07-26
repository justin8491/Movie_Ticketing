package com.box.small.user.schedule;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO{
	private final static String namespace = "com.box.small.scheduleMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ScheduleDto> sellectAllSchedule() throws SQLException {
		return sqlSession.selectList(namespace+".selectAllSchedule");
	}

	@Override
	public ScheduleDto sellectSchedule(int sch_no) throws SQLException {
		return sqlSession.selectOne(namespace+".selectSchedule", sch_no);
	}

	@Override
	public ScheduleDto selectScreenSchedule(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".selectScreenSchedule", map);
	}

	@Override
	public ScreenDto selectScreen(int sc_no) {
		return sqlSession .selectOne(namespace+".selectScreen", sc_no);
	}

	@Override
	public List<ScreenDto> sellectAllScreen() {
		return sqlSession .selectList(namespace+".selectAllScreen");
	}

	@Override
	public ScreenDto selectScreenTh_no(int th_no) {
		return sqlSession .selectOne(namespace+".selectScreenTh_no", th_no);
	}


	
}
