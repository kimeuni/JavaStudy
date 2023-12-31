package t2_hoiwon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HoiwonDAO2 {
	Connection conn = null;
	
	public HoiwonDAO2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패~" + e.getMessage()); 
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패~" + e.getMessage());
		}
	}
	
	// conn객체 close
	public void connClose() {
		try {
			conn.close();
		} catch (Exception e) {}
	}
	
	// 전체 회원 조회하기
	public void getList() {
		try {
			Statement stmt = conn.createStatement();	// Statement = SQL명령어 사용할 수 있도록 하는 명령어 (SQL 실어나르는 객체)
			String sql = "select * from hoiwon";
			ResultSet rs = stmt.executeQuery(sql);	//레코드셋(리절트셋) ResultSet은 레코드를 처리하는 객체.(반환 받을게 있을 때만 사용 / updata와 같은 건 사용 안함)
			
			while(rs.next()) {	// rs.next 내려서.. 내용이 true이면 값 출력 => 값이 있으면 돌아가라
				System.out.println("번호 : " + rs.getInt("idx"));
				System.out.println("성명 : " + rs.getString("name"));
				System.out.println("나이 : " + rs.getInt("age"));
				System.out.println("주소 : " + rs.getString("address"));
				System.out.println("성별 : " + rs.getString("gender"));
				System.out.println();
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 오류" + e.getMessage());
		}	
		
	}
}
