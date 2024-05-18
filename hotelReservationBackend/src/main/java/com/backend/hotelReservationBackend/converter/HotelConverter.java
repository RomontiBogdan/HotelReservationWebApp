package com.backend.hotelReservationBackend.converter;

import com.backend.hotelReservationBackend.dao.model.Hotel;
import com.backend.hotelReservationBackend.dao.model.dto.HotelDto;

import java.util.List;

public class HotelConverter {
    public static HotelDto modelToDto(Hotel hotel)
    {
        return HotelDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .build();
    }

    public static List<HotelDto> modelListToDtoList(List<Hotel> hotels)
    {
        return hotels.stream()
                .map(HotelConverter::modelToDto)
                .toList();
    }

    public static Hotel dtoToModel(HotelDto hotelDto)
    {
        return Hotel.builder()
                .id(hotelDto.getId())
                .name(hotelDto.getName())
                .build();
    }

    public static List<Hotel> dtoListToModelList(List<HotelDto> hotelDtos)
    {
        return hotelDtos.stream()
                .map(HotelConverter::dtoToModel)
                .toList();
    }
}
