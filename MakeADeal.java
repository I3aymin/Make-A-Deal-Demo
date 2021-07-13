import java.text.DecimalFormat;
import java.util.Scanner;

public class MakeADeal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double numPlays = 0;
		int prize = 0, guess = 0, view = 0, newGuess = 0;
		double wins = 0;
		Scanner keyboard = new Scanner(System.in);
		DecimalFormat twoDecimals = new DecimalFormat("0.00");
		
		System.out.print("Enter a number of times you want to play: ");
		numPlays = keyboard.nextInt();
		
		System.out.println("\nPrize    " + "Guess    " + "View    " + "New Guess");
		for(int i = 0; i < (int) numPlays; i++) {
			prize = getRandom(3);
			guess = getRandom(3);
			view = getRandom(3);
			newGuess = getRandom(3);
			
			while(view == prize || view == guess) {
				view = getRandom(3);
			}
			while(newGuess == view || newGuess == guess) {
				newGuess = getRandom(3);
			}
			if(newGuess == prize) {
				wins++;
			}
			
			System.out.println("  " + prize + "        " + guess + "        " + view + "         " + newGuess); 
		}
		
		System.out.println("\nProbability of winning if you switch = " + twoDecimals.format(probability(numPlays, wins)));
		System.out.println("Probability of winning if you do not switch = " + twoDecimals.format((1 - probability(numPlays, wins))));
	}
	
	public static int getRandom(int max) {
		return (int) ((Math.random() * max) + 1);
	}
	
	public static double probability(double total, double part) {
		return (part/total);
	}
}
