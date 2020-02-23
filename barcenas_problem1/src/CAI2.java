import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
	private int answer;
	
	public void quiz() {
		Scanner sc;
		sc = new Scanner(System.in);
		askQuestion();
		int input, exit;
		exit = 1;
		while (exit == 1) {
			input = sc.nextInt();
			exit = readResponse(input);
		}
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
			return 0;
		} else {
			displayIncorrectResponse();
			return 1;
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
	
	public static void main(String[] args) {
		CAI2 t;
		t = new CAI2();
		t.quiz();
	}
}
