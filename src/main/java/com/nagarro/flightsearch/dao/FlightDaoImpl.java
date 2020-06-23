/**
 * 
 */
package com.nagarro.flightsearch.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.flightsearch.common.constant.Constant;
import com.nagarro.flightsearch.dao.api.FlightDao;
import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.FlightSearchParameters;
import com.nagarro.flightsearch.service.FlightServiceImpl;
import com.nagarro.flightsearch.util.StringUtil;

/**
 * The class {@link FlightDaoImpl} provides the actual implementation of the operations that interacts with data store. <br>
 * <br>
 * The user of the application should not directly use this class,instead use {@link FlightServiceImpl} class for
 * performing data store operations.
 * 
 * 
 * @author Rahul Bokolia
 * @see FlightServiceImpl
 * @since 1.0
 */
@Repository
public class FlightDaoImpl implements FlightDao {

    // used to provide sessions for the operation
    @Autowired
    private SessionFactory sessionFactory;

    // returns the current available session
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(Flight flight) {
        getCurrentSession().save(flight);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Flight> retrieve(FlightSearchParameters searchParameters) {
        List<Flight> list = null;

        Criteria criteria = createCriteriaForSearch(searchParameters);
        list = criteria.list();

        return list;
    }

    private Criteria createCriteriaForSearch(FlightSearchParameters parameter) {
        Criteria searchCriteria = null;
        String flightClass = null;
        String sortPreference = null;

        // equal to %e% for economic class,this means if the flight class contains e then include it
        flightClass = StringUtil.concatenate("%", parameter.getFlightClass(), "%");

        searchCriteria = getCurrentSession().createCriteria(Flight.class);
        Criterion depLocCriteria = Restrictions.eq(Constant.FIELD_DEPARTURE_LOCATION, parameter.getDepartureLocation());
        Criterion arrLocCriteria = Restrictions.eq(Constant.FIELD_ARRIVAL_LOCATION, parameter.getArrivalLocation());
        Criterion validTillCriteria = Restrictions.ge(Constant.FIELD_VALID_TILL, parameter.getFlightDate());
        Criterion flightClassCriteria = Restrictions.like(Constant.FIELD_FLIGHT_CLASS, flightClass);

        // include all the above criterias
        Conjunction andExpr = Restrictions.and(depLocCriteria, arrLocCriteria, flightClassCriteria, validTillCriteria);
        searchCriteria.add(andExpr);

        sortPreference = parameter.getOutputPreference();
        addSortToCriteria(searchCriteria, sortPreference);

        return searchCriteria;
    }

    private void addSortToCriteria(Criteria searchCriteria, String outputPreference) {

        if (Constant.SORT_BY_FARE.equalsIgnoreCase(outputPreference)) {
            searchCriteria.addOrder(Order.asc(Constant.FIELD_FARE));
        } else {
            searchCriteria.addOrder(Order.asc(Constant.FIELD_FLIGHT_DURATION));
            searchCriteria.addOrder(Order.asc(Constant.FIELD_FARE));
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Flight> getFlights() {
        List<Flight> list = null;
        list = getCurrentSession().createQuery(Constant.QUERY_SELECT_ALL).list();
        return list;
    }

    @Override
    public void delete(Flight flight) {
        getCurrentSession().delete(flight);
    }

}
