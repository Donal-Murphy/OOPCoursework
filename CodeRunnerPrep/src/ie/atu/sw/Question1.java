package ie.atu.sw;

public class Question1 {
	
	public boolean hasOne(int number){
		while (number > 0) {
			if(number % 10 == 1) {
				return true;
			}else return hasOne((int) number / 10);
		}return false;
	}
	
	public static void main(String[] args) {
		Question1 test = new Question1();
		System.out.println(test.hasOne(10));
	}

}
