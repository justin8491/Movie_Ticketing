package com.box.small.database;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class DBConnection {
	public static void main(String[] args) throws Exception {
		// 데이터 정보가 계속 바뀔 때 마다 이거를 계속 고치고 컴파일하고 반복이됨
		String DB_URL = "jdbc:mysql://localhost:3306/movie?useSSL=false&useUnicode=true&characterEncoding=utf8";
		//		"jdbc:mysql://localhost/movie"
//	        String DB_USER = "root";
//	        String DB_PASSWORD = "12345";
//	        String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
		//
		// setter처리를 프로퍼티태그로 처리 -> 빈태그로 바꿈 -> root-context.xml에 넣을꺼임
//	        DriverManagerDataSource ds = new DriverManagerDataSource();
//	        ds.setDriverClassName(DB_DRIVER);
//	        ds.setUrl(DB_URL);
//	        ds.setUsername(DB_USER);
//	        ds.setPassword(DB_PASSWORD);

		ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context.xml");
		DataSource ds = ac.getBean(DataSource.class);

		Connection conn = ds.getConnection(); // 데이터베이스의 연결을 얻는다.

		System.out.println("conn = " + conn);
//	        assertTrue(conn!=null);
	}
}
