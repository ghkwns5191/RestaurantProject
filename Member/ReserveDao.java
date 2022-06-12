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
	
	
	Connection conn = null; // �����ͺ��̽� �����ϴ� ��ü
	public PreparedStatement pstmt = null; //�������� ������ �����ϴ� Ŭ����
	ResultSet rs = null;
	
	public int insertReserve(String rdate, String rtime, String amount, String requirements) {
		// �����ͺ��̽��ȿ� ������ �����ϱ�(insert�� �����ϱ�)
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
