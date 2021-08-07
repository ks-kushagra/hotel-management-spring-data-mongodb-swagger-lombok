package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.model.room.Room;
import com.example.hotelmanagement.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/add/{hotelId}")
    public String addRoom(@PathVariable String hotelId){
        return roomService.addRoom(hotelId);
    }

    @PostMapping("/book/{hotelId}/{customerId}")
    public String bookRoom(@PathVariable String hotelId , @PathVariable String customerId){
        return roomService.bookRoom(hotelId,customerId);
    }

    @PostMapping("/withdraw/{roomId}")
    public String withdrawRoom(@PathVariable int roomId){
        return roomService.withdrawRoom(roomId);
    }

    @GetMapping("/search/hotelid/{hotelName}")
    public List<Room> getRoomsByHotelName(@PathVariable String hotelName){
        return roomService.roomByHotelName(hotelName);
    }
}
