package t99_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String sql = "";
	
	
	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 찾기 실패");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패");
		}
	}
	
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	public void gerList() {
		try {
			stmt = conn.createStatement();
			sql = "select * from hoiwon";
			rs = stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			System.out.println("SQL오류 : " + e.getMessage());
		}
		
	}
	
	
}
