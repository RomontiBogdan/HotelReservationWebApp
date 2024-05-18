package com.backend.hotelReservationBackend.service;

import com.backend.hotelReservationBackend.DistanceUtil;
import com.backend.hotelReservationBackend.converter.HotelConverter;
import com.backend.hotelReservationBackend.dao.model.Hotel;
import com.backend.hotelReservationBackend.dao.model.dto.HotelDto;
import com.backend.hotelReservationBackend.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelDto> getAllHotels() {
        List<Hotel> hotelList = hotelRepository.findAll();
        return HotelConverter.modelListToDtoList(hotelList);
    }

    public HotelDto getHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
        return HotelConverter.modelToDto(hotel);
    }

    public List<HotelDto> findNearbyHotels(double userLat, double userLong, double radius) {
        List<Hotel> allHotels = hotelRepository.findAll();
        List<Hotel> nearbyHotels = allHotels.stream()
                .filter(hotel -> {
                    double distance = DistanceUtil.calculateDistance(userLat, userLong, hotel.getLatitude(), hotel.getLongitude());
                    return distance <= radius;
                })
                .collect(Collectors.toList());

        return HotelConverter.modelListToDtoList(nearbyHotels);
    }
}
