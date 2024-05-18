package com.backend.hotelReservationBackend.dao.model.dto;

import com.backend.hotelReservationBackend.dao.model.Room;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelJsonDto {
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    private List<RoomDto> rooms;
}
