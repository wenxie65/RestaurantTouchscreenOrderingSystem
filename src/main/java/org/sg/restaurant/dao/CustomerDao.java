package org.sg.restaurant.dao;

import org.sg.restaurant.dto.Customer;

import java.util.Map;

public interface CustomerDao {

    Map<String, Customer> getAllCustomer() throws InvalidSqlStatementException, EntityNotFoundException;

    Customer getCustomerByPhone(String phoneNumber) throws InvalidSqlStatementException, EntityNotFoundException;

    Customer createCustomer(Customer customer) throws InvalidSqlStatementException;

    void updateCustomer(Customer customer) throws InvalidSqlStatementException, EntityNotFoundException;

    void deleteCustomer(String phoneNumber) throws InvalidSqlStatementException, EntityNotFoundException;

    Map<String, Customer> getCustomerByHouseId(int houseId) throws InvalidSqlStatementException, EntityNotFoundException;
}
