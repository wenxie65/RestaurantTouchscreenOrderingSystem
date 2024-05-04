package org.sg.restaurant.controller;

import org.sg.restaurant.dto.*;
import org.sg.restaurant.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAllAddress() {
        return new ArrayList<>(addressService.getAllAddress().values());
    }

    @GetMapping("/id/{houseId}")
    public Address getAddressByHouseId(@PathVariable int houseId) {
        return addressService.getAddressByHouseId(houseId);
    }

    @GetMapping("/phone/{phoneNumber}")
    public List<Address> getAddressByPhone(@PathVariable String phoneNumber) {
        return new ArrayList<>(addressService.getAddressByPhone(phoneNumber).values());
    }

    @PostMapping("/addHouseToCustomer/{phoneNumber}/{houseId}")
    public boolean addHouseToCustomer(@PathVariable String phoneNumber, @PathVariable int houseId) {
        return addressService.addHouseToCustomer(phoneNumber,houseId);
    }

    @PostMapping("/house/add")
    public House addNewHouse(@RequestBody House house) {
        return addressService.addNewHouse(house);
    }

    @GetMapping("/house/{houseId}")
    public House getHouseByHouseId(@PathVariable int houseId) {
        return addressService.getHouseByHouseId(houseId);
    }

    @PostMapping("/street/add")
    public Street addNewStreet(@RequestBody Street street) {
        return addressService.addNewStreet(street);
    }

    @GetMapping("/street/{streetId}")
    public Street getStreetByStreetId(@PathVariable int streetId) {
        return addressService.getStreetByStreetId(streetId);
    }

    @PostMapping("/town/add")
    public Town addNewTown(@RequestBody Town town) {
        return addressService.addNewTown(town);
    }

    @GetMapping("/town/{zipcode}")
    public Town getTownByZipcode(@PathVariable String zipcode) {
        return addressService.getTownByZipcode(zipcode);
    }

    @PostMapping("/state/add")
    public State addNewState(@RequestBody State state) {
        return addressService.addNewState(state);
    }

    @GetMapping("/state/{stateAbbrev}")
    public State getStateByAbbrev(@PathVariable String stateAbbrev) {
        return addressService.getStateByAbbrev(stateAbbrev);
    }
}
