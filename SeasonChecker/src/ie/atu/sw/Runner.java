package ie.atu.sw;

import java.time.*;

public class Runner {
	
	public static void main(String[] args) {
		var sc = new SeasonChecker();
		String season = sc.getSeason(LocalDate.of(1999, Month.JANUARY, 20)); //"August.month" is an enum
		System.out.println(season);
		
	}

}
