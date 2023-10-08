package atmInterface;
import java.util.Scanner;

class AtmAccount{
	private double currentBalance;
	
	public AtmAccount(double initialBalance) {
		this.currentBalance=initialBalance;
	}



public double checkBalance() {
	return currentBalance;
}

public void transferMoney(double amount) {
	currentBalance += amount;
}

public boolean withdrawMoney(double amount) {
	
	if(amount>currentBalance) {
		System.out.println("You do not have sufficient balance in your account to withdraw "+ amount +" from you account.");
		return false;
	}
	else if(amount == currentBalance) {
		System.out.println("You have withdrawn  all the available balance in your account.");
		currentBalance =0;
		 return true;
	}
	else {
		currentBalance -= amount;
		return true;
	}
}
}
			
public class atmMachine {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	AtmAccount accHolder = new AtmAccount(5000);
	while (true) {
		System.out.println("The following are the transaction options available:\n1. Check available balance in your account\n2. Deposit money into your bank account\n3. Withdraw money from you bank account\n4. Exit the process.");
		System.out.print("Please enter your choice based on available options:");
		int choice = sc.nextInt();
		if(choice == 1) {
			System.out.println("Your available balance is :$"+accHolder.checkBalance());
		}else if( choice ==2) {
			System.out.println("Enter the amount you want to deposit in your bank account: $");
			accHolder.transferMoney(sc.nextDouble());
			System.out.println("Amount deposit successful\nYour updated balance is: $"+ accHolder.checkBalance());
		}
			
			
			
			
		else if(choice == 3) {
			System.out.println("Enter the amount you want to withdraw from your bank account: $");
			if(accHolder.withdrawMoney(sc.nextDouble())) {
				System.out.println("Amount withdrawal successful\nYour updated balance is: $"+ accHolder.checkBalance());
			}
			
			
			
		}else if(choice == 4) {
			System.out.println("You are exiting the process.\nThankyou! Do visit again.");
			sc.close();
			break;
			
			
		}else {
			System.out.println("Your entered choice is invalid.Please enter valid choice" );
		}
	}
}
}


		
		
	
	


