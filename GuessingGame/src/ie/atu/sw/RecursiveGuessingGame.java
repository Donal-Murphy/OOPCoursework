package ie.atu.sw;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RecursiveGuessingGame {
	private static final int MAX_GUESSES = 12;
	private Scanner s;
	private int number;
	private int count = 0;
	
	public RecursiveGuessingGame() {
		s = new Scanner(System.in);
		ThreadLocalRandom random = ThreadLocalRandom.current();
		number = random.nextInt(1, 101);
		System.out.println("*********************************");
		System.out.println("**** Recursive Guessing Game ****");
		System.out.println("*********************************");
		System.out.println("Guess a number between 1 and 100:");
	}

	public void start() {
		int guess = Integer.parseInt(s.next());
		if (guess == number) {
			System.out.println("Congratulations! " + number + " was the correct answer!");;
		}else if (guess > number && count < (MAX_GUESSES - 1)) {
			count ++;
			System.out.println("Too High!\nGuesses left: " + (MAX_GUESSES - count) + "\nGuess again:");
			start();
		}else if (guess < number && count < (MAX_GUESSES - 1)) {
			count ++;
			System.out.println("Too Low!\nGuesses left: " + (MAX_GUESSES - count) + "\nGuess again:");
			start();
		}else System.out.println("Too bad! The correct answer was " + number);
	}
}
