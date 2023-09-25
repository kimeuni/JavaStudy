package t8_sungjuk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SungjukDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	SungjukVO vo = null;
	
	public SungjukDAO() {
		try {
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String passward = "1234";
			// 1. 드라이버 검색
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2. 데이터베이스 검색(연결/연동)
			conn = DriverManager.getConnection(url, user, passward);
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 검색 오류" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패" + e.getMessage());
		}
	}
	
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	// pstmt 객체 close
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (Exception e) {}
	}
	
	// rs 객체 close
	public void rsClose() {
		try {
			if(rs != null) rs.close();
			pstmt.close();
		} catch (Exception e) {}
	}

	// 성적자료 등록처리
	public int setInput(SungjukVO vo) {	//메소드를 int로 만든 이유는 res를 통해 실행횟수를 알기위해서이다. (res가 0이면 수행되지않아 오류가 있는 것)
		int res = 0;
		try {
			sql = "insert into sungjuk values (default,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			res = pstmt.executeUpdate();	//수행되면 res 값이 늘어난다.
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return res;
	}

	// 전체 조회 처리
	public ArrayList<SungjukVO> getList() {
		ArrayList<SungjukVO> vos = new ArrayList<SungjukVO>();
		
		try {
			sql = "select * from sungjuk order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new SungjukVO();	//여기서 생성해야 돌때마다 vo를 새로 만들어서 값을 넣는다.
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vos.add(vo);	// 생성된 vo를 vos에 담는다.
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}

	// 개별 조회 처리
	public SungjukVO getSearch(String name) {
		SungjukVO vo = new SungjukVO();
		try {
			sql = "select * from sungjuk where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {	//rs에 값이 들어가 있으면 보여줄 값을 값을 저장
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
			}
			else vo = null;
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
}
