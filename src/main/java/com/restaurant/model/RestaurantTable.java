package com.restaurant.model;

import java.time.LocalDateTime;

public class RestaurantTable {
    private Long tableId;
    private Long restaurantId;
    private int tableNumber;
    private int seatingCapacity;
    private String tableStatus; // AVAILABLE, OCCUPIED, RESERVED
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Default Constructor
    public RestaurantTable() {
        this.tableStatus = "AVAILABLE";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Parameterized Constructor
    public RestaurantTable(Long restaurantId, int tableNumber, int seatingCapacity) {
        this();
        this.restaurantId = restaurantId;
        this.tableNumber = tableNumber;
        this.seatingCapacity = seatingCapacity;
    }

    // Getters and Setters
    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(String tableStatus) {
        this.tableStatus = tableStatus;
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
    public boolean isAvailable() {
        return "AVAILABLE".equals(this.tableStatus);
    }

    public void markAsOccupied() {
        this.tableStatus = "OCCUPIED";
        this.updatedAt = LocalDateTime.now();
    }

    public void markAsReserved() {
        this.tableStatus = "RESERVED";
        this.updatedAt = LocalDateTime.now();
    }

    public void markAsAvailable() {
        this.tableStatus = "AVAILABLE";
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "RestaurantTable{" +
                "tableId=" + tableId +
                ", restaurantId=" + restaurantId +
                ", tableNumber=" + tableNumber +
                ", seatingCapacity=" + seatingCapacity +
                ", tableStatus='" + tableStatus + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
