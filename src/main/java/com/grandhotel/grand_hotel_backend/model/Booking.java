package com.grandhotel.grand_hotel_backend.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "bookings")
public class Booking {

    @Id
    private String id;
    private String guestId;
    private int roomNumber;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private String cardId;
    private String status;
}