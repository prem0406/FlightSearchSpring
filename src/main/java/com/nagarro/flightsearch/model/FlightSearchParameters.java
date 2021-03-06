/**
 * 
 */
package com.nagarro.flightsearch.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;

import com.nagarro.flightsearch.common.constant.Constant;
import com.nagarro.flightsearch.util.DateUtil;
import com.nagarro.flightsearch.util.StringUtil;

/**
 * Whenever a user queries for a flight search, an object of this class will be created and working is done on this
 * object
 * 
 * @author Rahul Bokolia
 * 
 */
public class FlightSearchParameters implements Serializable {

    private static final long serialVersionUID = -4353403758520419153L;

    @NotEmpty
    private String departureLocation;

    @NotEmpty
    private String arrivalLocation;

    private Date flightDate;

    @NotEmpty
    private String flightClass;

    @NotEmpty
    private String outputPreference;

    private static final Logger LOGGER = Logger.getLogger(FlightSearchParameters.class);

    /**
     * @return the departureLocation
     */
    public String getDepartureLocation() {
        return departureLocation;
    }

    /**
     * @param departureLocation
     *            the departureLocation to set
     */
    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    /**
     * @return the arrivalLocation
     */
    public String getArrivalLocation() {
        return arrivalLocation;
    }

    /**
     * @param arrivalLocation
     *            the arrivalLocation to set
     */
    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    /**
     * @return the flightDate
     */
    public Date getFlightDate() {
        return flightDate;
    }

    /**
     * @param flightDate
     *            the flightDate to set
     */
    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    /**
     * @return the flightClass
     */
    public String getFlightClass() {
        return flightClass;
    }

    /**
     * @param flightClass
     *            the flightClass to set
     */
    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass.toUpperCase();
    }

    /**
     * @return the outputPreference
     */
    public String getOutputPreference() {
        return outputPreference;
    }

    /**
     * @param outputPreference
     *            the outputPreference to set
     */
    public void setOutputPreference(String outputPreference) {
        this.outputPreference = outputPreference;
    }

    /*
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String str = null;
        String dateFormat = Constant.DEFAULT_DATE_FORMAT;
        try {
            str = StringUtil.concatenate("FlightSearchParameters [departureLocation=", departureLocation,
                    ", arrivalLocation=", arrivalLocation, ", flightDate=",
                    DateUtil.dateInString(flightDate, dateFormat), ", flightClass=", flightClass,
                    ", outputPreference=", outputPreference, "]");
        } catch (Exception e) {
            LOGGER.error("Error in representing FlightSearchParameter object as String", e);
        }
        return str;
    }

}
