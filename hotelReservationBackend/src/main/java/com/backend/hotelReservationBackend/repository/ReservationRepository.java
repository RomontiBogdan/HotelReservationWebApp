package com.backend.hotelReservationBackend.repository;

import com.backend.hotelReservationBackend.dao.model.Reservation;
import com.backend.hotelReservationBackend.dao.model.Review;
import com.backend.hotelReservationBackend.dao.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByEmail(String email);
    Reservation findByEmailAndRoomId(String email, Long roomId);
}
