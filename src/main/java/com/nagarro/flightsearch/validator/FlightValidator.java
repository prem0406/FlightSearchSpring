/**
 * 
 */
package com.nagarro.flightsearch.validator;

import com.nagarro.flightsearch.common.constant.Constant;
import com.nagarro.flightsearch.common.exception.FlightException;
import com.nagarro.flightsearch.common.exception.InvalidArgumentException;

/**
 * The class Validator is used to validate inputs that are coming either directly from the user or flight details from
 * the csv files.
 * 
 * @author Rahul Bokolia
 * 
 */
public class FlightValidator {

    private FlightValidator() {

    }

    /**
     * validates all the flight details.
     * 
     * @param flightDetails
     *            {@link String[]} the flight details
     * @return true if all fields are validated successfully,otherwise either throws an {@link Exception} or return
     *         false
     * @throws NULLReferenceException
     * @throws FlightException
     */

    public static boolean isFlightDetailsValid(final String[] flightDetails) throws FlightException {
        boolean allOk = true;
        LocationValidator locationValidator = new LocationValidator();
        DateValidator dateValidator = new DateValidator();

        if (flightDetails == null) {
            throw new InvalidArgumentException("argumemrnt flightDetails is found null!!");
        }

        if (flightDetails.length != 9) {
            allOk = false;
            return allOk;
        }

        isFlightNumberValid(flightDetails[0]);
        locationValidator.validateLocations(flightDetails[1], flightDetails[2]);
        dateValidator.validate(flightDetails[3]);
        isFlightTimeValid(flightDetails[4]);
        isFlightDurationValid(flightDetails[5]);
        isFareValid(flightDetails[6]);
        isSeatAvailabilityValid(flightDetails[7]);

        return allOk;
    }

    private static boolean isFlightNumberValid(final String flightNumber) {
        boolean allOk = true;
        int flightCodeLength = Constant.FLIGHT_CODE_LENGTH;
        if (flightNumber.length() < flightCodeLength) {
            allOk = false;
        }
        return allOk;

    }

    private static boolean isFlightDurationValid(final String flightDuartion) {

        String flightDuartionRegex = "\\d{2}\\.\\d{2}";
        return flightDuartion.matches(flightDuartionRegex);
    }

    private static boolean isFlightTimeValid(final String flightTime) {
        String flightTimeRegex = "\\d{4}";
        return flightTime.matches(flightTimeRegex);

    }

    private static boolean isSeatAvailabilityValid(final String seatAvailability) {
        String seatAvailable = seatAvailability.toLowerCase();
        return "true".equals(seatAvailable) ? true : false;
    }

    private static boolean isFareValid(final String flightFare) {
        String flightFareRegex = "\\d{4,7}";
        return flightFare.matches(flightFareRegex);
    }

}
