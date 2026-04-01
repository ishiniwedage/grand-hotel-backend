package com.grandhotel.grand_hotel_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grandhotel.grand_hotel_backend.model.Room;
import com.grandhotel.grand_hotel_backend.repository.RoomRepository;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomByNumber(int roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }

    public boolean isRoomAvailable(int roomNumber) {
        Room room = roomRepository.findByRoomNumber(roomNumber);
        return room != null && room.isAvailable();
    }
}