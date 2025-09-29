package payments;

public class CreditCardPayment extends Payment implements Refundable{
	public CreditCardPayment(double amount){
		super(amount);
	}
	
	
	public void processPayment(){
		System.out.println("Processing credit card payment of Rs."+amount);
	}
	
	
	public void refund(double refundAmount){
		System.out.println("Refunding Rs."+refundAmount+"to credit card");
	}
}