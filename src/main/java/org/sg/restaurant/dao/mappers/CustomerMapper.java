package org.sg.restaurant.dao.mappers;

import org.sg.restaurant.dto.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
        Customer customer = new Customer();

        customer.setPhoneNumber(resultSet.getString("phoneNumber"));
        customer.setCustomerName(resultSet.getString("customerName"));
        customer.setCustomerNotes(resultSet.getString("customerNotes"));

        return customer;
    }
}
