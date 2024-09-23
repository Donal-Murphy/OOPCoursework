package ie.atu.sw;

import java.util.Arrays;

public class NGramGenerator {
	public String[] getNGrams(String s, int n) {
		String[] sArray = new String[s.length() - (n-1)];
		
		for ( int i = 0; i < sArray.length; i++) {
			sArray[i] = s.substring(i, i + n);
		}
		return sArray;
	}
	
	public static void main(String[] args) {
		NGramGenerator ngram = new NGramGenerator();
		System.out.println(Arrays.toString(ngram.getNGrams("Happy Days", 4)));
	}
}
