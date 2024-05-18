package com.backend.hotelReservationBackend.service;

import com.backend.hotelReservationBackend.converter.ReservationConverter;
import com.backend.hotelReservationBackend.converter.RoomConverter;
import com.backend.hotelReservationBackend.dao.model.Reservation;
import com.backend.hotelReservationBackend.dao.model.Room;
import com.backend.hotelReservationBackend.dao.model.dto.ReservationDto;
import com.backend.hotelReservationBackend.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationDto> getReservationByEmail(String email) {
        List<Reservation> reservations = reservationRepository.findAllByEmail(email);
        return ReservationConverter.modelListToDtoList(reservations);
    }
}
