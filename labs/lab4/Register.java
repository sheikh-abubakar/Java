import javax.swing.*;

class InvalidAgeException extends Exception{
	public InvalidAgeException(String message){
		super(message);
	}
}

public class Register{
	public static void main(String[] args){
		try{
			String str_age = JOptionPane.showInputDialog("enter your age: ");
			int age = Integer.parseInt(str_age);
			if(age < 18){
				throw new InvalidAgeException("you must be at least 18 years old");
				
			}
			String str_fee = JOptionPane.showInputDialog("Enter your fee: ");
			int fee = Integer.parseInt(str_fee);
			if(fee == 0){
				throw new InvalidAgeException("enter correct fee");
			}
			String discount_str = JOptionPane.showInputDialog("enter discount: ");
			double discount = Double.parseDouble(discount_str);
			
			if(discount <= 0.10 && discount >= 0.90){
				throw new InvalidAgeException("enter discount b/w 10% and 90%");
			}
			
			double final_fee = fee / discount;
			JOptionPane.showMessageDialog(null, "Registration successfull: "+final_fee);
			
		}catch(InvalidAgeException e){
			JOptionPane.showMessageDialog(null, "Error "+e);
		}catch (ArithmeticException e){
			JOptionPane.showMessageDialog(null, "num by 0 not allowed");
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "plz enetr numeric valaues");
		}finally{
			JOptionPane.showMessageDialog(null, "Registration successfull");
		}
		
	}
}