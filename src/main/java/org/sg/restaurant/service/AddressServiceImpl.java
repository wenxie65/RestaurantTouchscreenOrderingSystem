package org.sg.restaurant.service;

import org.sg.restaurant.dao.AddressDao;
import org.sg.restaurant.dao.EntityNotFoundException;
import org.sg.restaurant.dao.InvalidSqlStatementException;
import org.sg.restaurant.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressDao addressDao;

    public AddressServiceImpl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public Map<Integer, Address> getAllAddress() {
        try {
            return addressDao.getAllAddress();
        } catch (InvalidSqlStatementException | EntityNotFoundException exception) {
            return new HashMap<>();
        }
    }

    @Override
    public Address getAddressByHouseId(int houseId) {
        try {
            return addressDao.getAddressByHouseId(houseId);
        } catch (InvalidSqlStatementException | EntityNotFoundException exception) {
            Address invalidAddress = new Address();
            invalidAddress.setHouseNumber(exception.getMessage());
            return invalidAddress;
        }
    }

    @Override
    public Map<Integer, Address> getAddressByPhone(String phoneNumber) {
        try {
            return addressDao.getAddressByPhone(phoneNumber);
        } catch (InvalidSqlStatementException | EntityNotFoundException exception) {
            return new HashMap<>();
        }
    }

    @Override
    public boolean addHouseToCustomer(String phoneNumber, int houseId) {
        try {
            addressDao.addHouseToCustomer(phoneNumber, houseId);
            return true;
        } catch (InvalidSqlStatementException exception) {
            return false;
        }
    }

    @Override
    public House addNewHouse(House house) {
        try {
            return addressDao.createHouse(house);
        } catch (InvalidSqlStatementException exception) {
            House exceptionHouse = new House();
            exceptionHouse.setHouseNumber(exception.getMessage());
            return exceptionHouse;
        }
    }

    @Override
    public House getHouseByHouseId(int houseId) {
        try {
            return addressDao.getHouseByHouseId(houseId);
        } catch (InvalidSqlStatementException | EntityNotFoundException exception) {
            House exceptionHouse = new House();
            exceptionHouse.setHouseNumber(exception.getMessage());
            return exceptionHouse;
        }
    }

    @Override
    public Street addNewStreet(Street street) {
        try {
            return addressDao.createStreet(street);
        } catch (InvalidSqlStatementException exception) {
            Street exceptionStreet = new Street();
            exceptionStreet.setStreetName(exception.getMessage());
            return exceptionStreet;
        }
    }

    @Override
    public Street getStreetByStreetId(int streetId) {
        try {
            return addressDao.getStreetByStreetId(streetId);
        } catch (InvalidSqlStatementException | EntityNotFoundException exception) {
            Street exceptionStreet = new Street();
            exceptionStreet.setStreetName(exception.getMessage());
            return exceptionStreet;
        }
    }

    @Override
    public Town addNewTown(Town town) {
        try {
            return addressDao.createTown(town);
        } catch (InvalidSqlStatementException exception) {
            Town exceptionTown = new Town();
            exceptionTown.setTownName(exception.getMessage());
            return exceptionTown;
        }
    }

    @Override
    public Town getTownByZipcode(String zipcode) {
        try {
            return addressDao.getTownByZipcode(zipcode);
        } catch (InvalidSqlStatementException | EntityNotFoundException exception) {
            Town exceptionTown = new Town();
            exceptionTown.setTownName(exception.getMessage());
            return exceptionTown;
        }
    }

    @Override
    public State addNewState(State state) {
        try {
            return addressDao.createState(state);
        } catch (InvalidSqlStatementException exception) {
            State exceptionState = new State();
            exceptionState.setStateName(exception.getMessage());
            return exceptionState;
        }
    }

    @Override
    public State getStateByAbbrev(String stateAbbrev) {
        try {
            return addressDao.getStateByAbbrev(stateAbbrev);
        } catch (InvalidSqlStatementException | EntityNotFoundException exception) {
            State exceptionState = new State();
            exceptionState.setStateName(exception.getMessage());
            return exceptionState;
        }
    }
}
