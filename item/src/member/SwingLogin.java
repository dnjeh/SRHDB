package member;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

public class SwingLogin extends JFrame implements ActionListener, KeyListener{
	
	private JTextField tfId;
	private JPasswordField tfPwd;
	private JButton btnLogin, btnReg;
	
	
	SwingLogin(){
		
		JPanel p = new JPanel();
		add(p);
		
		JLabel lb_id = new JLabel("아 이 디");
		lb_id.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel lb_pwd = new JLabel("패스워드");
		lb_pwd.setHorizontalAlignment(JLabel.CENTER);
		
		tfId = new JTextField();
		tfPwd = new JPasswordField();
		
		btnLogin = new JButton("로그인");
		btnReg = new JButton("회원가입");
		
		p.setLayout(new GridLayout(0,2));
		p.add(lb_id);
		p.add(tfId);
		p.add(lb_pwd);
		p.add(tfPwd);
		p.add(btnLogin);
		p.add(btnReg);

		btnLogin.addActionListener(this);
		btnReg.addActionListener(this);
		tfId.addKeyListener(this);
		tfPwd.addKeyListener(this);
		
		setTitle("로그인 화면");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(300,150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingLogin();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnLogin) {
			proLogin();
		}
		else if(e.getSource() == btnReg) {
			new SwingRegister();
		}
	}

	private void proLogin() {
		String id = tfId.getText().trim();
		String pwd = (new String(tfPwd.getPassword())).trim();
		
		if(id.equals("")||pwd.equals("")) {
			JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 비었습니다.");
			return;
		}
		
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list =  dao.selectMember(id);
		if(list.size() == 0) {
			JOptionPane.showMessageDialog(this, id + "은(는) 없는 아이디입니다.");
		}
		else {
			if(pwd.equals(list.get(0).getPwd())) {
				JOptionPane.showMessageDialog(this, id + "님 반갑습니다!");
				new SwingSearch();
			}
			else {
				JOptionPane.showMessageDialog(this, id + "은(는) 잘못된 아이디입니다.");
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(e.getSource() == tfId) {
				tfPwd.requestFocus();
			}
			else if(e.getSource() == tfPwd)
				btnLogin.doClick();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}








