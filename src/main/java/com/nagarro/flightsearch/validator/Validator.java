/**
 * 
 */
package com.nagarro.flightsearch.validator;

import com.nagarro.flightsearch.common.exception.FlightException;

/**
 * @author Prem Kumar
 * 
 */
public interface Validator {
    void validate(Object object) throws FlightException;
}
