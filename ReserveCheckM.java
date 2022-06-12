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
		Label l1 = new Label("����Ȯ��");
		add(l1);
		

		JButton j1 = new JButton("�ڷΰ���");
		add(j1);
		

		Font font1 = new Font("���� ���", Font.BOLD, 35);
		l1.setFont(font1);
		l1.setBounds(210, 10, 600, 100);
		j1.setBounds(240, 480, 100, 30);
	

		add(p);
		setSize(600, 800);
		setTitle("�Ĵ� �����ϱ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		String header [] = {"�л�", "�̸�"};
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

		Connection conn  = null; // �����ͺ��̽� �����ϴ� ��ü
		PreparedStatement pstmt = null; //�������� ������ �����ϴ� ��ü
		ResultSet rs = null; //����� ��ȯ �޴� ��ü
		
		 try {
				Class.forName(driver); //1-1
				conn = DriverManager.getConnection(url, userid, password); //1-2
				String query = "select r.num, m.id, m.name, m.phoneNumber, r.rdate, r.rtime, r.amount, r.requirements from runningtbl r inner join membertbl m on m.id = r.id where m.id = (select id from logtbl)";
				pstmt = conn.prepareStatement(query); 
				rs = pstmt.executeQuery();
				//����� �������� ������ ��� ó���ؾ� �ǳ�?
				// ���� �о ����Ʈ ������ ��
				// ���߿� ����� �� ����Ʈ�� �ִ� ���� ������ ����ϱ�
				
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
				//���� ������� �ݵ�� ����Ǵ� �κ�
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
		col.add("�����ȣ");
		col.add("���̵�");
		col.add("�̸�");
		col.add("��ȭ��ȣ");
		col.add("������");
		col.add("����ð�");
		col.add("�ο���");
		col.add("��û����");
		
		
		
		return col;
	}
}