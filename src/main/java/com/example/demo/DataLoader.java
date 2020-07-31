package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    RoomRepository roomRepository;

    @Override
    public void run(String... args) throws Exception {
//        Room(boolean isRented, String address, String city, String state, double price,
//        String description, String rules, String cable, boolean wifi, boolean privateBathroom) {

            Room room1 = new Room(true, "2986 Hills Drive", "Silver Spring",
                "MD", 999.99, "Close to DownTown Silver spring, train station and shopping.",
                    "No Smoking", "None", true, true);

            Room room2 = new Room(false, "26868 S street", "Bethesda",
                    "MD", 1899, "Close to DownTown, train station and shopping.",
                    "No Smoking", "premium", true, false);

        Room room3 = new Room(true, "4546 T street", "College Park",
                "MD", 1899, "Close to DownTown, train station and shopping.",
                "No Smoking", "premium", true, true);

        roomRepository.save(room1);
        roomRepository.save(room2);
        roomRepository.save(room3);
    }
}
