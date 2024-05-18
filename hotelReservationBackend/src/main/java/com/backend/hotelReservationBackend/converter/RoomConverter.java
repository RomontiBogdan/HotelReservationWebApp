package com.backend.hotelReservationBackend.converter;

import com.backend.hotelReservationBackend.dao.model.Room;
import com.backend.hotelReservationBackend.dao.model.dto.RoomDto;

import java.util.List;

public class RoomConverter {
    public static RoomDto modelToDto(Room room)
    {
        return RoomDto.builder()
                .id(room.getId())
                .roomNumber(room.getRoomNumber())
                .type(room.getType())
                .price(room.getPrice())
                .isAvailable(room.isAvailable())
                .build();
    }

    public static List<RoomDto> modelListToDtoList(List<Room> rooms)
    {
        return rooms.stream()
                .map(RoomConverter::modelToDto)
                .toList();
    }

}
