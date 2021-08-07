package com.example.hotelmanagement.services;


import com.example.hotelmanagement.model.customer.Customer;
import com.example.hotelmanagement.model.hotel.Hotel;
import com.example.hotelmanagement.mongorepository.CustomerRepository;
import com.example.hotelmanagement.mongorepository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public String addCustomer(Customer customer){
        try {
            if (customer == null)
                throw new NullPointerException();
        }catch(Exception e){
            return("No NULL value!!!");
        }
        customerRepository.save(customer);
        return "Customer Saved";
    }

    public List<Customer> searchByName(String name){
        return customerRepository.findByNameContaining(name);
    }

    public String deleteCustomer(String customerId){
        Optional<Customer> customerData = customerRepository.findById(customerId);
        if(customerData.isPresent()){
            Customer customer = customerData.get();
            customerRepository.deleteById(customerId);
            return "Ohh !!! You are leaving our hotel. Bye !! Bye";
        }
        return "No Customer found";
    }
}
