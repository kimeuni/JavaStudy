package t2_hoiwon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HoiwonDAO3 {
	Connection conn = null;
	
	public HoiwonDAO3() {
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
			
			System.out.println("\t\t** 주 소 록 **");
			System.out.println("=".repeat(42));
			System.out.println("번호\t성명\t나이\t주소\t성별");
			System.out.println("-".repeat(42));
			while(rs.next()) {	// rs.next 내려서.. 내용이 true이면 값 출력 => 값이 있으면 돌아가라
				System.out.print( rs.getInt("idx") + "\t");
				System.out.print( rs.getString("name") + "\t");
				System.out.print( rs.getInt("age") + "\t");
				System.out.print( rs.getString("address") + "\t");
				System.out.print( rs.getString("gender"));
				System.out.println();
			}
			System.out.println("=".repeat(42));
			
		} catch (SQLException e) {
			System.out.println("SQL 오류" + e.getMessage());
		}	
		
	}
}
