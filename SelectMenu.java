package project;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import project.Member.MemberDao;

public class SelectMenu extends JFrame{
	ArrayList arraylist = null;
	public SelectMenu() {
		// TODO Auto-generated constructor stub
	
	JPanel p = new JPanel();
	Label l1 = new Label("원하는 메뉴를 선택해주세요");
	add(l1);
	
	JButton j1 = new JButton("예약하기");
	JButton j2 = new JButton("예약확인");
	JButton j3 = new JButton("로그아웃");
	add(j1);
	add(j2);
	add(j3);
	
	l1.setBounds(60, 10, 300, 30);
	
	j1.setBounds(85, 60, 110, 40); // 예약하기
	j2.setBounds(85, 120, 110, 40); // 예약확인
	j3.setBounds(85, 180, 110, 40); // 로그아웃
	add(p);
	setSize(300,300);
	setTitle("환영합니다");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    
    j1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Reserve res = new Reserve();
			dispose();
		}
	});
    
    j2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ReserveCheckM rescheck = new ReserveCheckM();
			dispose();
		}
	});
    
    j3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Login login = new Login();
			MemberDao dao = new MemberDao();
			dao.logOut();
			JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
			dispose();
			
		}
	});
	
	
	}
}

