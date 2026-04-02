package com.grandhotel.grand_hotel_backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.grandhotel.grand_hotel_backend.model.RoomAccess;
import com.grandhotel.grand_hotel_backend.model.Staff;
import com.grandhotel.grand_hotel_backend.repository.RoomAccessRepository;
import com.grandhotel.grand_hotel_backend.repository.StaffRepository;

@Service
public class StaffService {

    private final StaffRepository staffRepository;
    private final RoomAccessRepository roomAccessRepository;

    public StaffService(StaffRepository staffRepository, RoomAccessRepository roomAccessRepository) {
        this.staffRepository = staffRepository;
        this.roomAccessRepository = roomAccessRepository;
    }

    public Staff getStaffByEmployeeId(String employeeId) {
        return staffRepository.findByEmployeeId(employeeId);
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public RoomAccess logRoomAccess(String employeeId, int roomNumber, String reason) {
        Staff staff = staffRepository.findByEmployeeId(employeeId);
        if (staff == null) throw new RuntimeException("Staff not found");

        RoomAccess access = new RoomAccess();
        access.setEmployeeId(employeeId);
        access.setStaffName(staff.getName());
        access.setRoomNumber(roomNumber);
        access.setReason(reason);
        access.setAccessTime(LocalDateTime.now());
        return roomAccessRepository.save(access);
    }

    public List<RoomAccess> getAccessLogByRoom(int roomNumber) {
        return roomAccessRepository.findByRoomNumberOrderByAccessTimeDesc(roomNumber);
    }
}