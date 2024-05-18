const API_BASE_URL = 'http://localhost:8080/hotelRooms';

const api = {
  getUserPosition: async () => {
    // Use Geolocation API or other methods to get user's position
    return { latitude: 46.770439, longitude: 23.591423 }; // Example position
  },
  getNearbyHotels: async (userPosition, radius) => {
    const response = await fetch(`${API_BASE_URL}/hotels/nearby?userLat=${userPosition.latitude}&userLong=${userPosition.longitude}&radius=${radius}`);
    return await response.json();
  },
  getHotelDetails: async (id) => {
    const response = await fetch(`${API_BASE_URL}/hotels/${id}`);
    return await response.json();
  },
  getRoomsByHotelId: async (hotelId) => {
    const response = await fetch(`${API_BASE_URL}/hotels/${hotelId}/rooms`);
    return await response.json();
  },
  getReservationByEmail: async (email) => {
    const response = await fetch(`${API_BASE_URL}/reservations?email=${email}`);
    return await response.json();
  },
  bookRoom: async (hotelId, roomId, email, name) => {
    await fetch(`${API_BASE_URL}/hotels/${hotelId}/rooms/${roomId}/book`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      body: new URLSearchParams({ email, name }),
    });
  },
  cancelReservation: async (hotelId, roomId, email) => {
    await fetch(`${API_BASE_URL}/hotels/${hotelId}/rooms/${roomId}/cancel`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      body: new URLSearchParams({ email }),
    });
  },
  changeBookedRoom: async (hotelId, roomId, newRoomId) => {
    await fetch(`${API_BASE_URL}/hotels/${hotelId}/rooms/${roomId}/change`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ newRoomId }),
    });
  },
  getRoomById: async (hotelId, roomId) => {
    const response = await fetch(`${API_BASE_URL}/hotels/${hotelId}/rooms/${roomId}`);
    return await response.json();
  },
  getHotelById: async (id) => {
    const response = await fetch(`${API_BASE_URL}/hotels/${id}`);
    return await response.json();
  },
};

export default api;
