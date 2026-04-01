package com.grandhotel.grand_hotel_backend.controller;

import com.grandhotel.grand_hotel_backend.model.RoomAccess;
import com.grandhotel.grand_hotel_backend.model.Staff;
import com.grandhotel.grand_hotel_backend.service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin(origins = "http://localhost:3000")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public ResponseEntity<List<Staff>> getAllStaff() {
        return ResponseEntity.ok(staffService.getAllStaff());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Staff> getStaff(@PathVariable String employeeId) {
        return ResponseEntity.ok(staffService.getStaffByEmployeeId(employeeId));
    }

    @PostMapping("/access")
    public ResponseEntity<RoomAccess> logAccess(
            @RequestParam String employeeId,
            @RequestParam int roomNumber,
            @RequestParam String reason) {
        return ResponseEntity.ok(staffService.logRoomAccess(employeeId, roomNumber, reason));
    }

    @GetMapping("/access/{roomNumber}")
    public ResponseEntity<List<RoomAccess>> getAccessLog(@PathVariable int roomNumber) {
        return ResponseEntity.ok(staffService.getAccessLogByRoom(roomNumber));
    }
}