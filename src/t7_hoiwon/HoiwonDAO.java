package t7_hoiwon;

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
	
	// stmt객체 close
	public void stmtClose() {
		try {
			if(stmt != null) stmt.close();	// 값이 들어가 있으면 stmt를 닫는다.
		} catch (SQLException e) {}
	}
	
	// rs객체 close
	public void rsClose() {
		try {
			if(rs != null) rs.close();	// 값이 들어가 있으면 stmt와 rs를 닫는다.
			stmtClose(); //rs객체를 닫을 때는 stmt도 같이 생성되어 있기 때문에 stmt를 닫는 것을 같이 만들어준다.
		} catch (Exception e) {}
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
		} finally {
			rsClose();
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
		} finally {
			rsClose();
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
		} finally {	//자료가 사용이 됐을 때 stmt가 닫혀야 한다.... 안그러면 메모리에서 손실이 있다고함...
			stmtClose();
		}
	}
	
	// 회원 가입 처리(sql문 : insert)
	// 회원 가입 처리
//	public void setHoiwonInput(String name, int age, String address, int gender) {
	public int setHoiwonInput(HoiwonVO vo) {
		int res = 0;
		try {
			sql = "insert into hoiwon values (default,'"+ vo.getName() +"',"+vo.getAge()+",'"+vo.getAddress()+"','"+vo.getGendser()+"')";
			stmt = conn.createStatement();
			res = stmt.executeUpdate(sql);	//res는 수행횟수 (1번 수행하면 1이 들어가고, 여러번 수행하면 그 이상의 숫자가 들어간다. 만약 수행하지 않을 시 0이 들어가기 때문에 Run에서 비교를 할때 0으로 수행했는지 안했는지 확인하는게 좋다.)
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		} finally {	//자료가 사용이 됐을 때 stmt가 닫혀야 한다.... 안그러면 메모리에서 손실이 있다고함...
			stmtClose();
		}
		return res;
		
	}

	// 자료 수정 (sql문 : updata)
	public int setHoiwonUpdata(String name, int age, String address, String strGender) {
		int res = 0;
		try {
			sql = "update hoiwon set age = "+age+", address = '"+address+"', gender = '"+strGender+"' where name = '"+name+"'";
			stmt = conn.createStatement();
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL 문장 오류 : " + e.getMessage());
		} finally {	//자료가 사용이 됐을 때 stmt가 닫혀야 한다.... 안그러면 메모리에서 손실이 있다고함...
			stmtClose();
		}
		
		return res;
	}
}
