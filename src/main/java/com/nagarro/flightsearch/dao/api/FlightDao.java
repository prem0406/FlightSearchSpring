/**
 * 
 */
package com.nagarro.flightsearch.dao.api;

import java.util.List;

import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.FlightSearchParameters;

/**
 * 
 * Interface IDao specifies basic operations to perform.
 * 
 * @author Rahul Bokolia
 * 
 * @since 1.0
 */
public interface FlightDao {

    /**
     * adds a {@link Flight} object to data store
     * 
     * @param flight
     *            the flight to add
     */
    void add(Flight flight);

    /**
     * retrieves the flight(s) that matches the specified flight parameters
     * 
     * @param parameter
     *            {@link FlightSearchParameters} the flight parameters
     * @return flights {@link List} the list of flight
     */
    List<Flight> retrieve(FlightSearchParameters parameter);

    /**
     * retrieves all the flight records that are present in the data store.
     * 
     * @return List of type {@link Flight}
     */
    List<Flight> getFlights();

    /**
     * deletes flight record specified in the argument
     * 
     * @param flight
     *            the flight to delete
     * @return result {@link Boolean} true if delete operation is successful,otherwise false
     */
    void delete(Flight flight);

}
