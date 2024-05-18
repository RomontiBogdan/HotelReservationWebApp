import React, { useState } from 'react';
import { useParams, useLocation, useNavigate } from 'react-router-dom';
import api from '../services/api';

const ReservationDetails = () => {
  const { hotelId, roomId } = useParams();
  const location = useLocation();
  const email = location.state?.email;
  const [review, setReview] = useState('');
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  const handleCancel = async () => {
    try {
      await api.cancelReservation(hotelId, roomId, email);
      navigate('/');
    } catch (err) {
      setError(err.message);
    }
  };

  const handleReviewSubmit = async (e) => {
    e.preventDefault();
    try {
      await api.submitReview(hotelId, roomId, { review });
      navigate('/');
    } catch (err) {
      setError(err.message);
    }
  };

  return (
    <div>
      <h1>Manage Your Reservation</h1>
      {error && <p style={{ color: 'red' }}>{error}</p>}
      <button onClick={handleCancel}>Cancel Reservation</button>
      <form onSubmit={handleReviewSubmit}>
        <label>
          Review:
          <textarea
            value={review}
            onChange={(e) => setReview(e.target.value)}
            required
          />
        </label>
        <button type="submit">Submit Review</button>
      </form>
    </div>
  );
};

export default ReservationDetails;
