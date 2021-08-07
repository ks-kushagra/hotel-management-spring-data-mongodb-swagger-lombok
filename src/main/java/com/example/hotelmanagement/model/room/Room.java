package com.example.hotelmanagement.model.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Room {
    @Id
    int roomId;
    String hotelId;
    String customerId;
    String  status;
}
