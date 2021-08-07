package com.example.hotelmanagement.services;

import com.example.hotelmanagement.model.customer.Customer;
import com.example.hotelmanagement.model.hotel.Hotel;
import com.example.hotelmanagement.model.hotel.availability.Available;
import com.example.hotelmanagement.model.room.Room;
import com.example.hotelmanagement.model.room.status.Status;
import com.example.hotelmanagement.mongorepository.CustomerRepository;
import com.example.hotelmanagement.mongorepository.HotelRepository;
import com.example.hotelmanagement.mongorepository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
     public static int id = 0;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public String addRoom(String hotelId){
        Optional<Hotel> hotelData = hotelRepository.findById(hotelId);
        if(hotelData.isPresent()){

            Hotel hotel = hotelData.get();
            int totalRooms = hotel.getNumberofrooms();
            int numberOfRoomsInDb = roomRepository.countByHotelId(hotelId);

            if(totalRooms == numberOfRoomsInDb)
                return "Sorry !! No further can be added in this Hotel";


            if(hotel.getAvailability().equals("YES")){
                Room room = new Room(
                        ++id,
                        hotelId,
                        "NA",
                        Status.VACANT.name()
                );
                roomRepository.save(room);
                return "Wow !! A new Room has been Added";

            }else{
                return "No Rooms Available in this Hotel";
            }
        }
        else
            return "Wrong Hotel ID";

    }

    public String bookRoom(String hotelId , String customerId){
        Optional<Hotel> hotelData = hotelRepository.findById(hotelId);
        Optional<Customer> customerData = customerRepository.findById(customerId);
        if(hotelData.isPresent() && customerData.isPresent()){
           Hotel hotel = hotelData.get();
            if(hotel.getAvailability().equals(Available.NO.name()))
                return "No VACANT room available";

            if(hotel.getNumberofrooms()==1)
                hotel.setAvailability(Available.NO.name());

            hotel.setNumberofrooms(hotel.getNumberofrooms()-1);
            hotelRepository.save(hotel);


            List <Room> rooms = roomRepository.findByHotelIdAndStatus(hotelId,Status.VACANT.name());
           Room room = rooms.get(0);
           room.setCustomerId(customerId);
           room.setStatus(Status.BOOKED.name());
           roomRepository.save(room);
           return "Congratulations ! You booked a room";
        }
        else
            return "Wrong Hotel ID or Customer ID";
    }

    public String withdrawRoom(int roomId){
        Optional <Room> roomData = roomRepository.findById(roomId);
        if(roomData.isPresent()){
            Room room = roomData.get();
            Hotel hotel = hotelRepository.findById(room.getHotelId()).get();
            hotel.setNumberofrooms(hotel.getNumberofrooms()+1);
            room.setStatus(Status.VACANT.name());
            room.setCustomerId("NA");
            roomRepository.save(room);
            hotelRepository.save(hotel);
            return " Room is Vacant now";
        }

        return "Wrong Room ID";
    }

    public List<Room> roomByHotelName(String hotelName){
        String hotelId = hotelRepository.findByName(hotelName).getHotelid();
        return roomRepository.findByHotelId(hotelId);
    }
}
