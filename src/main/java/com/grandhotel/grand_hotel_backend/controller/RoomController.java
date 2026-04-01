package com.grandhotel.grand_hotel_backend.controller;

import com.grandhotel.grand_hotel_backend.model.Room;
import com.grandhotel.grand_hotel_backend.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public ResponseEntity<Room> getRoomByNumber(
            @PathVariable int roomNumber) {
        return ResponseEntity.ok(
            roomService.getRoomByNumber(roomNumber));
    }

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        return ResponseEntity.ok(roomService.createRoom(room));
    }

    @DeleteMapping("/{roomNumber}")
    public ResponseEntity<Void> deleteRoom(
            @PathVariable int roomNumber) {
        roomService.deleteRoom(roomNumber);
        return ResponseEntity.ok().build();
    }
}