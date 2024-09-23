package ie.atu.sw;

import java.util.Arrays;
import java.util.stream.Stream;

public class Question4 {
	
	public String[] substrings(String string){
		
		if (string.length() < 3) {
			//if string is less than 3, discard
			String[] arr = {};
			
			return arr;
		}else {
			//split string into 2 arrays, a contains the first 3 letters, b contains the rest
			String[] a = {string.substring(0,3)};
			String[] b = {string.substring(3)};
			
			//Join strings a and b, passing b back to the method recursively, until it is less than 3 letters long.
			//Remove square brackets you get when converting arrays to strings.
			return Stream.concat(Arrays.stream(a), Arrays.stream( substrings( Arrays.toString(b).replace("[", "").replace("]", "") ))).toArray(String[]::new);
		}
	}
	
	
	public static void main(String[] args) {
		Question4 test = new Question4();
		System.out.println(Arrays.toString(test.substrings("Follow the process")));
	}

}
