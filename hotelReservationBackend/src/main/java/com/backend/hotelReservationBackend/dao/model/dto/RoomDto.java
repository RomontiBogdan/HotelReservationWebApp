package com.backend.hotelReservationBackend.dao.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomDto implements Serializable {
    private Long id;
    private int roomNumber;
    private int type;
    private double price;
    private boolean isAvailable;
}
