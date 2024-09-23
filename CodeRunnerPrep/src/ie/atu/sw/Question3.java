package ie.atu.sw;

public class Question3 {
	
	public String reverse(String string){
		 if (string.length() <= 1) {
	            return string;
	        }
	        // Base case: if the string has two characters, return them with a pipe between them
	        else if (string.length() == 2) {
	            return string.charAt(1) + "|" + string.charAt(0);
	        }
	        // Reverse the substring starting from the second character and insert "|" between characters
	        return string.charAt(string.length() - 1) + "|" + reverse(string.substring(1, string.length() - 1)) + "|" + string.charAt(0);
	    
	}
	
	public static void main(String[] args) {
		Question3 test = new Question3();
		System.out.println(test.reverse("GMIT"));
	}

}
