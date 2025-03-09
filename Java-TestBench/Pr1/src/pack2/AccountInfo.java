package pack2;

public class AccountInfo {
	private long accountNumber;
	private double balance;
	private PersonDetails person;
	private double amount;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public PersonDetails getPerson() {
		return person;
	}
	public void setPerson(PersonDetails person) {
		this.person = person;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void depoitMoney() {
		System.out.println(getBalance());
	}
	public void withDrawMoney() {
		System.out.println(getBalance());
	}
	public AccountInfo(long accountNumber, double balance, PersonDetails person, double amount) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.person = person;
		this.amount = amount;
	}
	
}

class SavingsAccount extends AccountInfo{
	public SavingsAccount(long accountNumber, double balance, PersonDetails person, double amount) {
		super(accountNumber, balance, person, amount);
		// TODO Auto-generated constructor stub
	}
	private final int MINIMUMBALANCE = 500;
	
	@Override
	public void depoitMoney() {
		// TODO Auto-generated method stub
		super.setBalance(super.getBalance()+super.getAmount());
	}
	
	@Override
	public void withDrawMoney() {
		// TODO Auto-generated method stub
		if(super.getBalance()<MINIMUMBALANCE) {
			System.out.println("------ ** Insufficient balance towithdraw ** ------");
		}
		else {
			super.setBalance(super.getBalance()-super.getAmount());
			System.out.println("------ ** Amount Withdrawed ** ------");
		}
	}
	
}
class CurrentAccount extends AccountInfo{
	
	public CurrentAccount(long accountNumber, double balance, PersonDetails person, double amount) {
		super(accountNumber, balance, person, amount);
		// TODO Auto-generated constructor stub
	}
	private  double OVERDRAFTLIMIT = 10000;
	public void withDrawMoney() {
		if( super.getAmount()<OVERDRAFTLIMIT) {
			super.setBalance(OVERDRAFTLIMIT-super.getAmount());
			OVERDRAFTLIMIT = OVERDRAFTLIMIT - super.getAmount();
		}
		else {
			System.out.println("------ ** Over Draft Limit Reached ** ------");
		}
	}
}

