package org.sg.restaurant.service;

import org.sg.restaurant.dto.Customer;

import java.util.Map;

public interface CustomerService {

    Map<String, Customer> getAllCustomer();

    Customer getCustomerByPhone(String phoneNumber);

    Customer addNewCustomer(Customer customer);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomer(String phoneNumber);

    Map<String, Customer> getCustomerByHouseId(int houseId);

}
