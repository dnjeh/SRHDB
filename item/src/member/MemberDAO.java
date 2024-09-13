package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private String url = "jdbc:mariadb://127.0.0.1:3306/java_pro";
	private String id = "root";
	private String pwd = "1234";
	
	public MemberDAO() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 찾기 오류!!!" + e.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("db 연결 오류!!!" + e.toString());
		}
	}
	
	private void dbClose() {
		// TODO Auto-generated method stub
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			//TODO Auto-generated catch block
			System.out.println("DB 종료 오류!!!" + e.toString());
		}
	}
	
	public ArrayList<MemberVO> selectMember( String id ) {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		String sql="";
		try {
			if(id==null||id.equals("")) { 
				sql = "select * from member";
				stmt = con.prepareStatement(sql);
			}
			else {
				sql = "select * from member where id=?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, id);
			}
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("select 오류!!!" + e.toString());
		}
		
		return list;
	}
}
