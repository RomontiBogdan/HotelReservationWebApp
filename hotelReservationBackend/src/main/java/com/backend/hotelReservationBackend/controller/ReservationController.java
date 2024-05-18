package com.backend.hotelReservationBackend.controller;

import com.backend.hotelReservationBackend.dao.model.dto.ReservationDto;
import com.backend.hotelReservationBackend.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@CrossOrigin(origins = "http://localhost:3000")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<ReservationDto> getReservationByEmail(@RequestParam String email) {
        return reservationService.getReservationByEmail(email);
    }
}