package com.box.small.user.reservation;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public class ReservationDAOImpl implements ReservationDAO{

	@Autowired
	private SqlSession sqlSession;
	String namepaces = "com.box.small.reservationMapper";
	
	@Override
	public ReservationDto intsertReservation(@RequestParam Map<Object, Object> params) {
		return sqlSession.selectOne(namepaces+".insertReservation", params);
		
	}

	@Override
	public List<ReservationDto> reservationList(String mem_id) {
		return sqlSession.selectList(namepaces+".reservationList", mem_id);
	}

	@Override
	public void cancelReservation(Map<String, Object> params) {
		sqlSession.selectOne(namepaces+".cancelReservation", params);
	}

	@Override
	public ReservationDto selectReservation(Map<String, Object> params) {
		return sqlSession.selectOne(namepaces+".selectReservation", params);
	}

	
	
}
