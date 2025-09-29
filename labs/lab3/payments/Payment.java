package payments;

public abstract class Payment{
	protected double amount;
	
	public Payment(double amount){
	this.amount = amount;
	}
	
	abstract void processPayment();
}