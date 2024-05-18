package com.backend.hotelReservationBackend.dao.model.dto;

import com.backend.hotelReservationBackend.dao.model.Room;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewDto {
    private Long id;
    private String reviewText;
    private double grade;
    private Long roomId;
}
