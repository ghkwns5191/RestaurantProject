package project.Member;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReserveDao {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/project";
	String userid = "root";
	String password="";
	
	
	Connection conn = null; // 데이터베이스 연결하는 객체
	public PreparedStatement pstmt = null; //쿼리문을 보내고 실행하는 클래스
	ResultSet rs = null;
	
	public int insertReserve(String rdate, String rtime, String amount, String requirements) {
		// 데이터베이스안에 데이터 삽입하기(insert문 실행하기)
		MemberDao dao = new MemberDao();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String query="insert into runningtbl (id, rdate, rtime, amount, requirements) values ((select id from logtbl), ?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rdate);
			pstmt.setString(2, rtime);
			pstmt.setString(3, amount);
			pstmt.setString(4, requirements);
			int result=pstmt.executeUpdate();
			return result;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				//rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	

}
