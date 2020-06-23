/**
 * 
 */
package com.nagarro.flightsearch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * The class {@link Login} is a model class.<br>
 * This class is a POJO class that models user's login credentials.
 * 
 * @author Rahul Bokolia
 * @since 1.0
 */
@Entity
@Table(name = "login", catalog = "flight_search_spring")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "username", unique = true, nullable = false)
    @NotEmpty
    private String username;

    @Column(name = "password", unique = true, nullable = false)
    @NotEmpty
    private String password;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
