package com.doordie.designpatterns.structural;

/**
 * 
 * FACADE pattern provides a unified interface to a set of interfaces
 * in a subsystem. Facade defines a higher-level interface that makes 
 * the subsystem easier to use.
 * 
 * Below is an example Banking transaction system. Facade pattern applied
 * here to make client not to worry about underlying subsystem verifications.
 * BankAccountFacade exposes higher-level interface by performing subsystem
 * interface interactions itself (there by keeping client simple).
 *
 */

public class Facade {

	//Account checking subsystem
	class AccountCheck {
		private long accountNumber = 123456;
		
		public long getAccountNumber() { return this.accountNumber; }
		
		public boolean accountActive(long accountNumberToCheck) {
			if (this.getAccountNumber() == accountNumberToCheck)
				return true;
			else
				return false;
		}
	}
	
	//Security verification subsystem
	class SecurityCheck {
		private int securityPin = 1234;
		
		public int getSecurityPin() { return this.securityPin; }
		
		public boolean isValidPin(int secCodeToCheck) {
			if (this.getSecurityPin() == secCodeToCheck)
				return true;
			else
				return false;
		}
	}
	
	//Subsystem to verify funds
	class FundCheck {
		private double cashInAccount = 1000.00;
		
		public double getCashInAccount() { return this.cashInAccount; }
		
		public void increaseCash(double cashDeposited) {
			this.cashInAccount += cashDeposited;
		}
		
		public void decreaseCach(double cashWithDrawn) {
			this.cashInAccount -= cashWithDrawn;
		}
		
		public boolean haveEnoughFund(double cashToWithdraw) {
			if (getCashInAccount() < cashToWithdraw) {
				System.out.println("Error! Not enough funds available");
				System.out.println("Current Balance: " + getCashInAccount());
				return false;
			}
			else {
				decreaseCach(cashToWithdraw);
				System.out.println("Withdraw Complete. Current Balance: " + getCashInAccount());
				return true;
			}
		}
		
		public void depositeFund(double cashToDeposite) {
			increaseCash(cashToDeposite);
			System.out.println("Deposite Complete. Current Balance: " + getCashInAccount());
		}
	}
	
	//Facade class
	public class BankAccountFacade {
		
		private long accountNumber;
		private int secPin;
		
		private AccountCheck accountChecker;
		private SecurityCheck securityChecker;
		private FundCheck fundChecker;
		
		public BankAccountFacade(long accNum, int secPin) {
			accountChecker = new AccountCheck();
			securityChecker = new SecurityCheck();
			fundChecker = new FundCheck();
			
			this.accountNumber = accNum;
			this.secPin = secPin;
			
		}
		
		public long getAccountNumber() { return this.accountNumber; }
		public int getSecurityPin() {return this.secPin; }
		
		public void withdrawCash(double cashToDraw) {
			if (accountChecker.accountActive(getAccountNumber())
					&& securityChecker.isValidPin(getSecurityPin())
					&& fundChecker.haveEnoughFund(cashToDraw)) {
				System.out.println("Transaction Complete\n");
			}
			else {
				System.out.println("Transaction Failed\n");
			}
			
		}
		
		public void depositeCash(double cashToDeposite) {
			if (accountChecker.accountActive(getAccountNumber())
					&& securityChecker.isValidPin(getSecurityPin())) {
				fundChecker.depositeFund(cashToDeposite);
				System.out.println("Transaction Complete\n");
			} else {
				System.out.println("Transaction Failed\n");
			}
		}
	}

	//Facade tester
	public static void main(String[] args) {
		BankAccountFacade bankAccount = new Facade().new BankAccountFacade(123456, 1234);

		bankAccount.withdrawCash(50.00);
		bankAccount.withdrawCash(900.00);
		bankAccount.depositeCash(200.00);
	}

}
