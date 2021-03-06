package com.nagarro.flightsearch.common.constant;

/**
 * Class {@link SpringConstant} contains constants for spring mvc
 * 
 * @author Prem Kumar
 * @since 1.0
 */
public abstract class SpringConstant {

    public static final String LOGIN = "login";

    public static final String VIEW_ADD_FLIGHT_PAGE = "add-flight-form";
    public static final String VIEW_HOME_PAGE = "home";
    public static final String VIEW_LIST_FLIGHT_PAGE = "flight-list";
    public static final String VIEW_LOGIN_PAGE = LOGIN;
    public static final String VIEW_FLIGHT_RESULT = "flightResult";

    public static final String REQUEST_DEAFULT_PAGE = "/";
    public static final String REQUEST_HOME_PAGE = "/home";
    public static final String REQUEST_LOGIN_PAGE = "/login";
    public static final String REQUEST_VERIFY_LOGIN = "/verify-login";
    public static final String REQUEST_LOGOUT = "logout";

    public static final String REQUEST_ADD_FLIGHT = "/flight/add";
    public static final String REQUEST_PROCESS_FLIGHT = "/flight/add/process";
    public static final String REQUEST_LIST_FLIGHT = "/flight/list";
    public static final String REQUEST_SEARCH_FLIGHT = "/search-flight";

    public static final String MODEL_NAME_FLIGHT = "flight";
    public static final String MODEL_NAME_LOGIN = LOGIN;
    public static final String MODEL_NAME_FLIGHT_SEARCH_PARAMS = "flightSearchParams";
    public static final String MODEL_NAME_MATCHED_FLIGHT = "matchedFlights";

    public static final String LOGGED_IN_USER = "loggedinUser";

    private SpringConstant() {

    }
}
