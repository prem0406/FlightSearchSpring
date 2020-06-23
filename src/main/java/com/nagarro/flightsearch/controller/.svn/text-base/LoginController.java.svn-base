/**
 * 
 */
package com.nagarro.flightsearch.controller;

import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.flightsearch.common.constant.SpringConstant;
import com.nagarro.flightsearch.model.FlightSearchParameters;
import com.nagarro.flightsearch.model.Login;
import com.nagarro.flightsearch.service.api.LoginService;

/**
 * The class {@link LoginController} is a spring controller.<br>
 * This class is responsible for handling all the requests related to login.
 * 
 * <br>
 * <br>
 * Since, this class is a Spring Controller class.This class must not be used as any ordinary class.Spring uses this
 * class for mapping the requests to and from the user. <br>
 * <br>
 * 
 * The user should not create the instance of this class as the Spring container automatically registers this class as
 * bean in the application context.
 * 
 * @author Rahul Bokolia
 * @since 1.0
 */

@Controller
@SessionAttributes("loggedinUser")
public class LoginController {

    // log4j logger
    private static final Logger LOGGER = Logger.getLogger(FlightController.class);

    // object that is used to interact with data store
    @Autowired
    private LoginService loginService;

    public LoginController() {

    }

    // injects the loginService at run time
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * method that handles request for login page.
     * 
     * @param model
     *            the model object
     * @return {@link ModelAndView} object
     */
    @RequestMapping({ SpringConstant.REQUEST_DEAFULT_PAGE, SpringConstant.REQUEST_LOGIN_PAGE })
    public ModelAndView showLoginPage(Map<String, Object> model) {
        model.put(SpringConstant.MODEL_NAME_LOGIN, new Login());
        return new ModelAndView(SpringConstant.VIEW_LOGIN_PAGE, model);
    }

    /**
     * method that authenticates the login credentials entered by the end-user.
     * 
     * @param login
     *            the {@link Login} object
     * @param result
     *            contains errors if any
     * @return {@link ModelAndView} object
     */
    @RequestMapping({ SpringConstant.REQUEST_VERIFY_LOGIN })
    public ModelAndView verifyLogin(@Valid
    @ModelAttribute(SpringConstant.MODEL_NAME_LOGIN)
    Login login, BindingResult result) {
        Login loginEntry = null;

        ModelAndView modelAndView = null;

        if (result.hasErrors()) {
            return new ModelAndView(SpringConstant.VIEW_LOGIN_PAGE);
        }

        loginEntry = loginService.getLoginEntry(login.getUsername());

        if (loginEntry == null) {
            modelAndView = new ModelAndView(SpringConstant.VIEW_LOGIN_PAGE);
        } else {
            loginEntry = loginService.getLoginEntry(login.getUsername());

            if (loginEntry.getPassword().equals(login.getPassword())) {

                LOGGER.info("Login Success for username:" + login.getUsername());
                modelAndView = new ModelAndView(SpringConstant.VIEW_HOME_PAGE,
                        SpringConstant.MODEL_NAME_FLIGHT_SEARCH_PARAMS, new FlightSearchParameters());

                // saving the session for this user by adding the username to model
                modelAndView.addObject(SpringConstant.LOGGED_IN_USER, login.getUsername());
            } else {
                modelAndView = new ModelAndView(SpringConstant.VIEW_LOGIN_PAGE);
            }
        }
        return modelAndView;
    }

    /**
     * 
     * method that handles request for home page.
     * 
     * @param model
     *            the model object
     * @return {@link ModelAndView} object
     */
    @RequestMapping(value = SpringConstant.REQUEST_HOME_PAGE)
    public ModelAndView showHomePage(Map<String, Object> model) {
        model.put(SpringConstant.MODEL_NAME_FLIGHT_SEARCH_PARAMS, new FlightSearchParameters());
        return new ModelAndView(SpringConstant.VIEW_HOME_PAGE, model);
    }

    /**
     * 
     * method that handles request for logout.
     * 
     * @param model
     *            the model object
     * @return {@link ModelAndView} object
     */
    @RequestMapping(value = SpringConstant.REQUEST_LOGOUT)
    public ModelAndView processLogout(Map<String, Object> model) {

        // inserting empty for user,so that it can no more display the username with welcome message
        model.put(SpringConstant.LOGGED_IN_USER, "");
        model.put(SpringConstant.MODEL_NAME_LOGIN, new Login());
        return new ModelAndView(SpringConstant.VIEW_LOGIN_PAGE, model);
    }
}
