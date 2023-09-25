package t10_sale;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO extends parentDAO {
//	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	ProductVO vo = null;
	
//	public ProductDAO() {
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

	//상품명 검색(중복처리)
	public ProductVO getNameSearch(String pName) {
		vo = new ProductVO();
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

	// 상품 등록 처리
	public int setProductInput(ProductVO vo) {
		int res = 0;
		try {
			sql = "insert into product values (default,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getpName());
			pstmt.setInt(2, vo.getPrice());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 :" + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	// 전체 상품 조회
	public ArrayList<ProductVO> getProductList() {
		ArrayList<ProductVO> vos = new ArrayList<ProductVO>();
		try {
			sql = "select * from product order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new ProductVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pName"));
				vo.setPrice(rs.getInt("price"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 :" + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}

	// 상품 삭제 처리
	public int setProductDelet(int idx) {
		int res = 0;
		try {
			sql = "delete from product where idx =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 :" + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

}
