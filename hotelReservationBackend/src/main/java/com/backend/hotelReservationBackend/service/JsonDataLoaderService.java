package com.backend.hotelReservationBackend.service;

import com.backend.hotelReservationBackend.converter.RoomConverter;
import com.backend.hotelReservationBackend.dao.model.Hotel;
import com.backend.hotelReservationBackend.dao.model.Room;
import com.backend.hotelReservationBackend.dao.model.dto.HotelJsonDto;
import com.backend.hotelReservationBackend.dao.model.dto.RoomDto;
import com.backend.hotelReservationBackend.repository.HotelRepository;
import com.backend.hotelReservationBackend.repository.RoomRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Service
public class JsonDataLoaderService {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    public JsonDataLoaderService(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

//    @PostConstruct
    public void loadDataFromJson() throws IOException {
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("hotels.json")) {
            ObjectMapper mapper = new ObjectMapper();
            HotelJsonDto[] hotelsJson = mapper.readValue(in, HotelJsonDto[].class);
            List<HotelJsonDto> hotelsList = Arrays.asList(hotelsJson);

            for(HotelJsonDto hotelJson : hotelsList){
                Hotel hotel = Hotel.builder()
                        .id(hotelJson.getId())
                        .name(hotelJson.getName())
                        .latitude(hotelJson.getLatitude())
                        .longitude(hotelJson.getLongitude())
                        .build();
                hotelRepository.save(hotel);

                for(RoomDto roomDto : hotelJson.getRooms()){
                    Room room = Room.builder()
                                    .roomNumber(roomDto.getRoomNumber())
                                    .type(roomDto.getType())
                                    .price(roomDto.getPrice())
                                    .isAvailable(roomDto.isAvailable())
                                    .hotel(hotel)
                                    .build();
                    roomRepository.save(room);
                }
            }
            System.out.println("Data loaded successfully.");
            // Process the hotelsList as needed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
