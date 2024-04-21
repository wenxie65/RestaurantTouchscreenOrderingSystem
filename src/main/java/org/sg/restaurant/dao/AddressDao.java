package org.sg.restaurant.dao;

import org.sg.restaurant.dto.Address;
import org.sg.restaurant.dto.House;
import org.sg.restaurant.dto.State;
import org.sg.restaurant.dto.Street;
import org.sg.restaurant.dto.Town;

import java.util.Map;

public interface AddressDao {

    Map<Integer, Address> getAllAddress() throws InvalidSqlStatementException;

    Address getAddressByHouseId(int houseId) throws InvalidSqlStatementException;

    Map<Integer, Address> getAddressByPhone(String phoneNumber) throws InvalidSqlStatementException;

    void addHouseToCustomer(String phoneNumber, int houseId) throws InvalidSqlStatementException;

    House createHouse(House house) throws InvalidSqlStatementException;

    House getHouseByHouseId(int houseId) throws InvalidSqlStatementException, EntityNotFoundException;

    Street createStreet(Street street) throws InvalidSqlStatementException;

    Street getStreetByStreetId(int streetId) throws InvalidSqlStatementException, EntityNotFoundException;

    Town createTown(Town town) throws InvalidSqlStatementException;

    Town getTownByZipcode(String zipcode) throws InvalidSqlStatementException, EntityNotFoundException;

    State createState(State state) throws InvalidSqlStatementException;

    State getStateByAbbrev(String stateAbbrev) throws InvalidSqlStatementException, EntityNotFoundException;
}
