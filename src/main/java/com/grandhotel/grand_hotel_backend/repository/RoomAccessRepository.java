package com.grandhotel.grand_hotel_backend.repository;

import com.grandhotel.grand_hotel_backend.model.RoomAccess;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoomAccessRepository extends MongoRepository<RoomAccess, String> {
    List<RoomAccess> findByRoomNumberOrderByAccessTimeDesc(int roomNumber);
    List<RoomAccess> findByEmployeeId(String employeeId);
}
