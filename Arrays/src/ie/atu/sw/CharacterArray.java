package ie.atu.sw;

import java.util.concurrent.ThreadLocalRandom;

public class CharacterArray {
	private char[] text = null;
	private static final int MIN_OGHAM = 5760;
	private static final int MAX_OGHAM = 5791;
	
	public CharacterArray(int size) {
		text = new char[size];
		init();
	}
	
	private void init( ) {
		ThreadLocalRandom rnd = ThreadLocalRandom.current();
		
		for (int i = 0; i < text.length; i++) {
			text[i] = (char) rnd.nextInt(MIN_OGHAM, MAX_OGHAM + 1);
		}
	}
	
	public String getCharactersAsString() {
		return new String(text);
	}
	
	public static void main(String[] args) {
		if (args.length > 0){
			int size = Integer.parseInt(args[0]);
			CharacterArray ca = new CharacterArray(size);
			String s = ca.getCharactersAsString();
			System.out.println(s);
		}else {
			System.out.println("Usage: java ie.atu.sw.CharacterArray <size>");
		}
	}

}
