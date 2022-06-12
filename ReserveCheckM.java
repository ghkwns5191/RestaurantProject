package project;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import project.Member.ReserveDao;
import project.Member.ReserveDto;


public class ReserveCheckM extends JFrame {
	public static ArrayList arrayList =null;
	
	

	public ReserveCheckM() {
		JPanel p = new JPanel();
		ReserveDao rdao = new ReserveDao();
		Label l1 = new Label("예약확인");
		add(l1);
		

		JButton j1 = new JButton("뒤로가기");
		add(j1);
		

		Font font1 = new Font("맑은 고딕", Font.BOLD, 35);
		l1.setFont(font1);
		l1.setBounds(210, 10, 600, 100);
		j1.setBounds(240, 480, 100, 30);
	

		add(p);
		setSize(600, 800);
		setTitle("식당 예약하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		String header [] = {"학생", "이름"};
		String contents [][] = {
				
		};
			
				
		
		arrayList = ReserveCheckM.ResOutput();
        Iterator it1 = arrayList.iterator();
        while(it1.hasNext()) {
      	  ReserveDto dto = (ReserveDto) it1.next();
      	  System.out.println(dto.getNum() + " " + dto.getId() + " " + dto.getName() + " " + dto.getPhoneNumber() + " " + dto.getDate() + " " + dto.getTime() + " " + dto.getAmount() + " " + dto.getRequirements());
      	  
      	Vector v = null;
		Vector cols = null;
		DefaultTableModel model;
		JTable table;
		JScrollPane scroll;
		
		model = new DefaultTableModel(v,cols);
		table = new JTable(model);
		scroll = new JScrollPane(table);
		add(scroll);
		
		
		j1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SelectMenu selm = new SelectMenu();
				dispose();
				
			}
		});}
	}
	
	
	
	
	public static ArrayList<ReserveDto> ResOutput() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/project";
		String userid = "root";
		String password = "";

		Connection conn  = null; // 데이터베이스 연결하는 객체
		PreparedStatement pstmt = null; //쿼리문을 보내고 실행하는 객체
		ResultSet rs = null; //결과를 반환 받는 객체
		
		 try {
				Class.forName(driver); //1-1
				conn = DriverManager.getConnection(url, userid, password); //1-2
				String query = "select r.num, m.id, m.name, m.phoneNumber, r.rdate, r.rtime, r.amount, r.requirements from runningtbl r inner join membertbl m on m.id = r.id where m.id = (select id from logtbl)";
				pstmt = conn.prepareStatement(query); 
				rs = pstmt.executeQuery();
				//결과가 여러줄이 나오면 어떻게 처리해야 되나?
				// 한줄 읽어서 리스트 저장해 둠
				// 나중에 사용할 때 리스트에 있는 것을 꺼내서 사용하기
				
				arrayList = new ArrayList<Book>();
				
				while(rs.next()) {
					ReserveDto rdto = new ReserveDto();
					rdto.setNum(rs.getInt("num"));
					rdto.setId(rs.getString("id"));
					rdto.setName(rs.getString("name"));
					rdto.setPhoneNumber(rs.getString("phoneNumber"));
					rdto.setDate(rs.getString("rdate"));
					rdto.setTime(rs.getString("rtime"));
					rdto.setAmount(rs.getString("amount"));
					rdto.setRequirements(rs.getString("requirements"));
					arrayList.add(rdto);
					
				
				
						
				}} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				//예외 상관없이 반드시 수행되는 부분
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			return arrayList;
			
			
	}
	
	public Vector getColumn() {
		Vector col = new Vector();
		col.add("예약번호");
		col.add("아이디");
		col.add("이름");
		col.add("전화번호");
		col.add("예약일");
		col.add("예약시간");
		col.add("인원수");
		col.add("요청사항");
		
		
		
		return col;
	}
}