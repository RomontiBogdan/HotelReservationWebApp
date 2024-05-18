import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import api from '../services/api';

const ManageReservation = () => {
  const [email, setEmail] = useState('');
  const [reservations, setReservations] = useState([]);
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  const fetchReservation = async () => {
    try {
      const reservationsResponse = await api.getReservationByEmail(email);
      setReservations(reservationsResponse);
    } catch (err) {
      setError(err.message);
    }
  };

  const handleReservationClick = (reservation) => {
    navigate(`/reservation/${reservation.roomId}`, { state: { email } });
  };

  return (
    <div>
      <h1>Manage Your Reservations</h1>
      <label>
        Email:
        <input
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
      </label>
      <button onClick={fetchReservation}>Find Reservations</button>
      
      {error && <p style={{ color: 'red' }}>{error}</p>}
      
      <ul>
        {reservations.map(reservation => (
          <li key={reservation.roomId}>
            <p>Email: {reservation.email}</p>
            <p>Room ID: {reservation.roomId}</p>
            <button onClick={() => handleReservationClick(reservation)}>Manage Reservation</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ManageReservation;
