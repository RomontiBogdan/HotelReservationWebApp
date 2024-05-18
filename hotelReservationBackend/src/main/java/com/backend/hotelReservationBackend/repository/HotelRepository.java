package com.backend.hotelReservationBackend.repository;

import com.backend.hotelReservationBackend.dao.model.Hotel;
import com.backend.hotelReservationBackend.dao.model.dto.HotelDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
