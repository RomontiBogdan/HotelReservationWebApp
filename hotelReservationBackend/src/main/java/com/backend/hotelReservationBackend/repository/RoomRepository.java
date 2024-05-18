package com.backend.hotelReservationBackend.repository;

import com.backend.hotelReservationBackend.dao.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findAllByHotelId(Long hotelId);

    Room findByHotelIdAndRoomNumber(Long hotelId, Long roomNumber);
}
