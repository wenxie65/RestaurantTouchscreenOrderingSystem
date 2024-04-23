package org.sg.restaurant.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sg.restaurant.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
class CustomerDaoDBImplTest {

    private final CustomerDao customerDao;

    @Autowired
    public CustomerDaoDBImplTest(JdbcTemplate jdbcTemplate) {
        customerDao = new CustomerDaoDBImpl(jdbcTemplate);
    }

    @Test
    @DisplayName("Valid Input Test")
    @Transactional
    public void validTest() {
        Map<String, Customer> customerMap;
        int initialSize = 0;

        try {
            customerMap = customerDao.getAllCustomer();
            initialSize = customerMap.size();
        } catch (EntityNotFoundException ignored) {

        } catch (Exception exception) {
            fail("No other exception should be thrown.");
        }


        try {
            // Create and get all customer test
            Customer customer1 = new Customer();
            customer1.setPhoneNumber("1111111111");
            customer1.setCustomerName("Customer One");
            customer1.setCustomerNotes("Notes");
            customer1 = customerDao.createCustomer(customer1);

            Customer customer2 = new Customer();
            customer2.setPhoneNumber("2222222222");
            customer2.setCustomerName("Customer Two");
            customer2 = customerDao.createCustomer(customer2);

            customerMap = customerDao.getAllCustomer();

            assertNotNull(customerMap);
            assertEquals(initialSize + 2, customerMap.size());


            // Get customer by phone number test
            Customer retrievedCustomer = customerDao.getCustomerByPhone(customer1.getPhoneNumber());

            assertNotNull(retrievedCustomer);
            assertEquals(customer1, retrievedCustomer);


            retrievedCustomer = customerDao.getCustomerByPhone(customer2.getPhoneNumber());

            assertNotNull(retrievedCustomer);
            assertEquals(customer2, retrievedCustomer);


            // Update customer test
            Customer updatedCustomer = new Customer();
            updatedCustomer.setPhoneNumber(customer1.getPhoneNumber());
            updatedCustomer.setCustomerName("New Name");
            updatedCustomer.setCustomerNotes("Updated Notes");
            customerDao.updateCustomer(updatedCustomer);

            retrievedCustomer = customerDao.getCustomerByPhone(customer1.getPhoneNumber());

            assertNotNull(retrievedCustomer);
            assertNotEquals(customer1, retrievedCustomer);
            assertEquals(updatedCustomer, retrievedCustomer);


            // Delete customer test
            customerDao.deleteCustomer(customer1.getPhoneNumber());

            assertEquals(initialSize + 1, customerDao.getAllCustomer().size());
        } catch (Exception exception) {
            fail("No exception should be thrown.");
        }
    }

}