package org.sg.restaurant.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sg.restaurant.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
class AddressDaoDBImplTest {

    private final AddressDao addressDao;

    @Autowired
    public AddressDaoDBImplTest(JdbcTemplate jdbcTemplate) {
        addressDao = new AddressDaoDBImpl(jdbcTemplate);
    }

    @Test
    @DisplayName("Valid Input Test")
    @Transactional
    public void validTest() {
        try {
            // Create and get state by abbreviation test
            State testState = new State();
            testState.setStateAbbrev("NS");
            testState.setStateName("New State");
            testState = addressDao.createState(testState);

            State retrievedState = addressDao.getStateByAbbrev(testState.getStateAbbrev());

            assertNotNull(retrievedState);
            assertEquals(testState, retrievedState);


            // Create and get town by zipcode test
            Town testTown = new Town();
            testTown.setZipcode("00000");
            testTown.setTownName("New Town");
            testTown.setStateAbbrev(testState.getStateAbbrev());
            testTown = addressDao.createTown(testTown);

            Town retrievedTown = addressDao.getTownByZipcode(testTown.getZipcode());

            assertNotNull(retrievedTown);
            assertEquals(testTown, retrievedTown);


            // Create and get street by id test
            Street testStreet = new Street();
            testStreet.setStreetName("New St");
            testStreet.setZipcode(testTown.getZipcode());
            testStreet = addressDao.createStreet(testStreet);

            Street retrievedStreet = addressDao.getStreetByStreetId(testStreet.getStreetId());

            assertNotNull(retrievedStreet);
            assertEquals(testStreet, retrievedStreet);


            // Create and get house by id test
            House testHouse = new House();
            testHouse.setHouseNumber("1234");
            testHouse.setAptNumber("A");
            testHouse.setStreetId(testStreet.getStreetId());
            testHouse = addressDao.createHouse(testHouse);

            House retrievedHouse = addressDao.getHouseByHouseId(testHouse.getHouseId());

            assertNotNull(retrievedHouse);
            assertEquals(testHouse, retrievedHouse);


            // Get address by houseId test
            Address testAddress = addressDao.getAddressByHouseId(testHouse.getHouseId());

            assertNotNull(testAddress);
            assertEquals(testHouse.getHouseId(), testAddress.getHouseId());
            assertEquals(testStreet.getStreetName(), testAddress.getStreetName());
            assertEquals(testTown.getZipcode(), testAddress.getZipcode());
            assertEquals(testState.getStateAbbrev(), testAddress.getStateAbbrev());

        } catch (Exception exception) {
            fail("No exception should be thrown.");
        }
    }
}