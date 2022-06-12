package project;

import java.awt.Choice;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import project.Member.MemberDao;
import project.Member.ReserveDao;

public class Reserve extends JFrame {
	String memberId;
	String memberName;
	String peopleNum;
	String reserveTime;

	public Reserve() {
		JPanel p = new JPanel();
		ReserveDao rdao = new ReserveDao();
		Label l1 = new Label("예약하기");
		Label l3 = new Label("예약일");
		Label l4 = new Label("예약 시간");
		Label l5 = new Label("예약 인원수");
		Label l6 = new Label("요구사항");
		add(l1);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		MemberDao mdao = new MemberDao();
		TextField t1 = new TextField();
		TextField t3 = new TextField();
		Choice c1 = new Choice(); // 인원수
		Choice c2 = new Choice(); // 예약일
		Choice c3 = new Choice(); // 예약시간
		
		add(c1);
		add(c2);
		add(c3);
		add(t3);

		
		c1.add("06-16 (목)");
		c1.add("06-17 (금)");
		c1.add("06-18 (토)");
		c1.add("06-19 (일)");
		c1.add("06-20 (월)");
		c1.add("06-21 (화)");
		c1.add("06-22 (수)");

		c2.add("10:00");
		c2.add("11:00");
		c2.add("12:00");
		c2.add("13:00");
		c2.add("14:00");
		c2.add("15:00");
		c2.add("16:00");
		c2.add("17:00");
		c2.add("18:00");
		c2.add("19:00");
		c2.add("20:00");

		c3.add("2");
		c3.add("3");
		c3.add("4");
		c3.add("5");
		c3.add("6");
		c3.add("7");
		c3.add("8");
		c3.add("9");
		c3.add("10");

		

		JButton j1 = new JButton("예약하기");
		JButton j2 = new JButton("뒤로가기");
		add(j1);
		add(j2);

		Font font1 = new Font("맑은 고딕", Font.BOLD, 35);
		l1.setFont(font1);

		l1.setBounds(210, 10, 600, 100);
		l3.setBounds(120, 180, 90, 40);
		l4.setBounds(120, 230, 90, 40);
		l5.setBounds(120, 280, 90, 40);
		l6.setBounds(120, 330, 90, 40);
		
		c1.setBounds(250, 190, 150, 30);
		c2.setBounds(250, 240, 150, 30);
		c3.setBounds(250, 290, 150, 30);
		t3.setBounds(250, 340, 150, 30);

		j1.setBounds(180, 480, 100, 30);
		j2.setBounds(300, 480, 100, 30);

		add(p);
		setSize(600, 900);
		setTitle("식당 예약하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		j1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String rdate = c1.getSelectedItem();
				String rtime = c2.getSelectedItem();
				String amount = c3.getSelectedItem();
				String requirements = t3.getText();
				
				
				ReserveDao rdao = new ReserveDao();
				int result = rdao.insertReserve(rdate,rtime, amount, requirements);

				
				JOptionPane.showMessageDialog(null, "예약이 완료되었습니다.");
				SelectMenu selectMenu = new SelectMenu();
				dispose();
			}
		});

		j2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "예약이 중지되었습니다.");
				SelectMenu selectMenu = new SelectMenu();
				dispose();
			}
		});
	}
}