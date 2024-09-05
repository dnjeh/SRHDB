package item;
import java.sql.*;
import java.util.ArrayList;
public class ItemDAO {

	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	
	private String url = "jdbc:mariadb://127.0.0.1:3306/test24";
	private String id = "root";
	private String pwd = "1234";
// 생성자에서 db 연결하기
	public ItemDAO() {
		try {
// 1단계: JDBC드라이버 로드
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pwd);
// 2단계: DB와 연결
			
		} catch (ClassNotFoundException e) {
// 1단계 실패시 메세지
			e.printStackTrace();
			System.out.println("드라이버 찾기 실패!!!" + e.toString());
		} catch (SQLException e) {
// 	2단계 실패시 메세지
			e.printStackTrace();
			System.out.println("db 연결 실패!!!" + e.toString());
		}
	}
// 테이블 전체 검색하고 검색결과 출력
	public ArrayList<ItemVO> selectItem() {
		
	ArrayList<ItemVO> list = new ArrayList<ItemVO>();
		
// 실행시킬 sql문 저장
		String sql = "select * from item";
		try {
// 3단계: db로 보낼 명령어 처리할 객체 생성
			stmt = con.prepareStatement(sql);
// 4단계: sql문 실행시키고 결과 받기
			rs = stmt.executeQuery();
// 위에서 받은 결과 화면에 출력
			while(rs.next()) {
				list.add(new ItemVO(rs.getInt("no"), 
						            rs.getString("name"), 
						            rs.getString("company"), 
						            rs.getInt("amount")));
				//for(int i=1;i<=4;i++) {
					//System.out.print(rs.getString(i));
					//if(i+1<=4) System.out.print("-");
				//}
				//System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("select 오류!!!" + e.toString());
		}
// 5단계: db 접속 종료
		//dbClose();
		return list;
	}
	public boolean InsertItem(ItemVO vo) {
		boolean ret = false;
		
		String sql = "insert into item values(?, ?, ?, ?)";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, vo.getNo());
			stmt.setString(2, vo.getName());
			stmt.setString(3, vo.getCompany());
			stmt.setInt(4, vo.getAmount());
			ret = stmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			System.out.println("insert 오류!!!" + e.toString());
		} finally {
			//dbClose();
		}
		return ret;
	}
	
	public boolean DeleteItem(int ind) {
		boolean ret = false;
		String sql = "delete from item where no = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, ind);
			ret = stmt.executeUpdate()>0;
		} catch (SQLException e) {
			System.out.println("select 오류!!!" + e.toString());
		} finally {
			//dbClose();
		}
		return ret;
	}
// 데이터베이스 닫기
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
// db작업을 위해 만든 변수를 순서대로 종료 시키기(반드시 null체크)

		}catch (SQLException e) {
	System.out.println("종료 에러!!!" + e.toString());
		}
	}
}