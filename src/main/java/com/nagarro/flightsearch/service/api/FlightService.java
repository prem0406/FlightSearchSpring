package com.nagarro.flightsearch.service.api;

import java.util.List;

import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.FlightSearchParameters;

/**
 * The interface {@link FlightService} should be implemented to provide the various operations such as CRUD, related to
 * data store.
 * 
 * @author Rahul Bokolia
 * @since 1.0
 */
public interface FlightService {
    /**
     * Adds a flight to the data store.
     * 
     * @param flight
     *            the flight to add
     */
    void add(Flight flight);

    /**
     * Deletes a flight from the data store.
     * 
     * @param flight
     *            the flight to delete
     */
    void delete(Flight flight);

    /**
     * Returns the entire flight records that are stored in the data store and displays them on the console.
     */
    List<Flight> getFlights();

    /**
     * Retrieves the list of flights from the data store based on the criteria provided as the argument.
     * 
     * @param parameters
     *            the different criteria using which the flights are retrieved
     * @return flights {@link List} a list of flights matched with the provided parameters
     * 
     */
    List<Flight> returnMatchedFlights(FlightSearchParameters parameters);
}
