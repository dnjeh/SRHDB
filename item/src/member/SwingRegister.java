package member;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.Date;

public class SwingRegister extends JFrame{
	
	private String strName[] = {"id", "이름", "비밀번호", "주소", "가입일자"};
	private JLabel label[] = new JLabel[5];
	private JTextField textF[] = new JTextField[5]; 
		
	private JButton btnSave = new JButton("저장");
	private JButton btnCancel = new JButton("취소");
	
	private  boolean reg = true;
	
	
	// 생성자 만들기

	public SwingRegister() {
		initScreen();
		
		LocalDate date = LocalDate.now();
		textF[4].setText(date.toString());
		textF[4].setEnabled(false);
		setTitle("회원 등록");
		setVisible(true);
	}
	
	public SwingRegister(MemberVO vo) {
		initScreen();
		setTitle("회원 수정");
		setVisible(true);
		
	}
	
	

	
	void initScreen(){
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		p1.setLayout(new GridLayout(0,2));
				
		for(int i=0; i<label.length; i++) {
			label[i] = new JLabel( strName[i] );
			label[i].setHorizontalAlignment(JLabel.CENTER);
			if(i==2)	textF[i] = new JPasswordField(20);
			else		textF[i] = new JTextField(20);
			p1.add(label[i]);
			p1.add(textF[i]);
			
			
		}
				
		// 오늘날짜를 가입일자에 넣고, 수정 못하게 하기
		

		p2.add(btnSave);
		p2.add(btnCancel);
		
		
		
		
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
		setSize(350, 250);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}


}
