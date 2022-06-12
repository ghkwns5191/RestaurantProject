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
		Label l1 = new Label("레스토랑 예약관리 프로그램", SwingConstants.CENTER);
		Label l2 = new Label("아이디");
		Label l3 = new Label("비밀번호");
		add(l1);
		add(l2);
		add(l3);

		TextField t1 = new TextField();
		TextField t2 = new TextField();
		add(t1);
		add(t2);
		t2.setEchoChar('*'); // 비밀번호 입력하면 화면에는 *이 나오게하기

		JButton j1 = new JButton("로그인");
		JButton j2 = new JButton("회원가입");
		add(j1);
		add(j2);

		Font font1 = new Font("맑은 고딕", Font.BOLD, 30);
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
		setTitle("로그인화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		j1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				String pwd = t2.getText();

				MemberDao dao = new MemberDao();
				int result = dao.login(id, pwd); // 데이터베이스안에 id와 비밀번호를 보내서 검색해서 있는지 판단하기
				// result있으면 로그인 했습니다 아니면 잘못된 아이디와 비밀번호입니다
				if (result == 1) {
					if (id.equals("manager")) {
						JOptionPane.showMessageDialog(null, "관리자로 로그인 했습니다");
						ManagerPage managerPage = new ManagerPage();
						dispose(); // 이전화면닫기
					} else {
						JOptionPane.showMessageDialog(null, "로그인했습니다");
						dao.insertLog(id);
						SelectMenu selectMenu = new SelectMenu();
						dispose();
					}
				} else if (result == 0) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 틀렸습니다");
				}
				
			}
		});

		j2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 회원가입하는 화면으로 바꾸어준다. JoinMember클래스
				JoinMember joinMember = new JoinMember();
				dispose();

			}
		});

	}

}
