package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.model.customer.Customer;
import com.example.hotelmanagement.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addCustomer")
    public String addingCustomer(@RequestBody Customer customer){return customerService.addCustomer(customer);}

    @GetMapping("/search/name/{customername}")
    public List<Customer> searchbyName(String customername){return customerService.searchByName(customername);}

    @GetMapping("/delete/{customerid}")
    public String deleteCustomer(String customerid){return customerService.deleteCustomer(customerid);}
}
