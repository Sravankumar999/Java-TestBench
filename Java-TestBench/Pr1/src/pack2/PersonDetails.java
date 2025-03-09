package pack2;

public class PersonDetails {
	private String AccountHolderName;
	private int age;
	public String getAccountHolderName() {
		return AccountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		AccountHolderName = accountHolderName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public PersonDetails(String accountHolderName, int age) {
		AccountHolderName = accountHolderName;
		this.age = age;
	}
	
	
}
