package com.grandhotel.grand_hotel_backend;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.grandhotel.grand_hotel_backend.model.Booking;
import com.grandhotel.grand_hotel_backend.model.Guest;
import com.grandhotel.grand_hotel_backend.model.Room;
import com.grandhotel.grand_hotel_backend.model.Staff;
import com.grandhotel.grand_hotel_backend.repository.BookingRepository;
import com.grandhotel.grand_hotel_backend.repository.GuestRepository;
import com.grandhotel.grand_hotel_backend.repository.RoomAccessRepository;
import com.grandhotel.grand_hotel_backend.repository.RoomRepository;
import com.grandhotel.grand_hotel_backend.repository.StaffRepository;

@Component
public class DataSeeder implements CommandLineRunner {

    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;
    private final StaffRepository staffRepository;
    

    public DataSeeder(
            GuestRepository guestRepository,
            RoomRepository roomRepository,
            BookingRepository bookingRepository,
            StaffRepository staffRepository,
            RoomAccessRepository roomAccessRepository) {

        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
        this.staffRepository = staffRepository;
        
    }

    @Override
    public void run(String... args) throws Exception {

        // Guests
        if (guestRepository.count() == 0) {

            String[][] guests = {
                    {"Alice Johnson", "alice@email.com", "0771234567", "NIC001"},
                    {"Bob Smith", "bob@email.com", "0772345678", "NIC002"},
                    {"Carol White", "carol@email.com", "0773456789", "NIC003"},
                    {"David Brown", "david@email.com", "0774567890", "NIC004"},
                    {"Emma Davis", "emma@email.com", "0775678901", "NIC005"},
                    {"Frank Miller", "frank@email.com", "0776789012", "NIC006"},
                    {"Grace Wilson", "grace@email.com", "0777890123", "NIC007"},
                    {"Henry Moore", "henry@email.com", "0778901234", "NIC008"},
                    {"Isla Taylor", "isla@email.com", "0779012345", "NIC009"},
                    {"Jack Anderson", "jack@email.com", "0770123456", "NIC010"}
            };

            for (String[] g : guests) {
                Guest guest = new Guest();
                guest.setName(g[0]);
                guest.setEmail(g[1]);
                guest.setPhone(g[2]);
                guest.setNationalId(g[3]);
                guestRepository.save(guest);
            }

            System.out.println("✅ 10 demo guests seeded!");
        }

        // Rooms
        if (roomRepository.count() == 0) {

            String[] types = {"SINGLE", "DOUBLE", "SUITE"};
            double[] prices = {50.0, 80.0, 150.0};

            for (int i = 1; i <= 20; i++) {
                int typeIndex = (i <= 10) ? 0 : (i <= 17) ? 1 : 2;

                Room room = new Room();
                room.setRoomNumber(i);
                room.setRoomType(types[typeIndex]);
                room.setPricePerNight(prices[typeIndex]);
                room.setAvailable(true);

                roomRepository.save(room);
            }

            System.out.println("✅ 20 demo rooms seeded!");
        }

        // Bookings
        if (bookingRepository.count() == 0) {

            List<Guest> guests = guestRepository.findAll();
            List<Room> rooms = roomRepository.findAll();

            LocalDateTime base = LocalDateTime.of(2026, 4, 1, 14, 0);

            for (int i = 0; i < 10; i++) {

                Room room = rooms.get(i);
                Guest guest = guests.get(i);

                room.setAvailable(false);
                roomRepository.save(room);

                Booking booking = new Booking();
                booking.setRoomNumber(room.getRoomNumber());
                booking.setGuestId(guest.getId());
                booking.setCheckInTime(base.plusDays(i));
                booking.setCheckOutTime(base.plusDays(i + 3));
                booking.setCardId("CARD-" + String.format("%03d", i + 1));
                booking.setStatus("ACTIVE");

                bookingRepository.save(booking);
            }

            System.out.println("✅ 10 demo bookings seeded!");
        }

        // Staff
        if (staffRepository.count() == 0) {

            String[][] staffData = {
                    {"EMP001", "John Silva", "Housekeeping", "0711111111"},
                    {"EMP002", "Mary Perera", "Maintenance", "0722222222"},
                    {"EMP003", "Tom Fernando", "Room Service", "0733333333"},
                    {"EMP004", "Sara Bandara", "Housekeeping", "0744444444"},
                    {"EMP005", "Kamal Jayasinghe", "Maintenance", "0755555555"}
            };

            for (String[] s : staffData) {
                Staff staff = new Staff();
                staff.setEmployeeId(s[0]);
                staff.setName(s[1]);
                staff.setRole(s[2]);
                staff.setPhone(s[3]);

                staffRepository.save(staff);
            }

            System.out.println("✅ 5 demo staff seeded!");
        }
    }
}