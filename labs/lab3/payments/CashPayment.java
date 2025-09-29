package payments;

public class CashPayment extends Payment{
	public CashPayment(double amount){
		super(amount);
	}
	
	public void processPayment()
	{
	System.out.println("Processing cash payment of Rs."+amount);
	}
}