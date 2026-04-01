package com.grandhotel.grand_hotel_backend.service;

import com.grandhotel.grand_hotel_backend.model.Staff;
import com.grandhotel.grand_hotel_backend.model.RoomAccess;
import com.grandhotel.grand_hotel_backend.repository.StaffRepository;
import com.grandhotel.grand_hotel_backend.repository.RoomAccessRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;
    private final RoomAccessRepository roomAccessRepository;

    public StaffService(StaffRepository staffRepository,
                        RoomAccessRepository roomAccessRepository) {
        this.staffRepository = staffRepository;
        this.roomAccessRepository = roomAccessRepository;
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff getStaffByEmployeeId(String employeeId) {
        return staffRepository.findByEmployeeId(employeeId);
    }

    public RoomAccess logRoomAccess(String employeeId, 
                                    int roomNumber, 
                                    String reason) {
        RoomAccess access = new RoomAccess();
        access.setEmployeeId(employeeId);
        access.setRoomNumber(roomNumber);
        access.setReason(reason);
        return roomAccessRepository.save(access);
    }

    public List<RoomAccess> getAccessLogByRoom(int roomNumber) {
        return roomAccessRepository.findByRoomNumber(roomNumber);
    }
}