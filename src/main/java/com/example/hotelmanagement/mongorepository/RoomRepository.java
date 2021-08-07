package com.example.hotelmanagement.mongorepository;


import com.example.hotelmanagement.model.room.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoomRepository extends MongoRepository <Room, Integer > {
    public List<Room> findByHotelId(String hotelId);
    public List<Room> findByStatus(String status);
    public List<Room> findByHotelIdAndStatus(String hotelId, String Status);
    public int countByHotelId(String hotelId);
}
