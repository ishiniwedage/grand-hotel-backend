package com.grandhotel.grand_hotel_backend.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "room_access")
public class RoomAccess {

    @Id
    private String id;
    private String employeeId;
    private String staffName;
    private int roomNumber;
    private String reason;
    private LocalDateTime accessTime;
}
