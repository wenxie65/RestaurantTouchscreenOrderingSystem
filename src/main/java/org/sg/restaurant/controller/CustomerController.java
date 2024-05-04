package org.sg.restaurant.controller;

import org.sg.restaurant.dto.Customer;
import org.sg.restaurant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomer() {
        return new ArrayList<>(customerService.getAllCustomer().values());
    }

    @GetMapping("/{phoneNumber}")
    public Customer getCustomerByPhone(@PathVariable String phoneNumber) {
        return customerService.getCustomerByPhone(phoneNumber);
    }

    @PostMapping("/add")
    public Customer addNewCustomer(@RequestBody Customer customer) {
        return customerService.addNewCustomer(customer);
    }

    @PutMapping("/{phoneNumber}")
    public boolean updateCustomer(@PathVariable String phoneNumber, @RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{phoneNumber}")
    public boolean deleteCustomer(@PathVariable String phoneNumber) {
        return customerService.deleteCustomer(phoneNumber);
    }

    @GetMapping("/getCustomerByHouseId/{houseId}")
    public List<Customer> getCustomerByHouseId(@PathVariable int houseId) {
        return new ArrayList<>(customerService.getCustomerByHouseId(houseId).values());
    }

}
