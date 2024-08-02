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
	public List<ScheduleDto> selectAllSchedule() throws SQLException {
		return sqlSession.selectList(namespace+".selectAllSchedule");
	}

	@Override
	public ScheduleDto selectSchedule(int sch_no) throws SQLException {
		return sqlSession.selectOne(namespace+".selectSchedule", sch_no);
	}

	@Override
	public List<ScheduleDto> selectScreenSchedule(Map<String, Object> map) {
		// TODO Auto-generated method stub
		System.out.println("dao적용.");
		System.out.println("map , mo_no= " + map.get("mo_no"));
		System.out.println("map , th_no= " + map.get("th_no"));
		System.out.println("map , sch_date= " + map.get("sch_date"));
		System.out.println("map , sc_no= " + map.get("sc_no"));
		return sqlSession.selectList(namespace+".selectScreenSchedule", map);
	}

	@Override
	public ScreenDto selectScreen(int sc_no) {
		return sqlSession .selectOne(namespace+".selectScreen", sc_no);
	}

	@Override
	public List<ScreenDto> selectAllScreen() {
		return sqlSession .selectList(namespace+".selectAllScreen");
	}

	@Override
	public List<ScreenDto> selectScreenTh_no(int th_no) {
		return sqlSession .selectList(namespace+".selectScreenTh_no", th_no);
	}


	
}
