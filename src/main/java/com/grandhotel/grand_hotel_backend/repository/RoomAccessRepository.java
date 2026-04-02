package com.grandhotel.grand_hotel_backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.grandhotel.grand_hotel_backend.model.RoomAccess;

@Repository
public interface RoomAccessRepository extends MongoRepository<RoomAccess, String> {
    List<RoomAccess> findByRoomNumberOrderByAccessTimeDesc(int roomNumber);
    List<RoomAccess> findByEmployeeId(String employeeId);
}