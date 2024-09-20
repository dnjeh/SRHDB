package member;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SwingSearch extends JFrame implements ActionListener{
	
	private JTextField tfId = new JTextField(10);
	private JButton btnSearch = new JButton("검색");
	private JButton btnUpdate = new JButton("수정");
	private JButton btnDelete = new JButton("삭제");
	private JTextArea ta = new JTextArea();
	private JScrollPane sp = new JScrollPane();
		
	SwingSearch(){
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		JLabel lbId = new JLabel("아 이 디");
		
		p1.add(lbId); p1.add(tfId); 
		p1.add(btnSearch); p1.add(btnUpdate); p1.add(btnDelete);
		
		p2.setLayout(new BorderLayout());
		p2.add(ta);
		
		
		sp = new JScrollPane(ta);
	 
		p2.add(sp);
		
		
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		
		btnSearch.addActionListener(this);
		btnDelete.addActionListener(this);
		btnUpdate.addActionListener(this);
		
		setTitle("회원 관리");
		setSize(800,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}



	public static void main(String[] args) {
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String id = tfId.getText().trim();
		MemberDAO dao = new MemberDAO();
		
		if(e.getSource() == btnSearch) {
			ta.setText("");
			ArrayList<MemberVO> list = dao.selectMember(id);
			for(MemberVO vo: list) {
				ta.append(vo.toString()+"\n");
			}
		}
		else if(e.getSource() == btnUpdate) {
			if(id.equals("")) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요!!");
				return;
			}
			ArrayList<MemberVO> list = dao.selectMember(id);
			if(list.size() == 0) {
				JOptionPane.showMessageDialog(this, id + "는 없는 아이디입니다.");
				return;
			}
			MemberVO vo = list.get(0);
			
			new SwingRegister(vo);
		}
		else if(e.getSource() == btnDelete) {
			
		}
		dao.dbClose();
	}
}






