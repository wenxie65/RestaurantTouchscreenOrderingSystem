package org.sg.restaurant.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sg.restaurant.dao.AddressDao;
import org.sg.restaurant.dao.AddressDaoStubImpl;
import org.sg.restaurant.dto.*;

import static org.junit.jupiter.api.Assertions.*;
public class AddressServiceImplTest {

    private final AddressService addressService;

    public AddressServiceImplTest() {
        AddressDao addressDao = new AddressDaoStubImpl();
        addressService = new AddressServiceImpl(addressDao);
    }

    @Test
    @DisplayName("Get Address By Valid House Id Service Test")
    public void getValidAddressServiceTest() {
        Address retrievedAddress = addressService.getAddressByHouseId(1);

        assertNotNull(retrievedAddress);
        assertEquals("1234", retrievedAddress.getHouseNumber());
    }

    @Test
    @DisplayName("Get Address By Invalid House Id Service Test")
    public void getInvalidAddressServiceTest() {
        Address retrievedAddress = addressService.getAddressByHouseId(999);

        assertNotNull(retrievedAddress);
        assertEquals("HouseId 999 not found in address.", retrievedAddress.getHouseNumber());
    }

    @Test
    @DisplayName("Get House By Valid House Id Service Test")
    public void getValidHouseServiceTest() {
        House retrievedHouse = addressService.getHouseByHouseId(1);

        assertNotNull(retrievedHouse);
        assertEquals("1234", retrievedHouse.getHouseNumber());
    }

    @Test
    @DisplayName("Get House By Invalid House Id Service Test")
    public void getInvalidHouseServiceTest() {
        House retrievedHouse = addressService.getHouseByHouseId(999);

        assertNotNull(retrievedHouse);
        assertEquals("HouseId 999 not found in house.", retrievedHouse.getHouseNumber());
    }

    @Test
    @DisplayName("Get Street By Valid Street Id Service Test")
    public void getValidStreetServiceTest() {
        Street retrievedStreet = addressService.getStreetByStreetId(1);

        assertNotNull(retrievedStreet);
        assertEquals("New St", retrievedStreet.getStreetName());
    }

    @Test
    @DisplayName("Get Street By Invalid Street Id Service Test")
    public void getInvalidStreetServiceTest() {
        Street retrievedStreet = addressService.getStreetByStreetId(999);

        assertNotNull(retrievedStreet);
        assertEquals("StreetId 999 not found in street.", retrievedStreet.getStreetName());
    }

    @Test
    @DisplayName("Get Town By Valid Zipcode Service Test")
    public void getValidTownServiceTest() {
        Town retrievedTown = addressService.getTownByZipcode("00000");

        assertNotNull(retrievedTown);
        assertEquals("New Town", retrievedTown.getTownName());
    }

    @Test
    @DisplayName("Get Town By Invalid Zipcode Service Test")
    public void getInvalidTownServiceTest() {
        Town retrievedTown = addressService.getTownByZipcode("99999");

        assertNotNull(retrievedTown);
        assertEquals("Zipcode 99999 not found in town.", retrievedTown.getTownName());
    }

    @Test
    @DisplayName("Get State By Valid Abbreviation Service Test")
    public void getValidStateServiceTest() {
        State retrievedState = addressService.getStateByAbbrev("NS");

        assertNotNull(retrievedState);
        assertEquals("New State", retrievedState.getStateName());
    }

    @Test
    @DisplayName("Get State By Invalid Abbreviation Service Test")
    public void getInvalidStateServiceTest() {
        State retrievedState = addressService.getStateByAbbrev("XX");

        assertNotNull(retrievedState);
        assertEquals("StateAbbrev XX not found in state.", retrievedState.getStateName());
    }

}