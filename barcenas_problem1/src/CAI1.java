import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
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
		System.out.println("Very Good!");
	}
	
	//If user is wrong
	public void displayIncorrectResponse() {
		System.out.println("No. Please Try Again");
	}
	
	public static void main(String[] args) {
		CAI1 t;
		t = new CAI1();
		t.quiz();
	}
	
}