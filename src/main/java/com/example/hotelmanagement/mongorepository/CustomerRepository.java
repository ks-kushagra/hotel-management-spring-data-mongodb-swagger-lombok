package com.example.hotelmanagement.mongorepository;

import com.example.hotelmanagement.model.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository <Customer, String >{
    List<Customer> findByNameContaining(String name);
    List<Customer> findByGender(String gender);
}
