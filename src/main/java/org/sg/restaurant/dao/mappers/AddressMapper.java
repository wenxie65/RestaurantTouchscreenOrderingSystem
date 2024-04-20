package org.sg.restaurant.dao.mappers;

import org.sg.restaurant.dto.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements RowMapper<Address> {

    @Override
    public Address mapRow(ResultSet resultSet, int i) throws SQLException {
        Address address = new Address();

        address.setAddressId(resultSet.getInt("addressId"));
        address.setHouseNumber(resultSet.getString("houseNumber"));
        address.setAptNumber(resultSet.getString("aptNumber"));
        address.setStreetName(resultSet.getString("streetName"));
        address.setTownName(resultSet.getString("townName"));
        address.setZipcode(resultSet.getString("zipcode"));
        address.setStateAbbrev(resultSet.getString("state"));

        return address;
    }
}
