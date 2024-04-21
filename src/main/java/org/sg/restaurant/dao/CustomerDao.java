package org.sg.restaurant.dao;

import org.sg.restaurant.dto.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getAllCustomer() throws InvalidSqlStatementException;

    Customer getCustomerByPhone(String phoneNumber) throws InvalidSqlStatementException, EntityNotFoundException;

    Customer createCustomer(Customer customer) throws InvalidSqlStatementException;

    void updateCustomer(Customer customer) throws InvalidSqlStatementException;

    void deleteCustomer(String phoneNumber) throws InvalidSqlStatementException;
}
