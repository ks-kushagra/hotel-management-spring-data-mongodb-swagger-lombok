package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.model.hotel.Hotel;
import com.example.hotelmanagement.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/addhotel")
        public String addhotel(@RequestBody Hotel hotel){
        return hotelService.addHotel(hotel);
        }

    @GetMapping("/search/name/{hotelname}")
    public List<Hotel> searchbyName(@PathVariable String hotelname){
        return hotelService.searchByName(hotelname);
    }

    @GetMapping("/search/location/{locationname}")
    public List<Hotel> searchbyLocation(@PathVariable String locationname){return hotelService.searchByLocation(locationname);}

    @GetMapping("/search/available")
    public List<Hotel> searchbyAvailability(){return hotelService.searchByAvailability();}
}
