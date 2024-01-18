package entity;

public class Customer {
	private String name;
	private int age;
	private String gender;
	private long phno;
	private TktDetails tktDetails;
	
	public Customer(String name, int age, String gender, long phno,TktDetails tktDetails ) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phno = phno;
		this.tktDetails=tktDetails;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", gender=" + gender + ", phno=" + phno + "]";
	}
	
	
	
		
}
