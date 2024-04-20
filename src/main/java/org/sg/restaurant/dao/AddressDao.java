package org.sg.restaurant.dao;

import org.sg.restaurant.dto.Address;

import java.util.List;

public interface AddressDao {

    List<Address> getAllAddress();

    List<Address> getAddressByPhone(String phoneNumber);

    Address createAddress(Address address);

    void addAddressToCustomer(String phoneNumber, int addressId);

    void updateAddress(Address address);

    void deleteAddress(Address address);

    void deleteAddress(int addressId);
}
