/**
 * 
 */
package com.nagarro.flightsearch.common.constant;

/**
 * Abstract Class {@link Constant} consists global constants that may used through the application
 * 
 * @author Prem Kumar
 * @since 1.0
 */
public abstract class Constant {

    // Flight Constants

    public static final int FLIGHT_CODE_LENGTH = 2;

    public static final String SORT_BY_FARE = "0";
    public static final String SORT_BY_FARE_AND_DURATION = "1";

    public static final int DEFAULT_DEPARTURE_LOCATION_LENGTH = 3;
    public static final int DEFAULT_ARRIVAL_LOCATION_LENGTH = 3;

    public static final String DEFAULT_DATE_FORMAT = "dd-MM-yyyy";
    public static final String DATE_SEPERATOR = "-";

    public static final String DEFAULT_DIRECTORY_TO_SCAN = "C:\\FlightSearch\\flightscsv";

    public static final String DEFAULT_FILE_EXTENSION = ".csv";

    // If user doesn't provide the search delay. This default values will be
    // used.
    public static final int DEFAULT_SEARCH_DELAY = 1000 * 5;

    // flight object fields
    public static final String FIELD_FLIGHT_NUMBER = "flightNumber";
    public static final String FIELD_DEPARTURE_LOCATION = "departureLocation";
    public static final String FIELD_ARRIVAL_LOCATION = "arrivalLocation";
    public static final String FIELD_VALID_TILL = "validTill";
    public static final String FIELD_FLIGHT_TIME = "flightTime";
    public static final String FIELD_FLIGHT_DURATION = "flightDuration";
    public static final String FIELD_FARE = "fare";
    public static final String FIELD_SEAT_AVAILABLE = "seatAvailable";
    public static final String FIELD_FLIGHT_CLASS = "flightClass";

    // query
    public static final String QUERY_SELECT_ALL = "from Login";

    // option
    public static final String OPTION_YES = "y";

    public static final String DEFAULT_FILE_DELIMITER = "|";

    private Constant() {

    }
}
