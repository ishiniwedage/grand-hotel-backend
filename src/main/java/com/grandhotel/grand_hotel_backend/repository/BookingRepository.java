package com.grandhotel.grand_hotel_backend.repository;

import com.grandhotel.grand_hotel_backend.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
    Booking findByRoomNumber(int roomNumber);
    List<Booking> findByGuestId(String guestId);
}

