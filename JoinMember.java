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
		// 회원가입하는 화면 구현
		JPanel p = new JPanel();
		setLocationRelativeTo(p);
		Label l1 = new Label("아이디");
		Label l2 = new Label("비밀번호");
		Label l3 = new Label("비밀번호 확인");
		Label l4 = new Label("이름");
		Label l5 = new Label("전화번호");
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

		JButton j1 = new JButton("저장");
		JButton j2 = new JButton("취소");
		JButton j3 = new JButton("ID 중복체크");
		JButton j4 = new JButton("비밀번호확인");
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
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		j1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 저장버튼
				// t1~t4까지 모두 가져와서 dao메소드로 전달
				String id = t1.getText();
				String pwd = t2.getText();
				String name = t4.getText();
				String phoneNumber = t5.getText();

				MemberDao dao = new MemberDao();
				int result = dao.insertMember(id, pwd, name, phoneNumber);
				// 회원가입했습니다 메세지창 띄우기
				if (result != 0) {
					JOptionPane.showMessageDialog(null, "회원가입되었습니다");
				} else {
					JOptionPane.showMessageDialog(null, "회원실패했습니다");
				}
				// 로그인 화면으로 돌아가기
				Login login = new Login();
				// 현재화면닫기
				dispose();
			}
		});

		j2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 취소버튼 코드 -> 로그인으로 돌아가기
				Login login = new Login();
				dispose();

			}
		});

		j3.addActionListener(new ActionListener() {
			MemberDao dao = new MemberDao();

			@Override
			public void actionPerformed(ActionEvent e) {
				// id중복 체크 버튼
				// 데이터베이스안에 해당하는 아이디가 있는지 체크하는코드
				// 데이터베이스 연결, 쿼리문실행 리턴받아서 있는지 없는지 판단해서 있다 없다
				String id = t1.getText();
				if (dao.checkId(id) == true) {
					JOptionPane.showMessageDialog(null, "사용중인 아이디입니다.");
					t1.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
				}
			}
		});

		j4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String pwd = t2.getText();
				String pwdCheck = t3.getText();
				if (pwd.equals(pwdCheck)) {
					JOptionPane.showMessageDialog(null, "비밀번호가 동일합니다");
				} else {
					JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다 다시확인해주세요");
					t3.setText("");
				}

			}
		});

	}
}
