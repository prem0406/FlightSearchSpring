/**
 * 
 */
package com.nagarro.flightsearch.common.exception;

/**
 * The class {@link InvalidArgumentException} can be used to handle the arguments that are important for the application
 * but provided null.
 * 
 * It is a {@link RuntimeException} thus extra care is needed to handle.
 * 
 * @author Rahul Bokolia
 * 
 */
public class InvalidArgumentException extends RuntimeException {

    private static final long serialVersionUID = -5888253671856344154L;

    /**
     * Constructs a new InvalidArgumentException with {@code null} as its detail message. .
     */
    public InvalidArgumentException() {
        super();
    }

    /**
     * Constructs a new InvalidArgumentException with message as its detail message.
     * 
     * @param message
     *            the detail message. The detail message is saved for later retrieval by the {@link #getMessage()}
     *            method.
     */
    public InvalidArgumentException(String message) {
        super(message);
    }

    /**
     * Constructs a new InvalidArgumentException with the specified cause and a detail message of
     * <tt>(cause==null ? null : cause.toString())</tt> (which typically contains the class and detail message of
     * <tt>cause</tt>). This constructor is useful for runtime exceptions that are little more than wrappers for other
     * throwables.
     * 
     * @param cause
     *            the cause (which is saved for later retrieval by the {@link #getCause()} method). (A <tt>null</tt>
     *            value is permitted, and indicates that the cause is nonexistent or unknown.)
     * 
     */
    public InvalidArgumentException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new InvalidArgumentException with the specified detail message, cause.
     * 
     * @param message
     *            the detail message.
     * @param cause
     *            the cause. (A {@code null} value is permitted, and indicates that the cause is nonexistent or
     *            unknown.)
     * 
     * 
     */
    public InvalidArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

}
