package com.nagarro.flightsearch.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertToValidDateFormat(String dateAsString, String dateSeperator, String dateFormat) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
        
        Date date = formatter.parse(dateAsString);
		return date;
	}

	public static String dateInString(Date validTill, String dateFormat) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		String dateAsString = null;
		try {
			dateAsString = formatter.format(validTill);
		} catch (Exception e) {
			throw new Exception();
		}
		
		return dateAsString;
	}

}
