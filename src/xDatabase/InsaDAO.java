package xDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class InsaDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	InsaVO vo = null;
	
	public InsaDAO() {
		String url = "jdbc:mysql://localhost:3306/javaProject";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패" + e.getMessage());
		}
		
	}
	
	// Connection 종료
	public void connClose() {	//로컬이기 때문에 연결을 끊는거임.. 나중에 싱글톤으로 활용하면 연결 안 끊음
		try {
			conn.close();
		} catch (Exception e) {}
	}
	
	// PreparedStatement 종료
	public void pstmtClose() {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {}
	}
	
	// ResultSet 종료
	public void rsClose() {
		try {
			if(rs != null) rs.close();
		} catch (Exception e) {}
		pstmtClose();	//여기로 들어왔다면 pstmt는 오류 없이 넘어왔다는 얘기인데, 만약 rs에서 닫히는게 오류나도 pstmt는 닫히도록 하는게 여기에 적는다.
	}

	// 회원명 검색(회원 중복처리)
	public InsaVO getNameSearch(String name) {
		vo = new InsaVO();	//vo로 담아올 그릇 생성
		try {
			sql = "select * from insa where name =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setIpsail(rs.getString("ipsail"));
			}
			
		} catch (Exception e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vo;
	}

	// 회원 가입처리
	public int setInsaInput(InsaVO vo) {
		int res = 0;
		try {
			sql = "insert into insa values (default,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getIpsail());
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}

	public int setInsaUpdate(InsaVO vo) {
		int res = 0;
		try {
			sql = "update insa set age = ?, gender = ?, ipsail = ? where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getAge());
			pstmt.setString(2, vo.getGender());
			pstmt.setString(3, vo.getIpsail());
			pstmt.setString(4, vo.getName());
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}

	// 회원 삭제처리
	public int setInsaDelete(String name) {
		int res = 0;
		try {
			sql = "delete from insa where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	// 전체리스트 가져오기
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getInsaList() {
		Vector vData = new Vector<>();
		try {
//			sql = "select * from insa order by idx desc";
			sql = "select * from insa order by age desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();	// 무조건 Vector로 받아야 한다. 
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				
				vData.add(vo);
			}
			
		} catch (Exception e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vData;
	}

	// 조건별 정렬처리하기
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getNameAscList(String str, String flag) {
		Vector vData = new Vector<>();
		try {
			if(str.equals("name")) {
				if(flag.equals("a")) sql = "select * from insa order by name";
				else  sql = "select * from insa order by name desc";
			}
			else if(str.equals("ipsail")) {
				if(flag.equals("a")) sql = "select * from insa order by ipsail";
				else sql = "select * from insa order by ipsail desc";
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();	// 무조건 Vector로 받아야 한다. 
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				
				vData.add(vo);
			}
			
		} catch (Exception e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vData;
	}


//	// 남자라디오버튼 선택시 남자 데이터만 가져오기.
//	public Vector getGenderMale() {
//		Vector vData = new Vector<>();
//		try {
//			sql = "select * from insa where gender ='남자' order by name";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				Vector vo = new Vector<>();	// 무조건 Vector로 받아야 한다. 
//				vo.add(rs.getInt("idx"));
//				vo.add(rs.getString("name"));
//				vo.add(rs.getInt("age"));
//				vo.add(rs.getString("gender"));
//				vo.add(rs.getString("ipsail"));
//				
//				vData.add(vo);
//			}
//			
//		} catch (Exception e) {
//			System.out.println("SQL 오류 : " + e.getMessage());
//		} finally {
//			rsClose();
//		}
//		return vData;
//	}
//
//	// 여자라디오버튼 선택시 남자 데이터만 가져오기.
//	public Vector getGenderFemale() {
//		Vector vData = new Vector<>();
//		try {
//			sql = "select * from insa where gender ='여자' order by name";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				Vector vo = new Vector<>();	// 무조건 Vector로 받아야 한다. 
//				vo.add(rs.getInt("idx"));
//				vo.add(rs.getString("name"));
//				vo.add(rs.getInt("age"));
//				vo.add(rs.getString("gender"));
//				vo.add(rs.getString("ipsail"));
//				
//				vData.add(vo);
//			}
//			
//		} catch (Exception e) {
//			System.out.println("SQL 오류 : " + e.getMessage());
//		} finally {
//			rsClose();
//		}
//		return vData;
//	}
	// 남자 또는 여자 라디오버튼을 클릭하면 해당 자료만 검색처리하기
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector getGender(String gender) {
		Vector vData = new Vector<>();
		try {
			sql = "select * from insa where gender = ? order by name";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gender);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();	// 무조건 Vector로 받아야 한다. 
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail").substring(0,10));
				
				vData.add(vo);
			}
			
		} catch (Exception e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

	/*
	// 성명 조건 검색(포함된 글자는 모두다 보이도록 처리)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getConditionNameSearch(String txtCondi) {
		Vector vData = new Vector<>();
		try {
			sql = "select * from insa where name like ? order by name";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + txtCondi + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();	// 무조건 Vector로 받아야 한다. 
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail").substring(0,10));
				
				vData.add(vo);
			}
			
		} catch (Exception e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	*/
	
	
	// 다양한 조건을 선택후 검색 문자열을 입력하고, '조건검색' 버튼을 누를경우 수행처리...
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector getConditionSearch(String fieldName, String txtCondi) {
		Vector vData = new Vector<>();
		try {
			sql = "select * from insa where "+ fieldName +" like ? order by name";	// ?는 무조건 값이 들어오는데 '문자'로 들어옴
			pstmt = conn.prepareStatement(sql);
			
			if(fieldName.equals("age")) pstmt.setInt(1, Integer.parseInt(txtCondi));	// 나이(숫자)는 완전 일치하는 것을 구할 것이기 때문에 이렇게 작성 한다.
			else pstmt.setString(1, "%" + txtCondi + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();	// 무조건 Vector로 받아야 한다. 
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail").substring(0,10));
				
				vData.add(vo);
			}
			
		} catch (Exception e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
}
