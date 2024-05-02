package org.sg.restaurant.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sg.restaurant.dao.CustomerDao;
import org.sg.restaurant.dao.CustomerDaoStubImpl;
import org.sg.restaurant.dto.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {

    private final CustomerService customerService;

    public CustomerServiceImplTest() {
        CustomerDao customerDao = new CustomerDaoStubImpl();
        customerService = new CustomerServiceImpl(customerDao);
    }

    @Test
    @DisplayName("Get Customer By Valid Phone Number Service Test")
    public void getValidCustomerServiceTest() {
        Customer retrievedCustomer = customerService.getCustomerByPhone("1111111111");

        assertNotNull(retrievedCustomer);
        assertEquals("Customer One", retrievedCustomer.getCustomerName());
    }

    @Test
    @DisplayName("Get Customer By Invalid Phone Number Service Test")
    public void getInvalidCustomerServiceTest() {
        Customer retrievedCustomer = customerService.getCustomerByPhone("9999999999");

        assertNotNull(retrievedCustomer);
        assertEquals("Phone Number 9999999999 not found in customer.", retrievedCustomer.getCustomerName());
    }

    @Test
    @DisplayName("Updated Customer With Valid Phone Number Service Test")
    public void updateValidCustomerServiceTest() {
        Customer updatedCustomer = new Customer();
        updatedCustomer.setPhoneNumber("1111111111");
        updatedCustomer.setCustomerName("Updated Name");
        updatedCustomer.setCustomerNotes("Updated Notes");
        boolean updated = customerService.updateCustomer(updatedCustomer);

        assertTrue(updated);

        Customer retrievedCustomer = customerService.getCustomerByPhone("1111111111");

        assertNotNull(retrievedCustomer);
        assertEquals("Updated Name", retrievedCustomer.getCustomerName());
        assertEquals("Updated Notes", retrievedCustomer.getCustomerNotes());
    }

    @Test
    @DisplayName("Updated Customer With Invalid Phone Number Service Test")
    public void updateInvalidCustomerServiceTest() {
        Customer updatedCustomer = new Customer();
        updatedCustomer.setPhoneNumber("9999999999");
        updatedCustomer.setCustomerName("Updated Name");
        updatedCustomer.setCustomerNotes("Updated Notes");
        boolean updated = customerService.updateCustomer(updatedCustomer);

        assertFalse(updated);
    }

}