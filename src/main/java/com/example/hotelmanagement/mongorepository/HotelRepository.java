package com.example.hotelmanagement.mongorepository;

import com.example.hotelmanagement.model.hotel.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository <Hotel, String> {
   public List<Hotel> findByNameContaining(String name);
   public Hotel findByName(String name);
   public List<Hotel> findByAvailability(String option);
   public List <Hotel> findByLocation(String location);
}
