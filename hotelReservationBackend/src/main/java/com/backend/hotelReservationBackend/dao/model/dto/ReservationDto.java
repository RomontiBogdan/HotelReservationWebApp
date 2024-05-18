package com.backend.hotelReservationBackend.dao.model.dto;

import com.backend.hotelReservationBackend.dao.model.Room;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationDto {
    private String email;
    private Long roomId;
}
