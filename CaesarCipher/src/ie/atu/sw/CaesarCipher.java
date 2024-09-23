package ie.atu.sw;

public class CaesarCipher {
	private int key = 0;

	public CaesarCipher(int key) {
		this.key = key;
	}
	
	public String encrypt(String plainText) {
		return cipher(true,plainText);
	}
	
	public String decrypt(String cipherText) {
		return cipher(false,cipherText);
	}
	
	private String cipher(boolean encrypt, String text) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < text.length(); i++) {
			if (encrypt) {
				sb.append((char)(text.codePointAt(i) + key));
			}else {
				sb.append((char)(text.codePointAt(i) - key));
			}
		}
		return sb.toString();
	}
	
	
}
