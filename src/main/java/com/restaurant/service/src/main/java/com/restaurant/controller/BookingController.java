package com.restaurant.controller;

import com.restaurant.model.Booking;
import com.restaurant.service.BookingService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class BookingController {
    private BookingService bookingService = new BookingService();

    // Create booking endpoint
    public Booking createBooking(Long userId, Long restaurantId, Long tableId, 
                                String bookingDateTime, int numberOfGuests) {
        try {
            Booking booking = new Booking(
                userId,
                restaurantId,
                tableId,
                LocalDateTime.parse(bookingDateTime),
                numberOfGuests
            );
            return bookingService.createBooking(booking);
        } catch (Exception e) {
            System.out.println("Error creating booking: " + e.getMessage());
            return null;
        }
    }

    // Get booking by ID endpoint
    public Booking getBookingById(Long bookingId) {
        Optional<Booking> booking = bookingService.getBookingById(bookingId);
        return booking.orElse(null);
    }

    // Get all bookings for a user endpoint
    public List<Booking> getUserBookings(Long userId) {
        return bookingService.getBookingsByUserId(userId);
    }

    // Get all bookings for a restaurant endpoint
    public List<Booking> getRestaurantBookings(Long restaurantId) {
        return bookingService.getBookingsByRestaurantId(restaurantId);
    }

    // Confirm booking endpoint
    public void confirmBooking(Long bookingId) {
        bookingService.confirmBooking(bookingId);
    }

    // Cancel booking endpoint
    public void cancelBooking(Long bookingId) {
        bookingService.cancelBooking(bookingId);
    }

    // Complete booking endpoint
    public void completeBooking(Long bookingId) {
        bookingService.completeBooking(bookingId);
    }

    // Get all bookings endpoint
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // Delete booking endpoint
    public boolean deleteBooking(Long bookingId) {
        return bookingService.deleteBooking(bookingId);
    }
}
