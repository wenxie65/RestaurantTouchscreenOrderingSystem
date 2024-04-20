package org.sg.restaurant.dao;

import org.sg.restaurant.dto.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getAllCustomer();

    Customer getCustomerByPhone(String phoneNumber);

    Customer createCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(String phoneNumber);
}
