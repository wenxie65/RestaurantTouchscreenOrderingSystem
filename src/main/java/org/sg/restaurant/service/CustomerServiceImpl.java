package org.sg.restaurant.service;

import org.sg.restaurant.dao.CustomerDao;
import org.sg.restaurant.dao.EntityNotFoundException;
import org.sg.restaurant.dao.InvalidSqlStatementException;
import org.sg.restaurant.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Map<String, Customer> getAllCustomer() {
        try {
            return customerDao.getAllCustomer();
        } catch (InvalidSqlStatementException | EntityNotFoundException exception) {
            return new HashMap<>();
        }
    }

    @Override
    public Customer getCustomerByPhone(String phoneNumber) {
        try {
            return customerDao.getCustomerByPhone(phoneNumber);
        } catch (InvalidSqlStatementException | EntityNotFoundException exception) {
            Customer exceptionCustomer = new Customer();
            exceptionCustomer.setCustomerName(exception.getMessage());
            return exceptionCustomer;
        }
    }

    @Override
    public Customer addNewCustomer(Customer customer) {
        try {
            return customerDao.createCustomer(customer);
        } catch (InvalidSqlStatementException exception) {
            Customer exceptionCustomer = new Customer();
            exceptionCustomer.setCustomerName(exception.getMessage());
            return exceptionCustomer;
        }
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        try {
            customerDao.updateCustomer(customer);
            return true;
        } catch (InvalidSqlStatementException | EntityNotFoundException exception) {
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(String phoneNumber) {
        try {
            customerDao.deleteCustomer(phoneNumber);
            return true;
        } catch (InvalidSqlStatementException | EntityNotFoundException exception) {
            return false;
        }
    }

    @Override
    public Map<String, Customer> getCustomerByHouseId(int houseId) {
        try {
            return customerDao.getCustomerByHouseId(houseId);
        } catch (InvalidSqlStatementException | EntityNotFoundException exception) {
            return new HashMap<>();
        }
    }
}
