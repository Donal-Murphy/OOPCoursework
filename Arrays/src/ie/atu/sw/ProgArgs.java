package ie.atu.sw;

public class ProgArgs {
	
	public static void main(String[] args) {
		System.out.println(args + "---->" + args.length);
		
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
			
			if (args[i].equals("ATU")) {
				System.out.println("\tWish you were here");
			}
		}
		
		for (String s : args) { //Called a "for in loop/for each loop". Shorter, but you lose the ability to index
			System.out.println(s);
		}
	}

}
