package org.sg.restaurant.dao;

import org.sg.restaurant.dto.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDaoDBImpl implements AddressDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AddressDaoDBImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Address> getAllAddress() {
        return null;
    }

    @Override
    public Address getAddressById(int addressId) {
        return null;
    }

    @Override
    public List<Address> getAddressByPhone(String phoneNumber) {
        return null;
    }

    @Override
    public Address createAddress(Address address) {
        return null;
    }

    @Override
    public void addAddressToCustomer(String phoneNumber, int addressId) {

    }

    @Override
    public void updateAddress(Address address) {

    }

    @Override
    public void deleteAddress(int addressId) {

    }
}
