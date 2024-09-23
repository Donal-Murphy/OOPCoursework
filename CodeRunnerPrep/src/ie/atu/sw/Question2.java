package ie.atu.sw;

public class Question2 {
	
	public String removeDuplicates(String in){
		if (in == null || in.length() == 1) {
			return in;
		}if (in.charAt(0) == in.charAt(1)) {
			return removeDuplicates(in.substring(1));
		}else {
			return in.charAt(0) + removeDuplicates(in.substring(1));
		}
			
	}
	
	public static void main(String[] args) {
		Question2 test = new Question2();
		System.out.println(test.removeDuplicates("AAABBBBBDDDDDCC"));
	}

}
