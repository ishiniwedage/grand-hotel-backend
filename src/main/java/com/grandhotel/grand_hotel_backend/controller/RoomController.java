package com.grandhotel.grand_hotel_backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grandhotel.grand_hotel_backend.model.Room;
import com.grandhotel.grand_hotel_backend.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:3000")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    @GetMapping("/{roomNumber}")
    public ResponseEntity<Room> getRoomByNumber(@PathVariable int roomNumber) {
        return ResponseEntity.ok(roomService.getRoomByNumber(roomNumber));
    }

    @GetMapping("/{roomNumber}/availability")
    public ResponseEntity<Boolean> checkAvailability(@PathVariable int roomNumber) {
        return ResponseEntity.ok(roomService.isRoomAvailable(roomNumber));
    }
}