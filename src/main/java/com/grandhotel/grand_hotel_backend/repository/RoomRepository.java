package com.grandhotel.grand_hotel_backend.repository;

import com.grandhotel.grand_hotel_backend.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {
    Room findByRoomNumber(int roomNumber);
}