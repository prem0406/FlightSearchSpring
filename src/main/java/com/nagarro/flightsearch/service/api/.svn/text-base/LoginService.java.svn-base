/**
 * 
 */
package com.nagarro.flightsearch.service.api;

import java.util.List;

import com.nagarro.flightsearch.model.Login;

/**
 * The class {@link LoginService} is a service class.<br>
 * This class provides the database related services.
 * 
 * @author Rahul Bokolia
 * @since 1.0
 * 
 */
public interface LoginService {
    /**
     * adds an {@link Login} login detail to the data store.
     * 
     * @param login
     *            the login to add
     * 
     */
    void addLoginEntry(Login login);

    /**
     * deletes the login entry for the specified login object from the data store.<br>
     * <br>
     * <i>Caution:</i> It can return <code>null</code> if the provided login object does not match with the data store
     * values is not found.
     * 
     * @param login
     *            the login object to delete
     */
    void deleteLoginEntry(Login login);

    /**
     * returns all login details stored in the data store.
     * 
     * @return List of type {@link Login}.<i>Caution:</i> It can return <code>null</code> if no records found
     */

    List<Login> listLoginEntries();

    /**
     * gets the login details for the user with the specified username. <br>
     * <br>
     * <i>Caution:</i> It can return <code>null</code> if no records found
     * 
     * <br>
     * <br>
     * This can also be used to check that if a user exists or not, if a valid {@link Login} entry returns that means
     * this user exists.If this function returns <code>null</code>, that means the user with this username does not
     * exists.
     * 
     * @param username
     *            the username of the user
     * @return an object of type {@link Login} with the the login details of the provided username
     */
    Login getLoginEntry(String username);

}
