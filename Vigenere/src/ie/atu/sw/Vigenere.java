package ie.atu.sw;
import java.io.*;

public class Vigenere {
	public static final int MIN_KEY_SIZE = 10;
	public static final int MAX_KEY_SIZE = 100;

	private char[] key = null;
	
	public Vigenere(String key) throws Exception {
		setKey(key);
	}
	
	public void setKey(String key) throws Exception {
		this.key = key.trim().toUpperCase().toCharArray();
		this.validateKey(key);
	}
	
	private void validateKey(String key) throws Exception {
		//checkBounds(key);
		if (key == null) {
			throw new Exception("Vigenere error: key cannot be null");
		}else if (key.length() < MIN_KEY_SIZE || key.length() > MAX_KEY_SIZE) {
			throw new Exception("Vigenere error: key size must be between "
					+ MIN_KEY_SIZE + " and " + MAX_KEY_SIZE + " characters");
		}
	}
	
	private void validateText(String text) throws Exception {
		if (text == null || text.length() < MIN_KEY_SIZE) {
			throw new Exception("Vigenere error: invalid text. The minimum "
					+ "size of plain and cipher text is " + MIN_KEY_SIZE);
		}
	}
	
	private void checkBounds(String s) throws Exception{
		boolean valid = true;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if ((c < 'A' || c > 'Z') && c!= 0x20) {
				valid = false;
				break;
			}
		}
		if (!valid) throw new Exception("Invalid character in key or text.");
	}
	
	public String encrypt(String plainText) throws Exception {
		return doCipher(plainText, true);
	}
	
	public String decrypt(String cipherText) throws Exception {
		return doCipher(cipherText, false);
	}
	
	private String doCipher(String s, boolean encrypt) throws Exception {
		validateText(s);
		//checkBounds(s);
		char[] localKey = s.length() > key.length ? getPaddedKey(s) : key;
		
		StringBuilder sb = new StringBuilder(); //Never create string literal inside a loop w/o stringbuilder
		
		for (int i = 0; i < s.length(); i++) {
			char c = encrypt? getEncryptedCharacter(localKey[i], s.charAt(i)) : getDecryptedCharacter(localKey[i], s.charAt(i));
			sb.append(c);
		}
		
		return sb.toString();
	}
	
	private char[] getPaddedKey(String s) {
		char[] padded = new char[s.length()];
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			padded[i] = key [index];
			index++;
			
			if (index == key.length) index = 0;
		}
		
		for (int i = 0; i < s.length(); i++) {
			System.out.print(padded[i]);
		}
		
		return padded;
	}
	
	public void saveKey(String file) throws Exception{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(file)));
		out.writeObject(key);
		out.close();
	}
	
	public void loadKey(String file) throws Exception{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(file)));
		this.key = (char[]) in.readObject();
		in.close();
	}
	
	private char getEncryptedCharacter(char key, char plain) {
		
		for (int row = 0; row < TABULA_RECTA.length; row++) {
			if (TABULA_RECTA[row][0] == key) {
				for (int col = 0; col < TABULA_RECTA[row].length; col++) {
					if (TABULA_RECTA[0][col] == plain) {
						return TABULA_RECTA[row][col];
					}
				}
			}
		}
		
		return plain;
	}
	
	private char getDecryptedCharacter(char key, char cipher) {
		
		for (int col = 0; col < TABULA_RECTA[0].length; col++) {
			if (TABULA_RECTA[0][col] == key) {
				for (int row = 0; row < TABULA_RECTA.length; row++) {
					if (TABULA_RECTA[row][col] == cipher) {
						return TABULA_RECTA[row][0];
					}
				}
			}
		}
		
		return cipher;
	}
	
	private static final char[][] TABULA_RECTA = { 
			{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'},
			{'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A'},
			{'C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B'},
			{'D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C'},
			{'E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D'},
			{'F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E'},
			{'G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F'},
			{'H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G'},
			{'I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H'},
			{'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I'},
			{'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J'},
			{'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K'},
			{'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L'},
			{'N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M'},
			{'O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N'},
			{'P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O'},
			{'Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P'},
			{'R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q'},
			{'S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R'},
			{'T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S'},
			{'U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T'},
			{'V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U'},
			{'W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V'},
			{'X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W'},
			{'Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X'},
			{'Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y'}
		};
}
