package org.sg.restaurant.service;

import org.sg.restaurant.dto.*;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface AddressService {
    Map<Integer, Address> getAllAddress();

    Address getAddressByHouseId(int houseId);

    Map<Integer, Address> getAddressByPhone(String phoneNumber);

    boolean addHouseToCustomer(String phoneNumber, int houseId);

    House addNewHouse(House house);

    House getHouseByHouseId(int houseId);

    Street addNewStreet(Street street);

    Street getStreetByStreetId(int streetId);

    Town addNewTown(Town town);

    Town getTownByZipcode(String zipcode);

    State addNewState(State state);

    State getStateByAbbrev(String stateAbbrev);
}
