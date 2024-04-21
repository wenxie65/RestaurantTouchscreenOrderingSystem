package org.sg.restaurant.dao.mappers;

import org.sg.restaurant.dto.House;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseMapper implements RowMapper<House> {

    @Override
    public House mapRow(ResultSet resultSet, int i) throws SQLException {
        House house = new House();

        house.setHouseId(resultSet.getInt("houseId"));
        house.setHouseNumber(resultSet.getString("houseNumber"));
        house.setAptNumber(resultSet.getString("aptNumber"));
        house.setStreetId(resultSet.getInt("streetId"));;

        return house;
    }
}
