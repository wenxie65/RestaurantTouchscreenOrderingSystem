package org.sg.restaurant.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sg.restaurant.dto.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
class AddressDaoDBImplTest {

    private final JdbcTemplate jdbcTemplate;
    private final AddressDao addressDao;

    @Autowired
    public AddressDaoDBImplTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        addressDao = new AddressDaoDBImpl(jdbcTemplate);
    }

    @Test
    @DisplayName("Get All Test")
    @Transactional
    public void getAllAddressTest() {
        List<Address> addressList = addressDao.getAllAddress();

        assertNotNull(addressList);
    }

    @Test
    @DisplayName("Create and Get All Test")
    @Transactional
    public void createAndGetAllAddressTest() {
        List<Address> addressList = addressDao.getAllAddress();
        int initialSize = addressList.size();

        Address address1 = new Address();
        address1.setHouseNumber("1234");
        address1.setStreetName("Random St");
        address1.setTownName("Random Town");
        address1.setZipcode("12345");
        address1.setStateAbbrev("NY");
        addressDao.createAddress(address1);

        Address address2 = new Address();
        address2.setHouseNumber("5678");
        address2.setStreetName("Random St");
        address2.setTownName("Random Town");
        address2.setZipcode("12345");
        address2.setStateAbbrev("NY");
        addressDao.createAddress(address2);

        addressList = addressDao.getAllAddress();

        assertNotNull(addressList);
        assertEquals(initialSize + 2, addressList.size());
    }

    @Test
    @DisplayName("Create and Get By Id Test")
    @Transactional
    public void createAndGetByIdAddressTest() {
        Address address = new Address();
        address.setHouseNumber("1234");
        address.setStreetName("Random St");
        address.setTownName("Random Town");
        address.setZipcode("12345");
        address.setStateAbbrev("NY");
        address = addressDao.createAddress(address);

        Address retrievedAddress = addressDao.getAddressById(address.getAddressId());

        assertNotNull(retrievedAddress);
        assertEquals(address, retrievedAddress);

        int invalidAddressId = address.getAddressId() + 1;
        retrievedAddress = addressDao.getAddressById(invalidAddressId);

        assertNull(retrievedAddress);
    }

    @Test
    @DisplayName("Create, Update and Get All Test")
    @Transactional
    public void createUpdateAndGetAllAddressTest() {
        List<Address> addressList = addressDao.getAllAddress();
        int initialSize = addressList.size();

        Address address = new Address();
        address.setHouseNumber("1234");
        address.setStreetName("Random St");
        address.setTownName("Random Town");
        address.setZipcode("12345");
        address.setStateAbbrev("NY");
        address = addressDao.createAddress(address);

        address.setHouseNumber("5678");
        addressDao.updateAddress(address);

        addressList = addressDao.getAllAddress();

        assertNotNull(addressList);
        assertEquals(initialSize + 1, addressList.size());
    }

    @Test
    @DisplayName("Create, Update and Get By Id Test")
    @Transactional
    public void createUpdateAndGetByIdTest() {
        Address address = new Address();
        address.setHouseNumber("1234");
        address.setStreetName("Random St");
        address.setTownName("Random Town");
        address.setZipcode("12345");
        address.setStateAbbrev("NY");
        address = addressDao.createAddress(address);

        address.setHouseNumber("5678");
        addressDao.updateAddress(address);

        Address retrievedAddress = addressDao.getAddressById(address.getAddressId());

        assertNotNull(retrievedAddress);
        assertEquals(address, retrievedAddress);
        assertEquals("5678", retrievedAddress.getHouseNumber());
    }

    @Test
    @DisplayName("Create, Delete and Get All Test")
    @Transactional
    public void createDeleteAndGetAllAddressTest() {
        List<Address> addressList = addressDao.getAllAddress();
        int initialSize = addressList.size();

        Address address = new Address();
        address.setHouseNumber("1234");
        address.setStreetName("Random St");
        address.setTownName("Random Town");
        address.setZipcode("12345");
        address.setStateAbbrev("NY");
        address = addressDao.createAddress(address);

        addressList = addressDao.getAllAddress();

        assertNotNull(addressList);
        assertEquals(initialSize + 1, addressList.size());

        addressDao.deleteAddress(address.getAddressId());
        addressList = addressDao.getAllAddress();

        assertNotNull(addressList);
        assertEquals(initialSize, addressList.size());
    }

    @Test
    @DisplayName("Create, Delete and Get By Id Test")
    @Transactional
    public void createDeleteAndGetByIdTest() {
        Address address = new Address();
        address.setHouseNumber("1234");
        address.setStreetName("Random St");
        address.setTownName("Random Town");
        address.setZipcode("12345");
        address.setStateAbbrev("NY");
        address = addressDao.createAddress(address);

        Address retrievedAddress = addressDao.getAddressById(address.getAddressId());

        assertNotNull(retrievedAddress);
        assertEquals(address, retrievedAddress);

        addressDao.deleteAddress(address.getAddressId());
        retrievedAddress = addressDao.getAddressById(address.getAddressId());

        assertNull(retrievedAddress);
    }

}