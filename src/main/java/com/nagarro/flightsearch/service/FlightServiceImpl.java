package com.nagarro.flightsearch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.flightsearch.dao.api.FlightDao;
import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.FlightSearchParameters;
import com.nagarro.flightsearch.service.api.FlightService;

/**
 * The class {@link FlightServiceImpl} is the class from which the user interacts for getting the facilities of database
 * services
 * 
 * @author Rahul Bokolia
 * @since 1.0
 * 
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightDao flightDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void add(Flight flight) {
        if (flight != null && flightDao != null) {
            flightDao.add(flight);
        }
    }

    @Override
    @Transactional
    public void delete(Flight flight) {

        if (flight != null) {
            flightDao.delete(flight);
        }
    }

    @Override
    @Transactional
    public List<Flight> getFlights() {
        return flightDao.getFlights();
    }

    @Override
    @Transactional
    public List<Flight> returnMatchedFlights(FlightSearchParameters parameters) {
        List<Flight> matchedFlights = new ArrayList<Flight>();
        if (parameters != null) {
            matchedFlights = flightDao.retrieve(parameters);
        }
        return matchedFlights;
    }

}
