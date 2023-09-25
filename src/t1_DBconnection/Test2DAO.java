package t1_DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test2DAO {
	Connection conn = null;	
	
	public Test2DAO() {
		try {
			// 1. 드라이버 검색
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 검색 성공!");
			// 2. 인터넷을 통해서 연결 
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패~~~" + e.getMessage());
			
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패~~" + e.getMessage());
		}
	}
	
	// conn(connection) 객체 close	// 데이터베이스는 무조건 <예외처리>를 해야 한다.
	public void connClose() {
		try {
			conn.close();
			System.out.println("conn객체가 닫혔습니다.");
		} catch (SQLException e) {}
	}
}
