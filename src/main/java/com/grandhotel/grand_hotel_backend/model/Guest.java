package com.grandhotel.grand_hotel_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "guests")
public class Guest {

    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String nationalId;
}