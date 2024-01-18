package add_book;

public class PhoneBook {
	
	private int num;
	private String name;
	private String hp;
	private String company;
	
	public PhoneBook(String name, String hp, String company) {
		super();
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public String toString() {
		return "PhoneBook [name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}
	
	public void showInfo() {
		System.out.println(num + ".\t" + name + "\t" + hp + "\t" + company);
	}
	
	
	
}
