package ie.atu.sw;

import java.time.LocalDate;

public class Student {

	/*
	 * Define some state for the class Student. These are all instance variables
	 */

	private long sid;
	private String name = "Undefined";
	private LocalDate dob;
	private boolean registered = false;

	public Student() { // Student is a constructor so is named the same as the class & gets a capital
						// letter
		System.out.println("The ID of the Student object is " + this);
	}
	
	// Add some methods - things class can do (behaviours)

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	protected String study(double hours, int level) {
		double total = hours * level;
		String message = "Studying..." + total;
		
		return message;
	}

	protected boolean execute(String command) {
		System.out.println("Executing..." + command);
		
		return command.endsWith("!");
	}

}
