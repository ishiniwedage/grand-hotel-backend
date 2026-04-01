package com.grandhotel.grand_hotel_backend.repository;

import com.grandhotel.grand_hotel_backend.model.Guest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends MongoRepository<Guest, String> {
    Guest findByNationalId(String nationalId);
    Guest findByEmail(String email);
}
