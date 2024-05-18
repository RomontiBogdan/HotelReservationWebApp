package com.backend.hotelReservationBackend.dao.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hotels")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;
}
