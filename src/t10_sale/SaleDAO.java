package t10_sale;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaleDAO extends parentDAO{
//	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	ProductVO pVO = null;
	saleVO sVO = null;
	
//	public SaleDAO() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			String url = "jdbc:mysql://localhost:3306/javaProject";
//			String user = "atom";
//			String passward = "1234";
//			conn = DriverManager.getConnection(url, user, passward);
//			
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 찾기 실패" + e.getMessage());
//		} catch (SQLException e) {
//			System.out.println("데이터베이스 연결 실패 " + e.getMessage());
//		}
//	}
	
	public void connClose() {
		try {
			conn.close();
		} catch (Exception e) {}
	}
	
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (Exception e) {}
	}
	
	public void rsClose() {
		try {
			if(rs != null) rs.close();
			pstmt.close();
		} catch (Exception e) {}
	}

	// 판매상품 등록처리
	public int setSaleInput(saleVO sVO) {
		int res = 0;
		try {
			sql = "insert into sale values (default,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sVO.getpName());
			pstmt.setInt(2, sVO.getEa());
			pstmt.setString(3, sVO.getpDate());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 :" + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}

	// 등록된 기존 상품 검색
	public ProductVO getNameSearch(String pName) {
		ProductVO vo = new ProductVO();
		
		try {
			sql = "select * from product where pName =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pName"));
				vo.setPrice(rs.getInt("price"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 :" + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 판매 상품 조회
	public ArrayList<saleVO> getSaleNameSearch(String pName) {
		ArrayList<saleVO> vos = new ArrayList<saleVO>();
		ResultSet rs2 = null;
		
		try {
			sql = "select * from sale where pName =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pName);
			rs2 = pstmt.executeQuery();
			
			while(rs2.next()) {
				sVO = new saleVO();
				sVO.setIdx(rs2.getInt("idx"));
				sVO.setpName(rs2.getString("pName"));
				sVO.setEa(rs2.getInt("ea"));
				sVO.setpDate(rs2.getString("pDate"));	
				//rs를 사용하면 sVO.setSalePrice(getNameSearch(pName).getPrice());에서 같은 rs를 사용하여 충돌하기 때문에 변수명을 rs2로 바꿔준다.
				
//				int salePrice = getNameSearch(pName).getPrice();	//getNameSearch(pName)에 있는 vo를 읽어온다.  .getPrice() price만 읽어온다.
//				sVO.setSalePrice(salePrice);
				sVO.setSalePrice(getNameSearch(pName).getPrice());
				
				vos.add(sVO);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 :" + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vos;
	}

	// 판매일자별 검색
	public ArrayList<saleVO> getSaleDateSearch(String pDate) {
		ArrayList<saleVO> vos = new ArrayList<saleVO>();
		ResultSet rs2 = null;
		
		try {
			sql = "select * from sale where pDate =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pDate);
			rs2 = pstmt.executeQuery();
			
			while(rs2.next()) {
				sVO = new saleVO();
				sVO.setIdx(rs2.getInt("idx"));
				sVO.setpName(rs2.getString("pName"));
				sVO.setEa(rs2.getInt("ea"));
				sVO.setpDate(rs2.getString("pDate"));	
				//rs를 사용하면 sVO.setSalePrice(getNameSearch(pName).getPrice());에서 같은 rs를 사용하여 충돌하기 때문에 변수명을 rs2로 바꿔준다.
				sVO.setSalePrice(getNameSearch(sVO.getpName()).getPrice());
				
				vos.add(sVO);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 :" + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vos;
	}

	//전체 판매 상품 조회
	public ArrayList<saleVO> getSaleList() {
		ArrayList<saleVO> vos = new ArrayList<saleVO>();
		ResultSet rs2 = null;
		
		try {
			sql = "select * from sale";
			pstmt = conn.prepareStatement(sql);
			rs2 = pstmt.executeQuery();
			
			while(rs2.next()) {
				sVO = new saleVO();
				sVO.setIdx(rs2.getInt("idx"));
				sVO.setpName(rs2.getString("pName"));
				sVO.setEa(rs2.getInt("ea"));
				sVO.setpDate(rs2.getString("pDate"));	
				//rs를 사용하면 sVO.setSalePrice(getNameSearch(pName).getPrice());에서 같은 rs를 사용하여 충돌하기 때문에 변수명을 rs2로 바꿔준다.
				sVO.setSalePrice(getNameSearch(sVO.getpName()).getPrice());
				
				vos.add(sVO);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 :" + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vos;
	}

}
