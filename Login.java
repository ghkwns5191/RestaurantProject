package project;

import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.JoinMember;

import javax.swing.*;

import project.ManagerPage;
import project.SelectMenu;
import project.Member.MemberDao;

public class Login extends JFrame {
	public String id;

	public Login() {
		JPanel p = new JPanel();
		setLocationRelativeTo(p);
		Label l1 = new Label("������� ������� ���α׷�", SwingConstants.CENTER);
		Label l2 = new Label("���̵�");
		Label l3 = new Label("��й�ȣ");
		add(l1);
		add(l2);
		add(l3);

		TextField t1 = new TextField();
		TextField t2 = new TextField();
		add(t1);
		add(t2);
		t2.setEchoChar('*'); // ��й�ȣ �Է��ϸ� ȭ�鿡�� *�� �������ϱ�

		JButton j1 = new JButton("�α���");
		JButton j2 = new JButton("ȸ������");
		add(j1);
		add(j2);

		Font font1 = new Font("���� ���", Font.BOLD, 30);
		l1.setFont(font1);

		l1.setBounds(50, 10, 10000, 100);
		l2.setBounds(130, 180, 40, 30);
		l3.setBounds(130, 210, 40, 30);

		t1.setBounds(180, 180, 120, 25);
		t2.setBounds(180, 210, 120, 25);

		j1.setBounds(130, 330, 100, 30);
		j2.setBounds(250, 330, 100, 30);

		add(p);
		setSize(500, 500);
		setTitle("�α���ȭ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		j1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				String pwd = t2.getText();

				MemberDao dao = new MemberDao();
				int result = dao.login(id, pwd); // �����ͺ��̽��ȿ� id�� ��й�ȣ�� ������ �˻��ؼ� �ִ��� �Ǵ��ϱ�
				// result������ �α��� �߽��ϴ� �ƴϸ� �߸��� ���̵�� ��й�ȣ�Դϴ�
				if (result == 1) {
					if (id.equals("manager")) {
						JOptionPane.showMessageDialog(null, "�����ڷ� �α��� �߽��ϴ�");
						ManagerPage managerPage = new ManagerPage();
						dispose(); // ����ȭ��ݱ�
					} else {
						JOptionPane.showMessageDialog(null, "�α����߽��ϴ�");
						dao.insertLog(id);
						SelectMenu selectMenu = new SelectMenu();
						dispose();
					}
				} else if (result == 0) {
					JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� Ʋ�Ƚ��ϴ�");
				}
				
			}
		});

		j2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ȸ�������ϴ� ȭ������ �ٲپ��ش�. JoinMemberŬ����
				JoinMember joinMember = new JoinMember();
				dispose();

			}
		});

	}

}
