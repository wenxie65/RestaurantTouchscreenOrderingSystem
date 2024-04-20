package org.sg.restaurant.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sg.restaurant.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
class CustomerDaoDBImplTest {

    private final JdbcTemplate jdbcTemplate;
    private final CustomerDao customerDao;

    @Autowired
    public CustomerDaoDBImplTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        customerDao = new CustomerDaoDBImpl(jdbcTemplate);
    }

    @Test
    @DisplayName("Get All Test")
    @Transactional
    public void getAllCustomerTest() {
        List<Customer> customerList = customerDao.getAllCustomer();

        assertNotNull(customerList);
    }

    @Test
    @DisplayName("Create and Get All Test")
    @Transactional
    public void createAndGetAllCustomerTest() {
        List<Customer> customerList = customerDao.getAllCustomer();
        int initialSize = customerList.size();

        Customer customer1 = new Customer();
        customer1.setPhoneNumber("1111111111");
        customer1.setName("Customer One");
        customer1.setNotes("Notes");
        customerDao.createCustomer(customer1);

        Customer customer2 = new Customer();
        customer2.setPhoneNumber("2222222222");
        customerDao.createCustomer(customer2);

        customerList = customerDao.getAllCustomer();

        assertNotNull(customerList);
        assertEquals(initialSize + 2, customerList.size());
    }

    @Test
    @DisplayName("Create and Get By Phone Test")
    @Transactional
    public void createAndGetByPhoneCustomerTest() {
        Customer customer1 = new Customer();
        customer1.setPhoneNumber("1111111111");
        customer1.setName("Customer One");
        customer1.setNotes("Notes");
        customerDao.createCustomer(customer1);

        Customer retrievedCustomer = customerDao.getCustomerByPhone(customer1.getPhoneNumber());

        assertNotNull(retrievedCustomer);
        assertEquals(customer1, retrievedCustomer);

        String invalidPhoneNumber = "2222222222";
        retrievedCustomer = customerDao.getCustomerByPhone(invalidPhoneNumber);

        assertNull(retrievedCustomer);
    }

    @Test
    @DisplayName("Create, Update and Get By Phone Test")
    @Transactional
    public void createUpdateAndGetByPhoneCustomerTest() {
        Customer customer1 = new Customer();
        customer1.setPhoneNumber("1111111111");
        customer1.setName("Customer One");
        customer1.setNotes("Notes");
        customerDao.createCustomer(customer1);

        customer1.setName("New Name");
        customer1.setNotes("Updated Notes");
        customerDao.updateCustomer(customer1);

        Customer retrievedCustomer = customerDao.getCustomerByPhone(customer1.getPhoneNumber());

        assertNotNull(retrievedCustomer);
        assertEquals(customer1, retrievedCustomer);
        assertEquals("New Name", retrievedCustomer.getName());
        assertEquals("Updated Notes", retrievedCustomer.getNotes());
    }

    @Test
    @DisplayName("Create, Update and Get All Test")
    @Transactional
    public void createUpdateAndGetAllCustomerTest() {
        List<Customer> customerList = customerDao.getAllCustomer();
        int initialSize = customerList.size();

        Customer customer1 = new Customer();
        customer1.setPhoneNumber("1111111111");
        customer1.setName("Customer One");
        customer1.setNotes("Notes");
        customerDao.createCustomer(customer1);

        customer1.setName("New Name");
        customer1.setNotes("Updated Notes");
        customerDao.updateCustomer(customer1);

        customerList = customerDao.getAllCustomer();

        assertNotNull(customerList);
        assertEquals(initialSize + 1, customerList.size());
    }

    @Test
    @DisplayName("Create, Delete and Get By Phone Test")
    @Transactional
    public void createDeleteAndGetByPhoneCustomerTest() {
        Customer customer1 = new Customer();
        customer1.setPhoneNumber("1111111111");
        customer1.setName("Customer One");
        customer1.setNotes("Notes");
        customerDao.createCustomer(customer1);

        Customer retrievedCustomer = customerDao.getCustomerByPhone(customer1.getPhoneNumber());

        assertNotNull(retrievedCustomer);
        assertEquals(customer1, retrievedCustomer);

        customerDao.deleteCustomer(customer1.getPhoneNumber());
        retrievedCustomer = customerDao.getCustomerByPhone(customer1.getPhoneNumber());

        assertNull(retrievedCustomer);
    }

    @Test
    @DisplayName("Create, Delete and Get All Test")
    @Transactional
    public void createDeleteAndGetAllCustomerTest() {
        List<Customer> customerList = customerDao.getAllCustomer();
        int initialSize = customerList.size();

        Customer customer1 = new Customer();
        customer1.setPhoneNumber("1111111111");
        customer1.setName("Customer One");
        customer1.setNotes("Notes");
        customerDao.createCustomer(customer1);

        customerList = customerDao.getAllCustomer();

        assertNotNull(customerList);
        assertEquals(initialSize + 1, customerList.size());

        customerDao.deleteCustomer(customer1.getPhoneNumber());
        customerList = customerDao.getAllCustomer();

        assertNotNull(customerList);
        assertEquals(initialSize, customerList.size());
    }

}