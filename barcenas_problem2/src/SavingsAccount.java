
public class SavingsAccount {
	private static float annualInterestRate;
	private float savingsBalance;
	
	public SavingsAccount(float initial) {
		this.savingsBalance = initial;
	}
	
	public float calculateMonthlyInterest() {
		this.savingsBalance = this.savingsBalance + (this.savingsBalance * annualInterestRate / 12);
		return this.savingsBalance;
	}
	
	public static void modifyInterestRate(float rate) {
		annualInterestRate = rate;
	}
}
