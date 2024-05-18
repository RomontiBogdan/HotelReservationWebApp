package com.backend.hotelReservationBackend.converter;

import com.backend.hotelReservationBackend.dao.model.Review;
import com.backend.hotelReservationBackend.dao.model.Room;
import com.backend.hotelReservationBackend.dao.model.dto.ReviewDto;
import com.backend.hotelReservationBackend.dao.model.dto.RoomDto;

import java.util.List;

public class ReviewConverter {
    public static ReviewDto modelToDto(Review review) {
        return ReviewDto.builder()
                .id(review.getId())
                .grade(review.getGrade())
                .roomId(review.getRoom().getId())
                .build();
    }

    public static List<ReviewDto> modelListToDtoList(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewConverter::modelToDto)
                .toList();
    }
}
