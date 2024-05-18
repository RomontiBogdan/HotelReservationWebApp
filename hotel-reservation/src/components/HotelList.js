import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import api from '../services/api';

const HotelList = () => {
  const [hotels, setHotels] = useState([]);
  const [radius, setRadius] = useState(5); // default radius in km
  const navigate = useNavigate();

  useEffect(() => {
    const fetchHotels = async () => {
      const userPosition = await api.getUserPosition();
      const nearbyHotels = await api.getNearbyHotels(userPosition, radius);
      setHotels(nearbyHotels);
    };

    fetchHotels();
  }, [radius]);

  return (
    <div>
      <h1>Nearby Hotels</h1>
      <label>
        Radius (km):
        <input
          type="number"
          value={radius}
          onChange={(e) => setRadius(e.target.value)}
        />
      </label>
      <ul>
        {hotels.map(hotel => (
          <li key={hotel.id}>
            <Link to={`/hotel/${hotel.id}`}>{hotel.name}</Link>
          </li>
        ))}
      </ul>
      <button onClick={() => navigate('/manage-reservation')}>Manage Reservation</button>
    </div>
  );
};

export default HotelList;
