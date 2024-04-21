package org.sg.restaurant.dao.mappers;

import org.sg.restaurant.dto.Town;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TownMapper implements RowMapper<Town> {

    @Override
    public Town mapRow(ResultSet resultSet, int i) throws SQLException {
        Town town = new Town();

        town.setZipcode(resultSet.getString("zipcode"));
        town.setTownName(resultSet.getString("townName"));
        town.setStateAbbrev(resultSet.getString("stateAbbrev"));

        return town;
    }
}
