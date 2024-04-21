package org.sg.restaurant.dao.mappers;

import org.sg.restaurant.dto.State;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StateMapper implements RowMapper<State> {

    @Override
    public State mapRow(ResultSet resultSet, int i) throws SQLException {
        State state = new State();

        state.setStateAbbrev(resultSet.getString("stateAbbrev"));
        state.setStateName(resultSet.getString("stateName"));

        return state;
    }
}
