package com.grandhotel.grand_hotel_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grandhotel.grand_hotel_backend.model.Guest;
import com.grandhotel.grand_hotel_backend.repository.GuestRepository;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Guest getGuestById(String id) {
        return guestRepository.findById(id).orElse(null);
    }

    public Guest getGuestByNationalId(String nationalId) {
        return guestRepository.findByNationalId(nationalId);
    }
}