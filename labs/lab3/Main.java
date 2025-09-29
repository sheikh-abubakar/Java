import payments.*;

public class Main{
	public static void main (String[] args){
		CreditCardPayment ccp = new CreditCardPayment(5000.0);
		ccp.processPayment();
		ccp.refund(1000.0);
		
		CashPayment cp = new CashPayment(2000.0);
		cp.processPayment();		
	}
}