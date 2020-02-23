import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {
	private int answer;
	private int difficulty;
	
	public void quiz() {
		Scanner sc;
		sc = new Scanner(System.in);
		int input, rightAns, i, again;
		rightAns = 0;
		readDifficulty();
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
		int x, y;
		x = generateQuestionArgument();
		y = generateQuestionArgument();
		System.out.printf("How much is %d times %d?%n", x, y);
		this.answer = x * y;
	}
	
	//Gets an input from user to tell what difficulty the questions should be
	public void readDifficulty() {
		Scanner scan;
		scan = new Scanner(System.in);
		System.out.println("What difficulty level do you wish to use? (Level 1 - 4)");
		int difficulty;
		difficulty = scan.nextInt();
		while (difficulty < 1 || difficulty > 4) {
			System.out.println("Please enter a valid input");
			difficulty = scan.nextInt();
		}
		
		this.difficulty = difficulty;
	}
	
	//If difficulty is level 1, variables will be 0-9
	//If difficulty is level 2, variables will be 0-99
	//If difficulty is level 3, variables will be 0-999
	//If difficulty is level 4, variables will be 0-9999
	public int generateQuestionArgument() {
		SecureRandom ran;
		ran = new SecureRandom();
		int i, ten = 10;
		for (i=1; i<this.difficulty; i++) {
			ten = ten * 10;
		}
		
		return ran.nextInt(ten);
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
		CAI4 t;
		t = new CAI4();
		t.quiz();
	}
}
