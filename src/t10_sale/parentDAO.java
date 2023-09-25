package t10_sale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class parentDAO {
	Connection conn = null;
	public parentDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String passward = "1234";
			conn = DriverManager.getConnection(url, user, passward);
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 찾기 실패" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패 " + e.getMessage());
		}
	}
}
