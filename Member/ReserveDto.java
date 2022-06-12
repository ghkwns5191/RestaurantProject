package project.Member;

public class ReserveDto extends MemberDto {
	int num;
	String id;
	String date;
	String time;
	String amount;
	String requirements;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}
	
	@Override
	public String getPhoneNumber() {
		// TODO Auto-generated method stub
		return super.getPhoneNumber();
	}
	
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}
	
	@Override
	public void setPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		super.setPhoneNumber(phoneNumber);
	}
	
	

}
