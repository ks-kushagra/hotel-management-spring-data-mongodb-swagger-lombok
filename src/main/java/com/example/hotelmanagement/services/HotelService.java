package com.example.hotelmanagement.services;

import com.example.hotelmanagement.model.hotel.Hotel;
import com.example.hotelmanagement.mongorepository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public String addHotel(Hotel hotel){

        try {
            if (hotel == null )
                throw new NullPointerException();
            hotelRepository.save(hotel);

        }catch(Exception e){
            System.out.println("There's a NULL FIELD EXCEPTION");
            return "Hotel Not Added";
        }
        return "Hotel Added";
    }

    public List<Hotel> searchByName(String name){

        try {
            if (name.isEmpty())
                throw new NullPointerException();
        }catch(Exception e){
            System.out.println("Why are you searching with NULL value?? lol!!!");
            return Collections.<Hotel>emptyList();
        }

        return hotelRepository.findByNameContaining(name);

    }

    public List<Hotel> searchByLocation(String location){
        try {
            if (location.isEmpty())
                throw new NullPointerException();
        }catch(Exception e){
            System.out.println("Why are you searching with NULL location value?? lol!!!");
            return Collections.<Hotel>emptyList();
        }

        return hotelRepository.findByLocation(location);
    }

    public List<Hotel> searchByAvailability(){
        List<Hotel> hotels = hotelRepository.findByAvailability("YES");

        if(hotels.size() == 0)
          System.out.println("Sorry !!!!! Bad Luck . No Hotels Available");

        else
            System.out.println("Great!!!!! Hotels found");

        return hotels;
    }
}