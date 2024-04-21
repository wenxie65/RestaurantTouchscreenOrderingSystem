package org.sg.restaurant.dao;

import org.sg.restaurant.dao.mappers.CustomerMapper;
import org.sg.restaurant.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CustomerDaoDBImpl implements CustomerDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDaoDBImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Customer> getAllCustomer() throws RestaurantDatabaseException {
        try {
            final String sql =
                    "SELECT phoneNumber, customerName, customerNotes " +
                            "FROM customer;";

            return jdbcTemplate.query(sql, new CustomerMapper());
        } catch (BadSqlGrammarException exception) {
            throw new RestaurantDatabaseException(
                    "Invalid SQL statement."
            );
        }
    }

    @Override
    public Customer getCustomerByPhone(String phoneNumber) throws RestaurantDatabaseException {
        try {
            final String sql =
                    "SELECT phoneNumber, customerName, customerNotes " +
                            "FROM customer " +
                            "WHERE phoneNumber = ?;";

            return jdbcTemplate.queryForObject(sql, new CustomerMapper(), phoneNumber);
        } catch (EmptyResultDataAccessException exception) {
            return null;
        } catch (BadSqlGrammarException exception) {
            throw new RestaurantDatabaseException(
                    "Invalid SQL statement."
            );
        }
    }

    @Override
    public Customer createCustomer(Customer customer) throws RestaurantDatabaseException {
        try {
            final String sql =
                    "INSERT INTO customer(phoneNumber, customerName, customerNotes) " +
                    "VALUES (?,?,?);";

            jdbcTemplate.update(
                    sql,
                    customer.getPhoneNumber(),
                    customer.getName(),
                    customer.getNotes()
            );
            return customer;
        } catch (BadSqlGrammarException exception) {
            throw new RestaurantDatabaseException(
                    "Invalid SQL statement."
            );
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws RestaurantDatabaseException {
        try {
            final String sql =
                    "UPDATE customer SET " +
                    "customerName = ?, " +
                    "customerNotes = ? " +
                    "WHERE phoneNumber = ?;";

            jdbcTemplate.update(
                    sql,
                    customer.getName(),
                    customer.getNotes(),
                    customer.getPhoneNumber()
            );
        } catch (BadSqlGrammarException exception) {
            throw new RestaurantDatabaseException(
                    "Invalid SQL statement."
            );
        }

    }

    @Override
    public void deleteCustomer(String phoneNumber) throws RestaurantDatabaseException {
        try {
            final String sql =
                    "DELETE FROM customer " +
                    "WHERE phoneNumber = ?;";

            jdbcTemplate.update(sql, phoneNumber);
        } catch (BadSqlGrammarException exception) {
            throw new RestaurantDatabaseException(
                    "Invalid SQL statement."
            );
        }
    }
}
