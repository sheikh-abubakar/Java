import java.io.*;
import java.util.*;


public class BankApp{
	private static final String accounts_file = "accouts.txt";
	private static final String Sp = "\\s*;\\s*";
	private static final String Sp_out = ";";
	
	
	public static class Bank{
		private String name;
		private String acc_number;
		private double amount;
		
		public Bank(String n, String acc, double a){
			this.name = n;
			this.acc_number = acc;
			this.amount = a;
		}
		
		public String getName(){return name;}
		public void setName(String name){
			this.name = name;
		}
		
		public String getAcc_Num(){return acc_number;}
		public void setName(String acc){
			this.acc_number = acc;
		}
		
		public double getAmount(){return amount;}
		public void setAmount(double amount){
			this.amount = amount;
		}
		
		public String fileName(){
			return name + Sp_out + acc_number + Sp_out + amount;
		}
		
		public static Bank fileLine(String line) throws IllegalArgumentException{
			String[] parts = line.split(Sp);
			if(parts.length < 3) throw new IllegalArgumentException("wrong accounts line: " + line);
			String name = parts[0].trim();
			String acc_num = parts[1].trim();
			
			double amount;
			try{
				amount = Double.parseDouble(parts[2].trim());
			}catch(NumberFormatException e){
				throw new IllegalArgumentException("Invalid amount: "+amount);
			}
			return new Bank(name, acc, amount);
		}
	}
	
	public static class noAccountAvailbaleException extends Exception{
		public noAccountAvailbaleException(String msg){
			super(msg);
		}
	}
	
	public static void addNewRecord(Bank newAcc){
		File file = new File(accounts_file);
		if(!file.exists()){
			file.createNewFile();
		}
		
		if(Double.compare(newAcc.getAmount(), 0.0)==0){
			newAcc.setAmount(1000.0);
		}
		try (BufferedWriter bf = new BufferedWriter(new FileWriter(accounts_file, true))){
			bf.writer(newAcc.fileLine());
			bf.newLine();
		}
	}
	 public static void transfer(String sender_acc, String recepient_acc, double amount){
		if(amount <= 0) throw new IllegalArgumentException("amount not correct");
		
	 }
	 
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		boolean quit = false;
		
		while(!quit){
			System.out.println();
            System.out.println("1. Add New Account");
            System.out.println("2. Transfer");
            System.out.println("3. Show All Accounts (debug)");
            System.out.println("4. Exit");
			System.out.println("choose ana option: [1-4]");
			String choice = in.nextline().trim();
			switch(choice){
				case '1':
				System.out.print("enter account holder name: ");
				String name = in.nextline().trim();
				System.out.print("enter 8 digit account  number: ");
				String account_number = in.nextline().trim();
				Bank mybank = new Bank(namae, account_number, 1000);
			}
		}
	}
}