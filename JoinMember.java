package project;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import project.Login;
import project.Member.MemberDao;

public class JoinMember extends JFrame {
	public JoinMember() {
		// ȸ�������ϴ� ȭ�� ����
		JPanel p = new JPanel();
		setLocationRelativeTo(p);
		Label l1 = new Label("���̵�");
		Label l2 = new Label("��й�ȣ");
		Label l3 = new Label("��й�ȣ Ȯ��");
		Label l4 = new Label("�̸�");
		Label l5 = new Label("��ȭ��ȣ");
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);

		TextField t1 = new TextField();
		TextField t2 = new TextField();
		TextField t3 = new TextField();
		TextField t4 = new TextField();
		TextField t5 = new TextField();
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		t2.setEchoChar('*');
		t3.setEchoChar('*');

		JButton j1 = new JButton("����");
		JButton j2 = new JButton("���");
		JButton j3 = new JButton("ID �ߺ�üũ");
		JButton j4 = new JButton("��й�ȣȮ��");
		add(j1);
		add(j2);
		add(j3);
		add(j4);

		l1.setBounds(30, 20, 40, 40);
		l2.setBounds(30, 60, 60, 40);
		l3.setBounds(30, 100, 100, 40);
		l4.setBounds(30, 140, 60, 40);
		l5.setBounds(30, 180, 60, 40);

		t1.setBounds(130, 20, 150, 30);
		t2.setBounds(130, 60, 150, 30);
		t3.setBounds(130, 100, 150, 30);
		t4.setBounds(130, 140, 150, 30);
		t5.setBounds(130, 180, 150, 30);

		j1.setBounds(140, 330, 100, 40);
		j2.setBounds(250, 330, 100, 40);
		j3.setBounds(300, 20, 110, 30);
		j4.setBounds(300, 100, 110, 30);

		add(p);
		setSize(500, 500);
		setTitle("ȸ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		j1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// �����ư
				// t1~t4���� ��� �����ͼ� dao�޼ҵ�� ����
				String id = t1.getText();
				String pwd = t2.getText();
				String name = t4.getText();
				String phoneNumber = t5.getText();

				MemberDao dao = new MemberDao();
				int result = dao.insertMember(id, pwd, name, phoneNumber);
				// ȸ�������߽��ϴ� �޼���â ����
				if (result != 0) {
					JOptionPane.showMessageDialog(null, "ȸ�����ԵǾ����ϴ�");
				} else {
					JOptionPane.showMessageDialog(null, "ȸ�������߽��ϴ�");
				}
				// �α��� ȭ������ ���ư���
				Login login = new Login();
				// ����ȭ��ݱ�
				dispose();
			}
		});

		j2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ҹ�ư �ڵ� -> �α������� ���ư���
				Login login = new Login();
				dispose();

			}
		});

		j3.addActionListener(new ActionListener() {
			MemberDao dao = new MemberDao();

			@Override
			public void actionPerformed(ActionEvent e) {
				// id�ߺ� üũ ��ư
				// �����ͺ��̽��ȿ� �ش��ϴ� ���̵� �ִ��� üũ�ϴ��ڵ�
				// �����ͺ��̽� ����, ���������� ���Ϲ޾Ƽ� �ִ��� ������ �Ǵ��ؼ� �ִ� ����
				String id = t1.getText();
				if (dao.checkId(id) == true) {
					JOptionPane.showMessageDialog(null, "������� ���̵��Դϴ�.");
					t1.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "��밡���� ���̵��Դϴ�.");
				}
			}
		});

		j4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String pwd = t2.getText();
				String pwdCheck = t3.getText();
				if (pwd.equals(pwdCheck)) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �����մϴ�");
				} else {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �ٸ��ϴ� �ٽ�Ȯ�����ּ���");
					t3.setText("");
				}

			}
		});

	}
}
