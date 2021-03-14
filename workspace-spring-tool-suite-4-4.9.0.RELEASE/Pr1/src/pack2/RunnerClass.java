package pack2;

import java.util.Scanner;

public class RunnerClass {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int accountNumber=10000;
		PersonDetails details;
		SavingsAccount account;
		CurrentAccount account2;
		while(true) {
			System.out.println("Enter your choice");
			System.out.println("1.Enter New Details");
			System.out.println("Enter name and age:");
			String name=sc.nextLine();
			int age=sc.nextInt();
			details=new PersonDetails(name, age);
			while(true) {
			System.out.println("Enter choice for Type of account");
			System.out.println("1.Savings account 2.Current account 3.exit");
			int choice=sc.nextInt();
			switch(choice){
				case(1):
					account= new SavingsAccount(accountNumber,10000,details,10000);
					accountNumber++;
					while(true) {
						System.out.println("Enter choice for Savings account");
						System.out.println("1.Deposit Money 2.Withdraw money 3.View Balence 4.exit");
						int savingsChoice=sc.nextInt();
						switch(savingsChoice) {
							case(1):
								account.depoitMoney();
								break;
							case(2):
								account.withDrawMoney();
								break;
							case(3):
								System.out.println(account.getBalance());
							break;
							case(4):
								break;
								
						}
					}
				case(2):
					account2=new CurrentAccount(accountNumber, 10000, details,10000);
					accountNumber++;
					while(true){
						System.out.println("Enter choice for Current account");
						System.out.println("1.Deposit Money 2.Withdraw money 3.View Balence");
						int currentChoice=sc.nextInt();
						switch(currentChoice) {
						case(1):
							account2.depoitMoney();
							break;
						case(2):
							account2.withDrawMoney();
							break;
						case(3):
							account2.getBalance();
							break;
						case(4):
							return;
						}
					}
				case(3):
					return;
			}
		}
	}

}
}
