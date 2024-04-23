package org.sg.restaurant.dao;

import org.sg.restaurant.dao.mappers.*;
import org.sg.restaurant.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class AddressDaoDBImpl implements AddressDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AddressDaoDBImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Map<Integer, Address> getAllAddress() throws InvalidSqlStatementException, EntityNotFoundException {
        try {
            final String sql =
                    "SELECT h.houseId AS houseId, h.houseNumber AS houseNumber, h.aptNumber AS aptNumber, " +
                            "s.streetName AS streetName, " +
                            "t.townName AS townName, t.zipcode AS zipcode, " +
                            "s.stateAbbrev AS stateAbbrev " +
                    "FROM house h " +
                    "LEFT JOIN street s ON h.streetId = s.streetId " +
                    "LEFT JOIN town t ON s.zipcode = t.zipcode " +
                    "LEFT JOIN state s ON t.stateAbbrev = s.stateAbbrev;";

            List<Address> addressList = jdbcTemplate.query(
                    sql,
                    new AddressMapper()
            );

            if (addressList.isEmpty()) {
                throw new EntityNotFoundException(
                        "Empty address table."
                );
            }

            Map<Integer, Address> addressMap = new HashMap<>();
            for (Address address : addressList) {
                addressMap.put(address.getHouseId(), address);
            }

            return addressMap;
        } catch (BadSqlGrammarException exception) {
            throw new InvalidSqlStatementException(
                    "Invalid SQL statement."
            );
        }
    }

    @Override
    public Address getAddressByHouseId(int houseId) throws InvalidSqlStatementException, EntityNotFoundException {
        try {
            final String sql =
                    "SELECT h.houseId AS houseId, h.houseNumber AS houseNumber, h.aptNumber AS aptNumber, " +
                            "s.streetName AS streetName, " +
                            "t.townName AS townName, t.zipcode AS zipcode, " +
                            "s.stateAbbrev AS stateAbbrev " +
                    "FROM house h " +
                    "LEFT JOIN street s ON h.streetId = s.streetId " +
                    "LEFT JOIN town t ON s.zipcode = t.zipcode " +
                    "LEFT JOIN state s ON t.stateAbbrev = s.stateAbbrev " +
                    "WHERE houseId = ?;";

            return jdbcTemplate.queryForObject(
                    sql,
                    new AddressMapper(),
                    houseId
            );
        } catch (EmptyResultDataAccessException exception) {
            throw new EntityNotFoundException(
                    "HouseId " + houseId + " not found in address."
            );
        } catch (BadSqlGrammarException exception) {
            throw new InvalidSqlStatementException(
                    "Invalid SQL statement."
            );
        }
    }

    @Override
    public Map<Integer, Address> getAddressByPhone(String phoneNumber) throws InvalidSqlStatementException, EntityNotFoundException {
        try {
            final String sql =
                    "SELECT houseId " +
                    "FROM customer_house " +
                    "WHERE phoneNumber = ?;";

            List<Integer> houseIdList = jdbcTemplate.query(
                    sql,
                    (resultSet, rowNum) -> resultSet.getInt("houseId"),
                    phoneNumber);

            if (houseIdList.isEmpty()) {
                throw new EntityNotFoundException(
                        "Phone number " + phoneNumber + " not found in address."
                );
            }

            Map<Integer, Address> addressMap = getAllAddress();

            Map<Integer, Address> addressMapByPhone = new HashMap<>();
            for (Integer houseId : houseIdList) {
                addressMapByPhone.put(houseId, addressMap.get(houseId));
            }

            return addressMapByPhone;
        } catch (BadSqlGrammarException exception) {
            throw new InvalidSqlStatementException(
                    "Invalid SQL statement."
            );
        }
    }

    @Override
    public void addHouseToCustomer(String phoneNumber, int houseId) throws InvalidSqlStatementException {
        try {
            final String sql =
                    "INSERT INTO customer_house(phoneNumber, houseId) " +
                    "VALUES (?,?);";

            jdbcTemplate.update(
                    sql,
                    phoneNumber,
                    houseId
            );
        } catch (BadSqlGrammarException exception) {
            throw new InvalidSqlStatementException(
                    "Invalid SQL statement."
            );
        }
    }

    @Override
    public House createHouse(House house) throws InvalidSqlStatementException {
        try {
            final String sql =
                    "INSERT INTO house(houseNumber, aptNumber, streetId) " +
                    "VALUES (?,?,?);";

            GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update((Connection conn) -> {

                PreparedStatement statement = conn.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS);

                statement.setString(1, house.getHouseNumber());
                statement.setString(2, house.getAptNumber());
                statement.setInt(3, house.getStreetId());
                return statement;

            }, keyHolder);

            house.setHouseId(Objects.requireNonNull(keyHolder.getKey()).intValue());

            return house;
        } catch (BadSqlGrammarException exception) {
            throw new InvalidSqlStatementException(
                    "Invalid SQL statement."
            );
        }
    }

    @Override
    public House getHouseByHouseId(int houseId) throws InvalidSqlStatementException, EntityNotFoundException {
        try {
            final String sql =
                    "SELECT houseId, houseNumber, aptNumber, streetId " +
                    "FROM house " +
                    "WHERE houseId = ?;";

            return jdbcTemplate.queryForObject(
                    sql,
                    new HouseMapper(),
                    houseId
            );
        } catch (EmptyResultDataAccessException exception) {
            throw new EntityNotFoundException(
                    "HouseId " + houseId + " not found in house."
            );
        } catch (BadSqlGrammarException exception) {
            throw new InvalidSqlStatementException(
                    "Invalid SQL statement."
            );
        }
    }

    @Override
    public Street createStreet(Street street) throws InvalidSqlStatementException {
        try {
            final String sql =
                    "INSERT INTO street(streetName, zipcode) " +
                    "VALUES (?,?);";

            GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update((Connection conn) -> {

                PreparedStatement statement = conn.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS);

                statement.setString(1, street.getStreetName());
                statement.setString(2, street.getZipcode());
                return statement;

            }, keyHolder);

            street.setStreetId(Objects.requireNonNull(keyHolder.getKey()).intValue());

            return street;
        } catch (BadSqlGrammarException exception) {
            throw new InvalidSqlStatementException(
                    "Invalid SQL statement."
            );
        }
    }

    @Override
    public Street getStreetByStreetId(int streetId) throws InvalidSqlStatementException, EntityNotFoundException {
        try {
            final String sql =
                    "SELECT streetId, streetName, zipcode " +
                    "FROM street " +
                    "WHERE streetId = ?;";

            return jdbcTemplate.queryForObject(
                    sql,
                    new StreetMapper(),
                    streetId
            );
        } catch (EmptyResultDataAccessException exception) {
            throw new EntityNotFoundException(
                    "StreetId " + streetId + " not found in street."
            );
        } catch (BadSqlGrammarException exception) {
            throw new InvalidSqlStatementException(
                    "Invalid SQL statement."
            );
        }
    }

    @Override
    public Town createTown(Town town) throws InvalidSqlStatementException {
        try {
            final String sql =
                    "INSERT INTO town(zipcode, townName, stateAbbrev) " +
                    "VALUES (?,?,?);";

            jdbcTemplate.update(
                    sql,
                    town.getZipcode(),
                    town.getTownName(),
                    town.getStateAbbrev()
            );

            return town;
        } catch (BadSqlGrammarException exception) {
            throw new InvalidSqlStatementException(
                    "Invalid SQL statement."
            );
        }
    }

    @Override
    public Town getTownByZipcode(String zipcode) throws InvalidSqlStatementException, EntityNotFoundException {
        try {
            final String sql =
                    "SELECT zipcode, townName, stateAbbrev " +
                    "FROM town " +
                    "WHERE zipcode = ?;";

            return jdbcTemplate.queryForObject(
                    sql,
                    new TownMapper(),
                    zipcode
            );
        } catch (EmptyResultDataAccessException exception) {
            throw new EntityNotFoundException(
                    "Zipcode " + zipcode + " not found in town."
            );
        } catch (BadSqlGrammarException exception) {
            throw new InvalidSqlStatementException(
                    "Invalid SQL statement."
            );
        }
    }

    @Override
    public State createState(State state) throws InvalidSqlStatementException {
        try {
            final String sql =
                    "INSERT INTO state(stateAbbrev, stateName) " +
                    "VALUES (?,?);";

            jdbcTemplate.update(
                    sql,
                    state.getStateAbbrev(),
                    state.getStateName()
            );

            return state;
        } catch (BadSqlGrammarException exception) {
            throw new InvalidSqlStatementException(
                    "Invalid SQL statement."
            );
        }
    }

    @Override
    public State getStateByAbbrev(String stateAbbrev) throws InvalidSqlStatementException, EntityNotFoundException {
        try {
            final String sql =
                    "SELECT stateAbbrev, stateName " +
                    "FROM state " +
                    "WHERE stateAbbrev = ?;";

            return jdbcTemplate.queryForObject(
                    sql,
                    new StateMapper(),
                    stateAbbrev
            );
        } catch (EmptyResultDataAccessException exception) {
            throw new EntityNotFoundException(
                    "StateAbbrev " + stateAbbrev + " not found in state."
            );
        } catch (BadSqlGrammarException exception) {
            throw new InvalidSqlStatementException(
                    "Invalid SQL statement."
            );
        }
    }
}
