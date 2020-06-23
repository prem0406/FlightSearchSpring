/**
 * 
 */
package com.nagarro.flightsearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.flightsearch.dao.api.LoginDao;
import com.nagarro.flightsearch.model.Login;
import com.nagarro.flightsearch.service.api.LoginService;

/**
 * The Class {@link LoginServiceImpl} cab be used to perform operations related to databases such as add, delete, list
 * all records.
 * 
 * @author Rahul Bokolia
 * 
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void addLoginEntry(Login login) {
        loginDao.addLoginEntry(login);

    }

    @Override
    @Transactional
    public List<Login> listLoginEntries() {
        return loginDao.listLoginEntries();
    }

    @Override
    @Transactional
    public Login getLoginEntry(String username) {
        return loginDao.getLoginEntry(username);
    }

    @Override
    @Transactional
    public void deleteLoginEntry(Login login) {
        loginDao.deleteLoginEntry(login);
    }

}
