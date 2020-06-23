/**
 * 
 */
package com.nagarro.flightsearch.validator;

import com.nagarro.flightsearch.common.constant.Constant;
import com.nagarro.flightsearch.common.exception.FlightException;

/**
 * @author Rahul Bokolia
 * 
 */
public class LocationValidator implements Validator {

    @Override
    public void validate(Object object) throws FlightException {
        int locationLength = Constant.DEFAULT_DEPARTURE_LOCATION_LENGTH;
        String location = null;

        if (!(object instanceof String)) {
            throw new FlightException("Invalid parameter: Expected String Object!! ");
        }

        location = (String) object;

        if (location.length() != locationLength) {
            throw new FlightException("Invalid Departure Location!!");
        }
    }

    public void validateLocations(String departureLoc, String arrivalLoc) throws FlightException {
        validate(departureLoc);
        validate(arrivalLoc);
    }

}
