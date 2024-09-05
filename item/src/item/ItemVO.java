package item;

public class ItemVO {
	private int no;
	private String name;
	private String company;
	private int amount;
	public ItemVO(int no) {
		super();
		this.no = no;
	}
	public ItemVO(int no, String name, String company, int amount) {
		super();
		this.no = no;
		this.name = name;
		this.company = company;
		this.amount = amount;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "ItemVO [번호=" + no + ", 이름=" + name + ", 회사=" + company + ", 가격=" + amount + "]";
	}
	
	
}
