package project.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/project";
	String userid = "root";
	String password="";
	
	
	Connection conn = null; // �����ͺ��̽� �����ϴ� ��ü
	PreparedStatement pstmt = null; //�������� ������ �����ϴ� Ŭ����
	ResultSet rs = null;

	public int login(String id, String pwd) {
		//�α���
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password); 
			String query = "select id, pwd, name from membertbl where id=? and pwd=?"; //2-1
			pstmt = conn.prepareStatement(query); //2-2
			pstmt.setString(1, id);
			pstmt.setString(2, pwd); 
			rs = pstmt.executeQuery(); // select�� ����
			
			if(rs.next()) {
				return 1;
					
			}
			return 0;
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
		
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		return 0;
		
	}

	public boolean checkId(String id) {
		//���̵� �ߺ� üũ
		boolean result = false;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String query = "select id from membertbl where id=?";
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}else {
				result = false;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int insertMember(String id, String pwd, String name, String phoneNumber) {
		
		// �����ͺ��̽��ȿ� ������ �����ϱ�(insert�� �����ϱ�)
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String query="insert into membertbl (id, pwd, name, phoneNumber) values (?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, phoneNumber);
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
	
	public int insertLog(String id) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String query="insert into logtbl (id) values (?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			int result=pstmt.executeUpdate();
			return result;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public int logOut(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);
			String query="truncate logtbl";
			pstmt = conn.prepareStatement(query);
			int result=pstmt.executeUpdate();
			return result;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

}
