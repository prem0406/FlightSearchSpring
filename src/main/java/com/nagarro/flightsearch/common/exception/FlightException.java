/**
 * 
 */
package com.nagarro.flightsearch.common.exception;

/**
 * Parent class for all the exceptions related to flight search. The class FlightException and its subclasses are a form
 * of Exception that indicates conditions that a reasonable application might want to catch.
 * 
 * @author Rahul Bokolia
 * @version 1.0
 */
public class FlightException extends Exception {

    private final String message;

    private static final long serialVersionUID = 5426440286237360960L;

    public FlightException() {
        this.message = null;
    }

    /**
     * Constructs a new {@link FlightException} with the specified detail message, cause.
     * 
     * @param message
     *            the detail message.
     * @param cause
     *            the cause. (A {@code null} value is permitted, and indicates that the cause is nonexistent or
     *            unknown.)
     * 
     * 
     */
    public FlightException(String message, Exception exception) {
        super(exception);
        this.message = message;
    }

    /**
     * Constructs a new {@link FlightException} with message as its detail message.
     * 
     * @param message
     *            the detail message. The detail message is saved for later retrieval by the {@link #getMessage()}
     *            method.
     */
    public FlightException(String message) {
        this.message = message;

    }

    /**
     * Constructs a new {@link FlightException} with the specified cause and a detail message of
     * <tt>(cause==null ? null : cause.toString())</tt> (which typically contains the class and detail message of
     * <tt>cause</tt>).
     * 
     * @param cause
     *            the cause (A <tt>null</tt> value is permitted, and indicates that the cause is nonexistent or
     *            unknown.)
     * 
     */
    public FlightException(Exception cause) {
        super(cause);
        this.message = null;
    }

    public String getMessage() {
        return message;
    }

}
