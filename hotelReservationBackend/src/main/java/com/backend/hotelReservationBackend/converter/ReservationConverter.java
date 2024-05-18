package com.backend.hotelReservationBackend.converter;

import com.backend.hotelReservationBackend.dao.model.Reservation;
import com.backend.hotelReservationBackend.dao.model.Review;
import com.backend.hotelReservationBackend.dao.model.dto.ReservationDto;
import com.backend.hotelReservationBackend.dao.model.dto.ReviewDto;

import java.util.List;

public class ReservationConverter {
    public static ReservationDto modelToDto(Reservation reservation) {
        return ReservationDto.builder()
                .email(reservation.getEmail())
                .roomId(reservation.getRoom().getId())
                .build();
    }

    public static List<ReservationDto> modelListToDtoList(List<Reservation> reviews) {
        return reviews.stream()
                .map(ReservationConverter::modelToDto)
                .toList();
    }
}
