package member;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SwingSearch extends JFrame{
	
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
		
		setTitle("회원 관리");
		setSize(800,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}



	public static void main(String[] args) {
		new SwingSearch();
	}
}






