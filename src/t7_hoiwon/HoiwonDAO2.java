package t7_hoiwon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//PreparedStatement 활용

public class HoiwonDAO2 {
	// 이렇게 5개 기본적으로 전역변수로 빼서 사용한다.
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	HoiwonVO vo = null;
	
	public HoiwonDAO2() {
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
	
	// pstmt객체 close
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();	// 값이 들어가 있으면 stmt를 닫는다.
		} catch (SQLException e) {}
	}
	
	// rs객체 close
	public void rsClose() {
		try {
			if(rs != null) rs.close();	// 값이 들어가 있으면 stmt와 rs를 닫는다.
			pstmtClose(); //rs객체를 닫을 때는 stmt도 같이 생성되어 있기 때문에 stmt를 닫는 것을 같이 만들어준다.
		} catch (Exception e) {}
	}
	
	// 전체 회원 조회
	public ArrayList<HoiwonVO> getList() {	//ArrayList<> 타입으로 메소드를 만들었다.
		ArrayList<HoiwonVO> vos = new ArrayList<>();	//ArrayList생성
		try {
			sql = "select * from hoiwon order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
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
		} finally {
			rsClose();
		}
		return vos;	//vos에 넘긴다.
	}

	// 개별 회원 조회
	public HoiwonVO getSearch(String name) {
		HoiwonVO vo = new HoiwonVO();
		try {
			sql = "select * from hoiwon where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);	// ?의 값이 뭔지 모르기 때문에 pstmt.executeQuery()을 하기 전에 값을 채워 넣는다. // 첫번째 ?에 넘어온 name을 넣어줄거야.. 라는 의미
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddress(rs.getString("address"));
				vo.setGendser(rs.getString("gender"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		
		
		return vo;
	}

	// 회원 자료 삭제하기
	public void setDelete(String name) {
		try {
			sql = "delete from hoiwon where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		} finally {	
			pstmtClose();
		}
	}
	
	// 회원 가입 처리(sql문 : insert)
	public int setHoiwonInput(HoiwonVO vo) {
		int res = 0;
		try {
			sql = "insert into hoiwon values (default,?,?,?,?)";	//여기서 타입 신경 안쓰고 밑에 값을 넣어줄때 (ex)pstmt.setString(1, vo.getGendser());) 타입을 넣어준다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getGendser());
			res = pstmt.executeUpdate();	
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		} finally {	
			pstmtClose();
		}
		return res;
		
	}

	// 자료 수정 (sql문 : updata)
	public int setHoiwonUpdata(String name, int age, String address, String strGender) {
		int res = 0;
		try {
			sql = "update hoiwon set age = ?, address = ?, gender = ? where name = ?";	// 변수 넣었던 부분을 다 ?로 바꾼다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, age);
			pstmt.setString(2, address);
			pstmt.setString(3, strGender);
			pstmt.setString(4, name);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		} finally {	
			pstmtClose();
		}
		
		return res;
	}
}
