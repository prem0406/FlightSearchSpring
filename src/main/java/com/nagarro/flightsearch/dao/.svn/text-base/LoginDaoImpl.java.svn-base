/**
 * 
 */
package com.nagarro.flightsearch.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.flightsearch.common.constant.Constant;
import com.nagarro.flightsearch.dao.api.LoginDao;
import com.nagarro.flightsearch.model.Login;
import com.nagarro.flightsearch.service.LoginServiceImpl;

/**
 * The class {@link LoginDaoImpl} provides implementation for the {@link LoginDao} methods. <br>
 * This class performs the actual interaction with the data source. <br>
 * <br>
 * The user of the application should not directly use this class,instead use {@link LoginServiceImpl} class for
 * performing data store operations.
 * 
 * @author Rahul Bokolia
 * @since 1.0
 */

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

    // log4j logger
    private static final Logger LOGGER = Logger.getLogger(LoginDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addLoginEntry(Login login) {
        getCurrentSession().save(login);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Login getLoginEntry(String username) {
        Login loginEntry = null;
        List<Login> list = sessionFactory.getCurrentSession()
                .createQuery("from Login where username= '" + username + "'").list();
        try {
            loginEntry = (Login) list.get(0);
        } catch (IndexOutOfBoundsException e) {
            loginEntry = null;
            LOGGER.error("No user found for username " + username, e);
        }
        return loginEntry;
    }

    @Override
    public void deleteLoginEntry(Login login) {
        getCurrentSession().delete(login);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Login> listLoginEntries() {
        List<Login> list = null;
        list = getCurrentSession().createQuery(Constant.QUERY_SELECT_ALL).list();
        return list;
    }
}
