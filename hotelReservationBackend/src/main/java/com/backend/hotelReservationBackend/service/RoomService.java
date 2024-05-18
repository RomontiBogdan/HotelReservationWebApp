package com.backend.hotelReservationBackend.service;

import com.backend.hotelReservationBackend.converter.RoomConverter;
import com.backend.hotelReservationBackend.dao.model.Hotel;
import com.backend.hotelReservationBackend.dao.model.Reservation;
import com.backend.hotelReservationBackend.dao.model.Review;
import com.backend.hotelReservationBackend.dao.model.Room;
import com.backend.hotelReservationBackend.dao.model.dto.ReviewDto;
import com.backend.hotelReservationBackend.dao.model.dto.RoomDto;
import com.backend.hotelReservationBackend.repository.ReservationRepository;
import com.backend.hotelReservationBackend.repository.ReviewRepository;
import com.backend.hotelReservationBackend.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final ReviewRepository reviewRepository;

    private final ReservationRepository reservationRepository;

    public RoomService(RoomRepository roomRepository, ReviewRepository reviewRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.reviewRepository = reviewRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomDto> getRoomsByHotelId(Long hotelId) {
        List<Room> roomList = roomRepository.findAllByHotelId(hotelId);
        return RoomConverter.modelListToDtoList(roomList);
    }

    public void bookRoom(Long roomNumber, Long hotelId, String email, String name) {

        Room room = roomRepository.findByHotelIdAndRoomNumber(hotelId, roomNumber);
        room.setAvailable(false);
        roomRepository.save(room);
        Reservation reservation = Reservation.builder()
                                    .email(email)
                                    .room(room)
                                    .name(name)
                                    .build();
        reservationRepository.save(reservation);
    }

    public void cancelReservation(Long roomNumber, Long hotelId, String email) {
        Room room = roomRepository.findByHotelIdAndRoomNumber(hotelId, roomNumber);
        room.setAvailable(true);
        roomRepository.save(room);

        Reservation reservation = reservationRepository.findByEmailAndRoomId(email, room.getId());
        reservationRepository.delete(reservation);
    }

    public void changeBookedRoom(Long oldRoomId, Long newRoomId) {
        Room oldRoom = roomRepository.findById(oldRoomId).orElseThrow(() -> new RuntimeException("Old room not found"));
        Room newRoom = roomRepository.findById(newRoomId).orElseThrow(() -> new RuntimeException("New room not found"));
        oldRoom.setAvailable(true);
        newRoom.setAvailable(false);
        roomRepository.save(oldRoom);
        roomRepository.save(newRoom);
    }

    public void addReview(ReviewDto reviewDto) {
        Room room = roomRepository.findById(reviewDto.getRoomId()).orElseThrow(() -> new RuntimeException("Room not found"));
        Review review = Review.builder()
                .grade(reviewDto.getGrade())
                .room(room)
                .build();
        reviewRepository.save(review);
    }

    public Room getRoomByNumber(Long roomNumber, Long hotelId) {
        return roomRepository.findByHotelIdAndRoomNumber(hotelId, roomNumber);
    }
}
