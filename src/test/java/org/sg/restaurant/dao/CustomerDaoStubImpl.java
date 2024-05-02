package org.sg.restaurant.dao;

import org.sg.restaurant.dto.Customer;

import java.util.Map;

public class CustomerDaoStubImpl implements CustomerDao {

    Customer onlyCustomer;

    public CustomerDaoStubImpl() {
        onlyCustomer = new Customer();
        onlyCustomer.setPhoneNumber("1111111111");
        onlyCustomer.setCustomerName("Customer One");
        onlyCustomer.setCustomerNotes("Notes");
    }

    @Override
    public Map<String, Customer> getAllCustomer() throws InvalidSqlStatementException, EntityNotFoundException {
        //Pass through method no tests
        return null;
    }

    @Override
    public Customer getCustomerByPhone(String phoneNumber) throws InvalidSqlStatementException, EntityNotFoundException {
        if (!onlyCustomer.getPhoneNumber().equals(phoneNumber)) {
            throw new EntityNotFoundException(
                    "Phone Number " + phoneNumber + " not found in customer."
            );
        }
        return onlyCustomer;
    }

    @Override
    public Customer createCustomer(Customer customer) throws InvalidSqlStatementException {
        //Pass through method no tests
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) throws InvalidSqlStatementException, EntityNotFoundException {
        if (!customer.getPhoneNumber().equals(onlyCustomer.getPhoneNumber())) {
            throw new EntityNotFoundException(
                    "Phone Number " + customer.getPhoneNumber() + " not found in customer."
            );
        }
        onlyCustomer.setPhoneNumber(customer.getPhoneNumber());
        onlyCustomer.setCustomerName(customer.getCustomerName());
        onlyCustomer.setCustomerNotes(customer.getCustomerNotes());
    }

    @Override
    public void deleteCustomer(String phoneNumber) throws InvalidSqlStatementException {
        //Pass through method no tests
    }

    @Override
    public Map<String, Customer> getCustomerByHouseId(int houseId) throws InvalidSqlStatementException, EntityNotFoundException {
        //Pass through method no tests
        return null;
    }
}
