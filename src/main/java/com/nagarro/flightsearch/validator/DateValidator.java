/**
 * 
 */
package com.nagarro.flightsearch.validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.nagarro.flightsearch.common.constant.Constant;
import com.nagarro.flightsearch.common.exception.FlightException;

/**
 * @author Rahul Bokolia
 * 
 */
public class DateValidator implements Validator {

    /**
     * validates date for the flight details when the flight are importing
     * 
     * @param flightDate
     *            the date to validate
     * @throws FlightException
     */
    @Override
    public void validate(Object object) throws FlightException {
        String flightDateFormat = null;
        DateFormat dateFormat = null;
        String flightDateStr = null;

        if (!(object instanceof String)) {
            throw new FlightException("Invalid parameter: Expected String object!! ");
        }

        flightDateFormat = Constant.DEFAULT_DATE_FORMAT;
        dateFormat = new SimpleDateFormat(flightDateFormat);
        flightDateStr = (String) object;

        try {
            dateFormat.parse(flightDateStr);

        } catch (java.text.ParseException e) {
            throw new FlightException("Invalid Date!!", e);
        }

    }

}
