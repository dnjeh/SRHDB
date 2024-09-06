package member;

public class MemberVO {
	private String id;
	private String name;
	private String pwd;
	private String address;
	private String joinday;
	public MemberVO(String id) {
		super();
		this.id = id;
	}
	public MemberVO(String id, String name, String pwd, String address, String joinday) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.address = address;
		this.joinday = joinday;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJoinday() {
		return joinday;
	}
	public void setJoinday(String joinday) {
		this.joinday = joinday;
	}
	@Override
	public String toString() {
		return "MemberVO [아이디=" + id + ", 이름=" + name + ", 비밀번호=" + pwd + ", 주소=" + address + ", 가입일="
				+ joinday + "]";
	}
	
	
}
