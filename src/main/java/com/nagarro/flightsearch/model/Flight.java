/**
 * 
 */
package com.nagarro.flightsearch.model;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;

import com.nagarro.flightsearch.common.constant.Constant;
import com.nagarro.flightsearch.common.exception.FlightException;
import com.nagarro.flightsearch.util.DateUtil;
import com.nagarro.flightsearch.util.StringUtil;

/**
 * The class Flight is used as the blueprint for the flight.Contains the parameters associated with flight.
 * 
 * @author Rahul Bokolia
 * @version 1.0
 */
@Entity
@Table(name = "flight", catalog = "flight_search_spring")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "number", nullable = false)
    private String flightNumber;

    @Column(name = "departure_location", nullable = false)
    private String departureLocation;

    @Column(name = "arrival_location", nullable = false)
    private String arrivalLocation;

    @Column(name = "valid_till", nullable = false)
    private Date validTill;

    @Column(name = "time", nullable = false)
    private String flightTime;

    @Column(name = "duration", nullable = false)
    private Double flightDuration;

    @Column(name = "fare", nullable = false)
    private Double fare;

    @Column(name = "seat_availability", nullable = false)
    private Boolean seatAvailable;

    @Column(name = "class", nullable = false)
    private String flightClass;

    // Indexes on the basis of appearance of fields in the CSV file
    private static final int INDEX_F_NUMBER = 0;
    private static final int INDEX_F_DEPARTURE_LOC = 1;
    private static final int INDEX_F_ARRIVAL_LOC = 2;
    private static final int INDEX_F_VALID_TILL = 3;
    private static final int INDEX_F_TIME = 4;
    private static final int INDEX_F_DURATION = 5;
    private static final int INDEX_F_FARE = 6;
    private static final int INDEX_F_SEAT_AVAILABLITY = 7;
    private static final int INDEX_F_CLASS = 8;

    private static final Logger LOGGER = Logger.getLogger(Flight.class);

    /**
     * constructs a new Flight instance with the default values
     * 
     */
    public Flight() {

    }

    /**
     * constructs a new instance of Flight with the specified values provided as string array
     * 
     * @param flightData
     *            {@link String[]}
     * @throws FlightException
     */
    public Flight(String[] flightData) throws FlightException {
        createFlight(flightData);
    }

    /**
     * actually creates a flight from the string array
     * 
     * @param flightData
     * @throws FlightException
     */
    private void createFlight(String[] flightData) throws FlightException {

        flightNumber = flightData[INDEX_F_NUMBER].trim();
        departureLocation = flightData[INDEX_F_DEPARTURE_LOC].trim();
        arrivalLocation = flightData[INDEX_F_ARRIVAL_LOC].trim();

        validTill = getDateFromString(flightData[INDEX_F_VALID_TILL]);

        flightTime = flightData[INDEX_F_TIME];

        flightDuration = Double.parseDouble(flightData[INDEX_F_DURATION]);
        fare = Double.parseDouble(flightData[INDEX_F_FARE]);
        seatAvailable = (Constant.OPTION_YES.equalsIgnoreCase(flightData[INDEX_F_SEAT_AVAILABLITY])) ? true : false;

        flightClass = flightData[INDEX_F_CLASS].trim();
    }

    /**
     * this method is just a wrapper method of convertToValidDateFormat from DateUtil class. It wraps the exception in
     * FlightException thus more related to flight entity.
     * 
     * @param dateAsString
     * @return
     * @throws FlightException
     */
    private Date getDateFromString(String dateAsString) throws FlightException {
        Date date = null;
        String dateFormat = null;
        dateFormat = Constant.DEFAULT_DATE_FORMAT;

        try {
            date = DateUtil.convertToValidDateFormat(dateAsString, Constant.DATE_SEPERATOR, dateFormat);
        } catch (ParseException e) {
            throw new FlightException("Error caught in createFlight()", e);
        }
        return date;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * sets id
     * 
     * @param id
     *            the id to set the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * gets flight number
     * 
     * @return flight number
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public Date getValidTill() {
        return validTill;
    }

    /**
     * @param validTill
     *            the validTill to set
     */
    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }

    /**
     * @param flightTime
     *            the flightTime to set
     */
    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public Double getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(Double flightDuration) {
        this.flightDuration = flightDuration;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public Boolean getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(Boolean seatAvailable) {
        this.seatAvailable = seatAvailable;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {

        this.flightClass = flightClass.toUpperCase();
    }

    /**
     * Overrides the to String of the Object class
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String flightAsString = null;
        String dateFormat = Constant.DEFAULT_DATE_FORMAT;

        try {
            flightAsString = StringUtil
                    .concatenate("\n", flightNumber, "\t", departureLocation, "\t", arrivalLocation, "\t",
                            DateUtil.dateInString(validTill, dateFormat), "\t", flightTime, "\t",
                            flightDuration.toString(), "\t", fare.toString(), "\t", seatAvailable.toString(), "\t",
                            flightClass);
        } catch (Exception e) {
            LOGGER.error("Error in converting flight object to string representation!!", e);
        }
        return flightAsString;
    }
}
