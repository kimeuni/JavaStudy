package t4_hoiwon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HoiwonDAO {
	// 이렇게 5개 기본적으로 전역변수로 빼서 사용한다.
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String sql = "";
	HoiwonVO vo = null;
	
	public HoiwonDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 없습니다." + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동 실패" + e.getMessage());
		}
	}
	
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	// 전체 회원 조회
	public ArrayList<HoiwonVO> getList() {	//ArrayList<> 타입으로 메소드를 만들었다.
		ArrayList<HoiwonVO> vos = new ArrayList<>();	//ArrayList생성
		try {
			stmt = conn.createStatement();
			sql = "select * from hoiwon order by idx desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {	
				vo = new HoiwonVO();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddress(rs.getString("address"));
				vo.setGendser(rs.getString("gender"));
				
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		}
		return vos;	//vos에 넘긴다.
	}

	// 개별 회원 조회
	public HoiwonVO getSearch(String name) {
		HoiwonVO vo = new HoiwonVO();
		try {
			stmt = conn.createStatement();
			sql = "select * from hoiwon where name = '" + name + "'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddress(rs.getString("address"));
				vo.setGendser(rs.getString("gender"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		}
		
		
		return vo;
	}

	// 회원 자료 삭제하기
	public void setDelete(String name) {
		try {
			stmt = conn.createStatement();
			sql = "delete from hoiwon where name = '" + name + "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		}
	}
}
