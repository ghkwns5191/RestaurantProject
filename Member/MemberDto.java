package project.Member;

public class MemberDto {
	private String id;// 푀원아이디
	private String name;// 회원 이름
	private String pwd;// 회원 비밀번호
	private String phoneNumber;// 회원의 전화번호
	
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public MemberDto(String id, String name, String pwd, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.phoneNumber = phoneNumber;
	}
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

}
