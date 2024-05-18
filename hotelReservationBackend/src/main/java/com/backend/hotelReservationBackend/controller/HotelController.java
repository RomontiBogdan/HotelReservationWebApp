package com.backend.hotelReservationBackend.controller;


import com.backend.hotelReservationBackend.dao.model.dto.HotelDto;
import com.backend.hotelReservationBackend.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@CrossOrigin(origins = "http://localhost:3000")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<HotelDto> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public HotelDto getHotelById(@PathVariable Long id){
        return hotelService.getHotelById(id);
    }

    @GetMapping("/nearby")
    public List<HotelDto> findNearbyHotels(@RequestParam double userLat, @RequestParam double userLong, @RequestParam double radius) {
        return hotelService.findNearbyHotels(userLat, userLong, radius);
    }
}
