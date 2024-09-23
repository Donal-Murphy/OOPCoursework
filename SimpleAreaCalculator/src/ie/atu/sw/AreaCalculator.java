package ie.atu.sw;

import java.util.Scanner;

public class AreaCalculator {

	// Instance variables
	private Scanner scanner;
	private boolean keepRunning = true; //While true, menu remains open

	public AreaCalculator() {
		scanner = new Scanner(System.in);
		do {
			init();
			processInput();
		} while (keepRunning);
		
	}

	public void calcAreaCircle() {
		System.out.println("Enter the radius>");
		String input = scanner.next();
		double radius = Double.parseDouble(input);
		double area = Math.PI * (radius * radius);
		System.out.println("Area of Cirle: " + area);
	}

	public void calcAreaTriangle() {
		System.out.println("Enter the width>");
		String input = scanner.next();
		double width = Double.parseDouble(input);

		System.out.println("Enter the height>");
		input = scanner.next();
		double height = Double.parseDouble(input);
		double area = height * (width / 2.0d);
		System.out.println("Area of Triangle: " + area);
	}

	private void processInput() {
		String option = scanner.next();
		int choice = Integer.parseInt(option);

		/*-------------Using if statements-------------------
		if (choice == 1) {
			calcAreaCircle();
		} else if (choice == 2) {
			calcAreaTriangle();
		} else if (choice == 3) {
			System.exit(0);
		} else {
			System.out.println("Invalid selection.");
		}
		*/

		// -------------Using Switch statement----------------

		/*
		 * switch(choice) { case 1: calcAreaCircle(); break; case 2: calcAreaTriangle();
		 * break; case 3: System.exit(0); break; default:
		 * System.out.println("Invalid selection."); break; } }
		 */
		// ----------Using Extended Switch Statement------------e3

		switch (choice) {
			case 1 -> calcAreaCircle();
			case 2 -> calcAreaTriangle();
			case 3 -> keepRunning = false;
			default -> System.out.println("Invalid Selection");
		}
	}

	private void init() {
		System.out.println("-------------------------------------");
		System.out.println("\tSimple Area Calculator");
		System.out.println("-------------------------------------");
		System.out.println("(1) Area of a Circle");
		System.out.println("(2) Area of a Triangle");
		System.out.println("(3) Quit");
		System.out.println("Select {1-3>");
	}

	public static void main(String[] args) {
		new AreaCalculator();
	}

}
