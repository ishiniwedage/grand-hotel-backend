package com.grandhotel.grand_hotel_backend.controller;

import com.grandhotel.grand_hotel_backend.model.Guest;
import com.grandhotel.grand_hotel_backend.service.GuestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/guests")
@CrossOrigin(origins = "http://localhost:3000")
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public ResponseEntity<List<Guest>> getAllGuests() {
        return ResponseEntity.ok(guestService.getAllGuests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable String id) {
        return ResponseEntity.ok(guestService.getGuestById(id));
    }

    @GetMapping("/national/{nationalId}")
    public ResponseEntity<Guest> getGuestByNationalId(@PathVariable String nationalId) {
        return ResponseEntity.ok(guestService.getGuestByNationalId(nationalId));
    }
}