package ie.atu.sw;

public class Runner {
	
	public static void main(String[] args) {
		String key = "THEQUICKBROWNFOXJUMPEDOVERTHELAZYDOGS";
		String plainText = "ATTACK THE CASTLE WALL AT DAWN";
		
		Vigenere cipher;
		try {
			cipher = new Vigenere(key);
			cipher.loadKey("./key.txt");
			String cipherText = cipher.encrypt(plainText);
			System.out.println(cipherText);
			System.out.println(cipher.decrypt(cipherText));
			//cipher.saveKey("./key.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			key = null;
		}
		//System.out.println(key);
	}

}
