package com.grandhotel.grand_hotel_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "staff")
public class Staff {

    @Id
    private String id;
    private String employeeId;
    private String name;
    private String role;
    private String phone;
}