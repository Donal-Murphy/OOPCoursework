package ie.atu.sw;

import java.time.*;

public class SeasonChecker {
	
	public String getSeason(LocalDate date) {
		Month month = date.getMonth();
		
		return switch(month) {
			case FEBRUARY, MARCH, APRIL 		-> "Spring";
			case MAY, JUNE, JULY 				-> "Summer";
			case SEPTEMBER, OCTOBER 			-> "Autumn";
			case NOVEMBER, DECEMBER, JANUARY 	-> "Winter";
			default 							-> {
				yield (month == Month.AUGUST && date.getDayOfMonth() < 20) ? "Holiday Season" : "Autumn"; //This is a "ternary if statement". Equivalent to below.
				/*
				if (month == Month.AUGUST && date.getDayOfMonth() < 20) {
					yield "Holiday Season"; //Use "yield" as it is a multi-line expression
				}else {
					yield "Autumn";
				}
				*/
			}
		};
	}

}
