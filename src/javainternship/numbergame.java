package numberGame;
import java.util.Scanner;
import java.util.Random;
public class guessNumber {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rc = new Random();
		int lowerRange = 1;
		int upperRange = 100;
		int availableAttempts = 5;
		int score = 0;
		
		System.out.println("We welcome you to the number guessing game.\nYou have 5 attempts to guess the target number by us.\nGood Luck!");
		
		do{
			int targetNumber = rc.nextInt(upperRange - lowerRange +1 )+ lowerRange;
	
		int attempt = 0;
		boolean correctGuess = false;
		
		System.out.println("Come on! Make your guess of a number between 1 to 100:");
		
		for(attempt =0; attempt<availableAttempts;attempt++) {
			int numberGuessed = input.nextInt();
				
				if(numberGuessed == targetNumber) {
					System.out.println("Amazing!you have the guessed the number correctly");
					correctGuess = true;
					score++;
					break;
				}
				else if(numberGuessed<targetNumber) {
					System.out.println("Oops!your guess is too low than the target number!");
					
				}
				else {
					System.out.println("Oops! your guess is too high than the target number!");
				}
		}
		if(!correctGuess) {
			System.out.println("Sorry!you have reached maximum number of attempts!\nThe correct number was:"+ targetNumber+"\nBetter luck next time!");
			
		}
		
		
			
			System.out.println("Your score is :"+ score);
	
		System.out.println("Press 1 if you wish to play again,press 0 if you want to quit the game.");
		} while(input.nextInt()== 1);
		System.out.println("Thankyou for playing!\nYour final score is :"+score);
		input.close();
	}
}
