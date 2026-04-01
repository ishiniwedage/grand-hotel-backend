package com.grandhotel.grand_hotel_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "rooms")
public class Room {

    @Id
    private String id;
    private int roomNumber;
    private String roomType;
    private boolean available;
    private double pricePerNight;
}