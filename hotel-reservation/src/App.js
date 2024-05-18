import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HotelList from './components/HotelList';
import HotelDetails from './components/HotelDetails';
import BookingForm from './components/BookingForm';
import ManageReservation from './components/ManageReservation';

function App() {
  return (
    <Router>
      <div>
        <Routes>
          <Route path="/" element={<HotelList />} />
          <Route path="/hotel/:id" element={<HotelDetails />} />
          <Route path="/book/:hotelId/:roomId" element={<BookingForm />} />
          <Route path="/manage-reservation" element={<ManageReservation />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
