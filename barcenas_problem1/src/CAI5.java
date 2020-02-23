import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {
	private int answer;
	private int difficulty;
	private int type;
	
	public void quiz() {
		Scanner sc;
		sc = new Scanner(System.in);
		int input, rightAns, i, again;
		rightAns = 0;
		readDifficulty();
		readProblemType();
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
		x = generateQuestionArgument();
		y = generateQuestionArgument();
		
		int problemType;
		
		//If Problem Type chosen was 5, it will randomize what kind of problem will be asked next
		if (this.type == 5) {
			problemType = rand.nextInt(4) + 1;
		} else {
			problemType = this.type;
		}
		
		//Sorts out which type of problem to use
		if (problemType == 1) {
			System.out.printf("How much is %d + %d?%n", x, y);
			this.answer = x + y;
		} else if (problemType == 2) {
			System.out.printf("How much is %d * %d?%n", x, y);
			this.answer = x * y;
		} else if (problemType == 3) {
			System.out.printf("How much is %d - %d?%n", x, y);
			this.answer = x - y;
		} else {
			System.out.printf("How much is %d / %d? (Whole number only. No remainder)%n", x, y);
			this.answer = x / y;
		}
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
	
	//Asks the user what kind of problem they would like to be asked
	//If 1 - Addition
	//If 2 - Multiplication
	//If 3 - Subtraction
	//If 4 - Division
	//If 5 - Each question will be randomized with what kind of question will be asked
	public void readProblemType() {
		Scanner scan;
		scan = new Scanner(System.in);
		System.out.println("What kind of problems would you like to solve?");
		System.out.println("1) Addition");
		System.out.println("2) Multiplication");
		System.out.println("3) Subtraction");
		System.out.println("4) Division");
		System.out.println("5) Mixed Combination of Above");
		int type;
		type = scan.nextInt();
		while (type < 1 || type > 5) {
			System.out.println("Please enter a valid input");
			type = scan.nextInt();
		}
		this.type = type;
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
		CAI5 t;
		t = new CAI5();
		t.quiz();
	}
}