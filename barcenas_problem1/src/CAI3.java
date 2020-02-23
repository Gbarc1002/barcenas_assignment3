import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {
	private int answer;
	
	public void quiz() {
		Scanner sc;
		sc = new Scanner(System.in);
		int input, rightAns, i, again;
		rightAns = 0;
		for (i=0; i<10; i++) {
			askQuestion();
			input = sc.nextInt();
			rightAns = rightAns + readResponse(input);
		}
		displayCompletionMessage(rightAns);	
		System.out.println("Would you like to do another set?");
		System.out.println("1) Yes");
		System.out.println("2) No");
		again = sc.nextInt();
		while (again < 1 || again > 2) {
			System.out.println("Please Input A Valid Input");
			again = sc.nextInt();
		}
		if (again == 1)
			quiz();
		sc.close();
	}
	
	//Assigns variable answer with product of 2 random variables between 1 and 10
	public void askQuestion() {
		SecureRandom rand;
		rand = new SecureRandom();
		int x, y;
		x = rand.nextInt(10);
		y = rand.nextInt(10);
		System.out.printf("How much is %d times %d?%n", x, y);
		this.answer = x * y;
	}
	
	//Determines which response to display
	public int readResponse(int input) {
		if (isAnswerCorrect(input) == 0) {
			displayCorrectResponse();
			return 1;
		} else {
			displayIncorrectResponse();
			return 0;
		}
	}
	
	public int isAnswerCorrect(int input) {
		if (input == this.answer) {
			return 0;
		} else {
			return 1;
		}
	}
	
	//If user is right
	public void displayCorrectResponse() {
		SecureRandom rand;
		rand = new SecureRandom();
		int selection;
		selection = rand.nextInt(4) + 1;
		switch(selection) {
		case 1:
			System.out.println("Very Good!");
			break;
		case 2:
			System.out.println("Excellent!");
			break;
		case 3:
			System.out.println("Nice Work!");
			break;
		case 4:
			System.out.println("Keep Up The Good Work!");
			break;
		}
	}
	
	//If user is wrong
	public void displayIncorrectResponse() {
		SecureRandom rand;
		rand = new SecureRandom();
		int selection;
		selection = rand.nextInt(4) + 1;
		switch(selection) {
		case 1:
			System.out.println("No. Please Try Again");
			break;
		case 2:
			System.out.println("Wrong. Try Once More");
			break;
		case 3:
			System.out.println("Don't Give Up!");
			break;
		case 4:
			System.out.println("No. Keep Trying!");
			break;
		}
	}
	
	//If score is 75%, user gets a good message, otherwise user will get a bad message
	public void displayCompletionMessage(int numCorrect) {
		double score;
		score = (double)numCorrect / 10.0;
		System.out.println("Your score is: " + score * 100 + "%");
		if (score >= 0.75) {
			System.out.println("Congratulations, you are ready to go to the next level!");
		} else {
			System.out.println("Please ask your teacher for extra help.");
		}
	}
	
	public static void main(String[] args) {
		CAI3 t;
		t = new CAI3();
		t.quiz();
	}
}
