package project.Member;

public class MemberDto {
	private String id;// ǣ�����̵�
	private String name;// ȸ�� �̸�
	private String pwd;// ȸ�� ��й�ȣ
	private String phoneNumber;// ȸ���� ��ȭ��ȣ
	
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
