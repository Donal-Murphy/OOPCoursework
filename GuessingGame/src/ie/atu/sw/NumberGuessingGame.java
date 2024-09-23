package ie.atu.sw;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.*;

public class NumberGuessingGame {
	
	private static final int MAX_GUESSES = 12;
	private Scanner s;
	private int number;
	
	public NumberGuessingGame() {
		s = new Scanner(System.in);
	}

	public void start() {
		
		out.println("********************************");
		out.println("***** Number Guessing Game *****");
		out.println("********************************");
		
		//Generate a Random number with math.random (good, but error prone):
		//number = (int)(Math.random() * 100); //brackets matter, otherwise the nuber could be downcast to 0
		
		//Generate a random number using java.util.Random (better):
		//Random rand = new Random();
		//number = rand.nextInt(1, 101);
		
		//Generate a random number using threadLocalRandom (best - more random):
		ThreadLocalRandom random = ThreadLocalRandom.current();
		number = random.nextInt(1, 101);
		
		boolean notGuessed = true;
		//int counter = 0;
		
		/*
		//------------------------ Using a WHILE loop ------------------------
		while (counter < MAX_GUESSES && notGuessed) {
			out.println("Guess a number between 1 and 100:");
			int guess = Integer.parseInt(s.next());
			if (guess == number) {
				out.println("Congratulations! The number was " + number);
				notGuessed = false;
			}else if(guess > number) {
				out.println("Too High!");
			}else {
				out.println("Too Low!");
			}
			counter ++;
			out.println("You have " + (MAX_GUESSES - counter) + " guesses left.");
		}
		*/
		
		/*
		//------------------------ Using a DO loop ------------------------
		do {
			out.println("Guess a number between 1 and 100:");
			int guess = Integer.parseInt(s.next());
			if (guess == number) {
				out.println("Congratulations! The number was " + number);
				notGuessed = false;
			}else if(guess > number) {
				out.println("Too High!");
			}else {
				out.println("Too Low!");
			}
			counter ++;
			out.println("You have " + (MAX_GUESSES - counter) + " guesses left.");
			
		}while(counter < MAX_GUESSES && notGuessed);
		*/
		
		//------------------------ Using a FOR loop ------------------------
		for (int counter = 0; (counter < MAX_GUESSES) && (notGuessed == true); counter++) {
			out.println("Guess a number between 1 and 100:");
			int guess = Integer.parseInt(s.next());
			
			if (guess == number) {
				out.println("Congratulations! The number was " + number);
				notGuessed = false;
			}else if(guess > number) {
				out.println("Too High!");
			}else {
				out.println("Too low!");
			}
			out.println("You have " + (MAX_GUESSES - counter) + " guesses left.");
		}
		
		if (notGuessed) {
			out.println("Too bad, the correct answer was " + number);
		}
	}
}
