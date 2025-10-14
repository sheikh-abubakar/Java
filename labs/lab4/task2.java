import javax.swing.*;

class InsufficientBalanceException extends Exception{
	public InsufficientBalanceException(String Message){
		super(Message);
	}
}

class BankAccount{
	private double balance;
	public BankAccount(double balance){
		this.balance = balance;
	}
	public void withdraw(double amount){
		throw InsufficientBalanceException{
			if(amount <= 0){
				throw new InsufficientBalanceException("amount should be > 0");
			}
			if(amount > balance){
				throw new InsufficientBalanceException("amount should be within balance"+balance);
				
			}
			balance -= amount;
			System.out.println("withdraw successful: "+ amount);
		}
		
	}
	
	public double get_balance(){
		return balance;
	}
}