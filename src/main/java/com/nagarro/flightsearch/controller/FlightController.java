/**
 * 
 */
package com.nagarro.flightsearch.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.flightsearch.common.constant.SpringConstant;
import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.FlightSearchParameters;
import com.nagarro.flightsearch.service.api.FlightService;
import com.nagarro.flightsearch.uploader.BackgroundUploader;

/**
 * The class {@link FlightController} handles the requests that are concerns for the flight operations such as adding a
 * new flight, searching,listing. <br>
 * This class is a spring controller class. <br>
 * <br>
 * Since, this class is a Spring Controller class.This class must not be used as any ordinary class.Spring uses this
 * class for mapping the requests to and from the user. <br>
 * <br>
 * 
 * The user should not create the instance of this class as the Spring container automatically registers this class as
 * bean in the application context.
 * 
 * @author Prem Kumar
 * @since 1.0
 */
@Controller
public class FlightController {

    // log4j logger
    private static final Logger LOGGER = Logger.getLogger(FlightController.class);

    @Autowired
    private FlightService flightService;
    
    public FlightController() {
        BackgroundUploader scanForFiles = new BackgroundUploader(flightService);

        try {
            scanForFiles.startScanningInBackground();
        } catch (IOException e) {
            LOGGER.info("\n\nCannot start the Background Scanner because of IOException !!\n\n", e);
        } catch (Exception e) {
            LOGGER.info("\n\nCannot started the Background Scanner!!\n\n", e);
        }
        LOGGER.info("Started Scanning for new file... ");
    }

    public FlightController(FlightService service) {
        this.flightService = service;
    }

    /**
     * this method is used to show a page that asks for adding a flight details to data store
     * 
     * @return {@link ModelAndView} object that defines the add flight page
     */
    @RequestMapping(value = SpringConstant.REQUEST_ADD_FLIGHT)
    public ModelAndView addFlightPage() {
        ModelAndView modelAndView = new ModelAndView(SpringConstant.VIEW_ADD_FLIGHT_PAGE);

        modelAndView.addObject(SpringConstant.MODEL_NAME_FLIGHT, new Flight());
        return modelAndView;
    }

    /**
     * 
     * this method is used to actually add the flight details to data store. <br>
     * This method first
     * 
     * @param flight
     *            the Flight object to add
     * @return next view name
     * 
     */
    @RequestMapping(value = SpringConstant.REQUEST_PROCESS_FLIGHT)
    public String processAddFlight(@ModelAttribute
    Flight flight) {

        flightService.add(flight);

        LOGGER.info("Flight details processed for adding!!");
        return SpringConstant.VIEW_HOME_PAGE;
    }

    /**
     * method that lists all the flights.<br>
     * it returns the flights that are store in the database
     * 
     * @return {@link ModelAndView}
     */
    @RequestMapping(value = SpringConstant.REQUEST_LIST_FLIGHT)
    public ModelAndView listOfFlights() {
        ModelAndView modelAndView = new ModelAndView(SpringConstant.VIEW_LIST_FLIGHT_PAGE);

        List<Flight> flights = flightService.getFlights();
        modelAndView.addObject("flights", flights);

        return modelAndView;
    }

    /**
     * method that performs the searching of flights.<br>
     * 
     * 
     * @param flightSearchParams
     * @param result
     *            used to store the errors that may have arise while validating the search parameters
     * 
     * @return {@link ModelAndView} object that contains view name and the flights that matched the criteria
     */
    @RequestMapping(value = SpringConstant.REQUEST_SEARCH_FLIGHT)
    public ModelAndView searchFlight(@Valid
    @ModelAttribute(SpringConstant.MODEL_NAME_FLIGHT_SEARCH_PARAMS)
    FlightSearchParameters flightSearchParams, BindingResult result) {
        List<Flight> matchedFlights = null;

        if (result.hasErrors()) {
            return new ModelAndView(SpringConstant.VIEW_HOME_PAGE);
        } else {
            matchedFlights = flightService.returnMatchedFlights(flightSearchParams);

            return new ModelAndView(SpringConstant.VIEW_FLIGHT_RESULT, SpringConstant.MODEL_NAME_MATCHED_FLIGHT,
                    matchedFlights);
        }
    }
}
