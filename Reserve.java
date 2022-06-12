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
		Label l1 = new Label("�����ϱ�");
		Label l3 = new Label("������");
		Label l4 = new Label("���� �ð�");
		Label l5 = new Label("���� �ο���");
		Label l6 = new Label("�䱸����");
		add(l1);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		MemberDao mdao = new MemberDao();
		TextField t1 = new TextField();
		TextField t3 = new TextField();
		Choice c1 = new Choice(); // �ο���
		Choice c2 = new Choice(); // ������
		Choice c3 = new Choice(); // ����ð�
		
		add(c1);
		add(c2);
		add(c3);
		add(t3);

		
		c1.add("06-16 (��)");
		c1.add("06-17 (��)");
		c1.add("06-18 (��)");
		c1.add("06-19 (��)");
		c1.add("06-20 (��)");
		c1.add("06-21 (ȭ)");
		c1.add("06-22 (��)");

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

		

		JButton j1 = new JButton("�����ϱ�");
		JButton j2 = new JButton("�ڷΰ���");
		add(j1);
		add(j2);

		Font font1 = new Font("���� ���", Font.BOLD, 35);
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
		setTitle("�Ĵ� �����ϱ�");
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

				
				JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.");
				SelectMenu selectMenu = new SelectMenu();
				dispose();
			}
		});

		j2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "������ �����Ǿ����ϴ�.");
				SelectMenu selectMenu = new SelectMenu();
				dispose();
			}
		});
	}
}