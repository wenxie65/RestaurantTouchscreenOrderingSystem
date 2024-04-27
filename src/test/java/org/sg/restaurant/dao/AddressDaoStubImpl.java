package org.sg.restaurant.dao;

import org.sg.restaurant.dto.*;

import java.util.HashMap;
import java.util.Map;

public class AddressDaoStubImpl implements AddressDao {

    public State onlyState;
    public Town onlyTown;
    public Street onlyStreet;
    public House onlyHouse;
    public Address onlyAddress;

    public AddressDaoStubImpl() {
        onlyState = new State();
        onlyState.setStateAbbrev("NS");
        onlyState.setStateName("New State");

        onlyTown = new Town();
        onlyTown.setZipcode("00000");
        onlyTown.setTownName("New Town");
        onlyTown.setStateAbbrev(onlyTown.getStateAbbrev());

        onlyStreet = new Street();
        onlyStreet.setStreetId(1);
        onlyStreet.setStreetName("New St");
        onlyStreet.setZipcode(onlyStreet.getZipcode());

        onlyHouse = new House();
        onlyHouse.setHouseId(1);
        onlyHouse.setHouseNumber("1234");
        onlyHouse.setAptNumber("A");
        onlyHouse.setStreetId(onlyHouse.getStreetId());

        onlyAddress = new Address();
        onlyAddress.setHouseId(onlyHouse.getHouseId());
        onlyAddress.setHouseNumber(onlyHouse.getHouseNumber());
        onlyAddress.setAptNumber(onlyHouse.getAptNumber());
        onlyAddress.setStreetName(onlyStreet.getStreetName());
        onlyAddress.setZipcode(onlyTown.getZipcode());
        onlyAddress.setTownName(onlyTown.getTownName());
        onlyAddress.setStateAbbrev(onlyState.getStateAbbrev());
    }

    @Override
    public Map<Integer, Address> getAllAddress() throws InvalidSqlStatementException, EntityNotFoundException {
        //Pass through method no tests
        return null;
    }

    @Override
    public Address getAddressByHouseId(int houseId) throws InvalidSqlStatementException, EntityNotFoundException {
        if (onlyAddress.getHouseId() != houseId) {
            throw new EntityNotFoundException(
                    "HouseId " + houseId + " not found in address."
            );
        }
        return onlyAddress;
    }

    @Override
    public Map<Integer, Address> getAddressByPhone(String phoneNumber) throws InvalidSqlStatementException, EntityNotFoundException {
        //Pass through method no tests
        return null;
    }

    @Override
    public void addHouseToCustomer(String phoneNumber, int houseId) throws InvalidSqlStatementException {
        //Pass through method no tests
    }

    @Override
    public House createHouse(House house) throws InvalidSqlStatementException {
        //Pass through method no tests
        return null;
    }

    @Override
    public House getHouseByHouseId(int houseId) throws InvalidSqlStatementException, EntityNotFoundException {
        if (onlyHouse.getHouseId() != houseId) {
            throw new EntityNotFoundException(
                    "HouseId " + houseId + " not found in house."
            );
        }
        return onlyHouse;
    }

    @Override
    public Street createStreet(Street street) throws InvalidSqlStatementException {
        //Pass through method no tests
        return null;
    }

    @Override
    public Street getStreetByStreetId(int streetId) throws InvalidSqlStatementException, EntityNotFoundException {
        if (onlyStreet.getStreetId() != streetId) {
            throw new EntityNotFoundException(
                    "StreetId " + streetId + " not found in street."
            );
        }
        return onlyStreet;
    }

    @Override
    public Town createTown(Town town) throws InvalidSqlStatementException {
        //Pass through method no tests
        return null;
    }

    @Override
    public Town getTownByZipcode(String zipcode) throws InvalidSqlStatementException, EntityNotFoundException {
        if (!onlyTown.getZipcode().equals(zipcode)) {
            throw new EntityNotFoundException(
                    "Zipcode " + zipcode + " not found in town."
            );
        }
        return onlyTown;
    }

    @Override
    public State createState(State state) throws InvalidSqlStatementException {
        //Pass through method no tests
        return null;
    }

    @Override
    public State getStateByAbbrev(String stateAbbrev) throws InvalidSqlStatementException, EntityNotFoundException {
        if (!onlyState.getStateAbbrev().equals(stateAbbrev)) {
            throw new EntityNotFoundException(
                    "StateAbbrev " + stateAbbrev + " not found in state."
            );
        }
        return onlyState;
    }
}
