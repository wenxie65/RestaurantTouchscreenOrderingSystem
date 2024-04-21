package org.sg.restaurant.dao.mappers;

import org.sg.restaurant.dto.Street;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StreetMapper implements RowMapper<Street> {

    @Override
    public Street mapRow(ResultSet resultSet, int i) throws SQLException {
        Street street = new Street();

        street.setStreetId(resultSet.getInt("streetId"));
        street.setStreetName(resultSet.getString("streetName"));
        street.setZipcode(resultSet.getString("zipcode"));

        return street;
    }
}
