import React, { useState, useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import api from '../services/api';

const HotelDetails = () => {
  const { id } = useParams();
  const [hotel, setHotel] = useState(null);
  const [rooms, setRooms] = useState([]);

  useEffect(() => {
    const fetchHotelDetails = async () => {
      const hotelDetails = await api.getHotelDetails(id);
      setHotel(hotelDetails);
      const hotelRooms = await api.getRoomsByHotelId(id);
      setRooms(hotelRooms);
    };

    fetchHotelDetails();
  }, [id]);

  if (!hotel) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <h1>{hotel.name}</h1>
      <h2>Rooms</h2>
      <ul>
        {rooms.map(room => (
          <li key={room.roomNumber}>
            {`Room ${room.roomNumber} - ${room.type} - $${room.price} - `}
            {room.available ? (
              <Link to={`/book/${hotel.id}/${room.roomNumber}`}>Book</Link>
            ) : (
              'Not Available'
            )}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default HotelDetails;
