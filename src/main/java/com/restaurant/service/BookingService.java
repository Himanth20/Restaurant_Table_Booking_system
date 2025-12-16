package com.restaurant.service;

import com.restaurant.model.Booking;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingService {
    private List<Booking> bookings = new ArrayList<>();
    private Long bookingCounter = 1L;

    // Create a new booking
    public Booking createBooking(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException("Booking cannot be null");
        }
        booking.setBookingId(bookingCounter++);
        bookings.add(booking);
        return booking;
    }

    // Get booking by ID
    public Optional<Booking> getBookingById(Long bookingId) {
        return bookings.stream()
                .filter(b -> b.getBookingId().equals(bookingId))
                .findFirst();
    }

    // Get all bookings for a user
    public List<Booking> getBookingsByUserId(Long userId) {
        List<Booking> userBookings = new ArrayList<>();
        for (Booking b : bookings) {
            if (b.getUserId().equals(userId)) {
                userBookings.add(b);
            }
        }
        return userBookings;
    }

    // Get all bookings for a restaurant
    public List<Booking> getBookingsByRestaurantId(Long restaurantId) {
        List<Booking> restaurantBookings = new ArrayList<>();
        for (Booking b : bookings) {
            if (b.getRestaurantId().equals(restaurantId)) {
                restaurantBookings.add(b);
            }
        }
        return restaurantBookings;
    }

    // Confirm a booking
    public void confirmBooking(Long bookingId) {
        getBookingById(bookingId).ifPresent(Booking::confirmBooking);
    }

    // Cancel a booking
    public void cancelBooking(Long bookingId) {
        getBookingById(bookingId).ifPresent(Booking::cancelBooking);
    }

    // Complete a booking
    public void completeBooking(Long bookingId) {
        getBookingById(bookingId).ifPresent(Booking::completeBooking);
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings);
    }

    // Delete a booking
    public boolean deleteBooking(Long bookingId) {
        return bookings.removeIf(b -> b.getBookingId().equals(bookingId));
    }
}
