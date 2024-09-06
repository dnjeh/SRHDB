package member;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

public class SwingLogin extends JFrame{
	
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

		
		
		setTitle("로그인 화면");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(300,150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingLogin();
	}


}








