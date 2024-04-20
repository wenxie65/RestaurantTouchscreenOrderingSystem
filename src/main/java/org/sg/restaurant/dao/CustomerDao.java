package org.sg.restaurant.dao;

import org.sg.restaurant.dto.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getAllCustomer() throws RestaurantDatabaseException;

    Customer getCustomerByPhone(String phoneNumber) throws RestaurantDatabaseException;

    Customer createCustomer(Customer customer) throws RestaurantDatabaseException;

    void updateCustomer(Customer customer) throws RestaurantDatabaseException;

    void deleteCustomer(String phoneNumber) throws RestaurantDatabaseException;
}
