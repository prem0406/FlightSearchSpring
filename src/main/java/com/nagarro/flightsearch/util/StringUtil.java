package com.nagarro.flightsearch.util;

public class StringUtil {
	public static boolean isStringValid(String str) {
		return true;
	}


	public static String concatenate(String string, String flightNumber, String string2, String departureLocation,
			String string3, String arrivalLocation, String string4, String dateInString, String string5,
			String flightTime, String string6, String string7, String string8, String string9, String string10,
			String string11, String string12, String flightClass) {
		
		return string+flightNumber+string2+departureLocation+string3+arrivalLocation+string4+dateInString+string5+flightTime
				+string6+string7+string8+string9+string10+string11+string12+flightClass;
	}


	public static String concatenate(String string, String departureLocation, String string2, String arrivalLocation,
			String string3, String dateInString, String string4, String flightClass, String string5,
			String outputPreference, String string6) {
		
		return "Flight Search Parameters";
	}


	public static String concatenate(String string, String flightClass, String string2) {
		
		return string+flightClass+string2;
	}
}
