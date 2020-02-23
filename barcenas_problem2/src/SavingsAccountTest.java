
public class SavingsAccountTest {

	public static void main(String[] args) {
		SavingsAccount saver1, saver2;
		saver1 = new SavingsAccount(2000);
		saver2 = new SavingsAccount(3000);
		SavingsAccount.modifyInterestRate((float) 0.04);
		int i;
		System.out.printf("Month\tSavings Account 1\tSavings Account 2\n");
		for (i=0; i<12; i++) {
			System.out.printf("%d\t%.2f\t\t\t%.2f\n", i+1, saver1.calculateMonthlyInterest(), saver2.calculateMonthlyInterest());
		}
		
		SavingsAccount.modifyInterestRate((float) 0.05);
		System.out.println("\nAfter Change to 5% Rate");
		System.out.println("Savings Account 1\tSavings Account 2");
		System.out.printf("%.2f\t\t\t%.2f\n", saver1.calculateMonthlyInterest(), saver2.calculateMonthlyInterest());
	}

}
