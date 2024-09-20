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

public class SwingRegister extends JFrame implements ActionListener{
	
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
		reg=false;
		initScreen();
		textF[0].setText(vo.getId());
		textF[1].setText(vo.getName());
		textF[2].setText(vo.getPwd());
		textF[3].setText(vo.getAddress());
		textF[4].setText(vo.getJoinday());
		textF[0].setEnabled(false);
		textF[4].setEnabled(false);
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
		
		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);
		
		setSize(350, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnSave && reg) {
			String data[] = new String[5];
			for(int i=0;i<data.length;i++) {
				data[i]=textF[i].getText().trim();
			}
			if(data[0].equals("")||data[2].equals("")||data[2].equals("")) {
				JOptionPane.showMessageDialog(this, "아이디, 이름, 비밀번호는 필수 입니다.");
				return;
			}
			MemberDAO dao = new MemberDAO();
			if(dao.insertMember(new MemberVO(data[0], data[1], data[2], data[3], data[4]))) {
				JOptionPane.showMessageDialog(this, data[1] + "님 회원가입 축하합니다!");
			}
			else {
				JOptionPane.showMessageDialog(this, data[1] + "님 회원가입에 실패했습니다!");
			}
			this.dispose();
		}
		else if(e.getSource() == btnSave) {
			
		}
		else if(e.getSource() == btnCancel) {
			this.dispose();
		}
	}


}

