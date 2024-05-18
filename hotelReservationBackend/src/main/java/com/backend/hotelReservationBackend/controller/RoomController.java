package com.backend.hotelReservationBackend.controller;

import com.backend.hotelReservationBackend.dao.model.Room;
import com.backend.hotelReservationBackend.dao.model.dto.RoomDto;
import com.backend.hotelReservationBackend.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels/{hotelId}/rooms")
@CrossOrigin(origins = "http://localhost:3000")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<RoomDto> getAllRoomsByHotelId(@PathVariable Long hotelId) {
        return roomService.getRoomsByHotelId(hotelId);
    }

    @GetMapping("/{roomNumber}")
    public Room getRoomByNumber(@PathVariable Long roomNumber, @PathVariable Long hotelId){
        return roomService.getRoomByNumber(roomNumber, hotelId);
    }

    @PostMapping("/{roomNumber}/book")
    public void bookRoom(@PathVariable Long roomNumber, @PathVariable Long hotelId, @RequestParam String email, @RequestParam String name) {
        roomService.bookRoom(roomNumber, hotelId, email, name);
    }

    @PostMapping("/{roomNumber}/cancel")
    public void cancelReservation(@PathVariable Long roomNumber, @PathVariable Long hotelId, @RequestParam String email) {
        roomService.cancelReservation(roomNumber, hotelId, email);
    }

    @PostMapping("/{roomNumber}/change/{newRoomNumber}")
    public void changeBookedRoom(@PathVariable Long roomNumber, @RequestParam Long newRoomNumber) {
        roomService.changeBookedRoom(roomNumber, newRoomNumber);
    }

    // Endpoint for leaving feedback
//    @PostMapping("/{roomId}/feedback")
//    public void leaveFeedback(@PathVariable Long hotelId, @PathVariable Long roomId, @RequestBody String feedback) {
//        roomService.leaveFeedback(hotelId, roomId, feedback);
//    }
}
