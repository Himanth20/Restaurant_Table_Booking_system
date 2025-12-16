package com.restaurant.model;

import java.time.LocalDateTime;

public class Booking {
    private Long bookingId;
    private Long userId;
    private Long restaurantId;
    private Long tableId;
    private LocalDateTime bookingDateTime;
    private int numberOfGuests;
    private String specialRequests;
    private String bookingStatus; // PENDING, CONFIRMED, CANCELLED, COMPLETED
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Default Constructor
    public Booking() {
        this.bookingStatus = "PENDING";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Parameterized Constructor
    public Booking(Long userId, Long restaurantId, Long tableId, 
                   LocalDateTime bookingDateTime, int numberOfGuests) {
        this();
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.tableId = tableId;
        this.bookingDateTime = bookingDateTime;
        this.numberOfGuests = numberOfGuests;
    }

    // Getters and Setters
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Business methods
    public void confirmBooking() {
        this.bookingStatus = "CONFIRMED";
        this.updatedAt = LocalDateTime.now();
    }

    public void cancelBooking() {
        this.bookingStatus = "CANCELLED";
        this.updatedAt = LocalDateTime.now();
    }

    public void completeBooking() {
        this.bookingStatus = "COMPLETED";
        this.updatedAt = LocalDateTime.now();
    }

    public boolean isPending() {
        return "PENDING".equals(this.bookingStatus);
    }

    public boolean isConfirmed() {
        return "CONFIRMED".equals(this.bookingStatus);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", userId=" + userId +
                ", restaurantId=" + restaurantId +
                ", tableId=" + tableId +
                ", bookingDateTime=" + bookingDateTime +
                ", numberOfGuests=" + numberOfGuests +
                ", specialRequests='" + specialRequests + '\'' +
                ", bookingStatus='" + bookingStatus + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
