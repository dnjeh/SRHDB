package item;

import java.util.ArrayList;

public class ItemMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemDAO dao = new ItemDAO();
		ArrayList<ItemVO> list = dao.selectItem();
		for(ItemVO vo : list) {
			System.out.println(vo.toString());
		}
		
		System.out.println(dao.InsertItem(new ItemVO(4, "국재윤", "HJ코퍼레이션", 3000))?"데이터 추가 성공!!!":"데이터 추가 실패!!!");
		System.out.println(dao.DeleteItem(4)?"데이터 삭제 성공!!!":"데이터 삭제 실패!!!");
		dao.dbClose();
	}

}
