package com.box.small.user.theaterseat;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TheaterseatDAOImlp implements TheaterseatDAO{

	@Autowired
	private SqlSession sqlSession;
	String namepaces = "com.box.small.theaterseatMapper";
	
	@Override
	public List<TheaterseatDto> theaterseatList(Map<String, Object> params) {
		return sqlSession.selectList(namepaces+".theaterseatList", params);
	}

	@Override
	public void reservationSeat(Map<Object, Object> params) {
		sqlSession.selectOne(namepaces+".reservationSeat", params);
	}

	@Override
	public void cancelSeat(Map<String, Object> params) {
		sqlSession.selectOne(namepaces+".cancelSeat", params);
	}

	@Override
	public TheaterseatDto selectSeat(Map<String, Object> params) {
		return sqlSession.selectOne(namepaces+".selectSeat", params);
	}

	@Override
	public List<TheaterseatDto> seatListAll() {
		return sqlSession.selectList(namepaces+".seatListAll");
	}

	
	
}
