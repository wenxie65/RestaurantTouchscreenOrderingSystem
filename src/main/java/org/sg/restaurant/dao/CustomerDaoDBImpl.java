package org.sg.restaurant.dao;

import org.sg.restaurant.dao.mappers.CustomerMapper;
import org.sg.restaurant.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerDaoDBImpl implements CustomerDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDaoDBImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Map<String, Customer> getAllCustomer() throws InvalidSqlStatementException, EntityNotFoundException {
        try {
            final String sql =
                    "SELECT phoneNumber, customerName, customerNotes " +
                    "FROM customer;";

            List<Customer> customerList =  jdbcTemplate.query(
                    sql,
                    new CustomerMapper()
            );

            if (customerList.isEmpty()) {
                throw new EntityNotFoundException(
                        "Empty customer table."
                );
            }

            Map<String, Customer> customerMap = new HashMap<>();
            for (Customer customer : customerList) {
                customerMap.put(customer.getPhoneNumber(), customer);
            }

            return customerMap;
        } catch (BadSqlGrammarException exception) {
            throw new InvalidSqlStatementException(
                    "Invalid SQL statement."
            );
        }
    }

    @Override
    public Customer getCustomerByPhone(String phoneNumber) throws InvalidSqlStatementException, EntityNotFoundException {
        try {
            final String sql =
                    "SELECT phoneNumber, customerName, customerNotes " +
                    "FROM customer " +
                    "WHERE phoneNumber = ?;";

            return jdbcTemplate.queryForObject(
                    sql,
                    new CustomerMapper(),
                    phoneNumber
            );
        } catch (EmptyResultDataAccessException exception) {
            throw new EntityNotFoundException(
                    "Phone Number " + phoneNumber + " not found in customer."
            );
        } catch (BadSqlGrammarException exception) {
            throw new InvalidSqlStatementException(
                    "Invalid SQL statement."
            );
        }
    }

    @Override
    public Customer createCustomer(Customer customer) throws InvalidSqlStatementException {
        try {
            final String sql =
                    "INSERT INTO customer(phoneNumber, customerName, customerNotes) " +
                    "VALUES (?,?,?);";

            jdbcTemplate.update(
                    sql,
                    customer.getPhoneNumber(),
                    customer.getCustomerName(),
                    customer.getCustomerNotes()
            );

            return customer;
        } catch (BadSqlGrammarException exception) {
            throw new InvalidSqlStatementException(
                    "Invalid SQL statement."
            );
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws InvalidSqlStatementException {
        try {
            final String sql =
                    "UPDATE customer SET " +
                    "customerName = ?, " +
                    "customerNotes = ? " +
                    "WHERE phoneNumber = ?;";

            jdbcTemplate.update(
                    sql,
                    customer.getCustomerName(),
                    customer.getCustomerNotes(),
                    customer.getPhoneNumber()
            );
        } catch (BadSqlGrammarException exception) {
            throw new InvalidSqlStatementException(
                    "Invalid SQL statement."
            );
        }

    }

    @Override
    public void deleteCustomer(String phoneNumber) throws InvalidSqlStatementException {
        try {
            final String sql =
                    "DELETE FROM customer " +
                    "WHERE phoneNumber = ?;";

            jdbcTemplate.update(
                    sql,
                    phoneNumber
            );
        } catch (BadSqlGrammarException exception) {
            throw new InvalidSqlStatementException(
                    "Invalid SQL statement."
            );
        }
    }

    @Override
    public Map<String, Customer> getCustomerByHouseId(int houseId) throws InvalidSqlStatementException, EntityNotFoundException {
        try {
            final String sql =
                    "SELECT phoneNumber " +
                    "FROM customer_house " +
                    "WHERE houseId = ?;";

            List<String> phoneNumberList = jdbcTemplate.query(
                    sql,
                    (resultSet, rowNum) -> resultSet.getString("phoneNumber"),
                    houseId);

            if (phoneNumberList.isEmpty()) {
                throw new EntityNotFoundException(
                        "HouseId " + houseId + " not found in customer."
                );
            }

            Map<String, Customer> customerMap = getAllCustomer();

            Map<String, Customer> customerMapByPhone = new HashMap<>();
            for (String phoneNumber : phoneNumberList) {
                customerMapByPhone.put(phoneNumber, customerMap.get(phoneNumber));
            }
            return customerMapByPhone;
        } catch (BadSqlGrammarException exception) {
            throw new InvalidSqlStatementException(
                    "Invalid SQL statement."
            );
        }
    }
}
