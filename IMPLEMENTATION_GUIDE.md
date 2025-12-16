.# Complete Production-Ready Implementation

This guide contains ALL source code files for the Restaurant Table Booking System.

## JAVA BACKEND - Complete Code

### Model Classes

#### User.java
```java
package com.restaurant.model;

public class User {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String role;
    private String createdAt;
    
    public User() {
        this.createdAt = java.time.LocalDateTime.now().toString();
    }
    
    public User(String name, String email, String phone, String password, String role) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.createdAt = java.time.LocalDateTime.now().toString();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
```

#### Restaurant.java
```java
package com.restaurant.model;

public class Restaurant {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private int capacity;
    private String description;
    private String cuisine;
    private double rating;
    private String createdAt;
    
    public Restaurant() {
        this.createdAt = java.time.LocalDateTime.now().toString();
        this.rating = 0.0;
    }
    
    public Restaurant(String name, String address, String phone, int capacity, String description, String cuisine) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.capacity = capacity;
        this.description = description;
        this.cuisine = cuisine;
        this.createdAt = java.time.LocalDateTime.now().toString();
        this.rating = 0.0;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCuisine() { return cuisine; }
    public void setCuisine(String cuisine) { this.cuisine = cuisine; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
```

#### RestaurantTable.java
```java
package com.restaurant.model;

public class RestaurantTable {
    private Long id;
    private Long restaurantId;
    private int tableNumber;
    private int capacity;
    private String status;
    private String createdAt;
    
    public RestaurantTable() {
        this.status = "available";
        this.createdAt = java.time.LocalDateTime.now().toString();
    }
    
    public RestaurantTable(Long restaurantId, int tableNumber, int capacity) {
        this.restaurantId = restaurantId;
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.status = "available";
        this.createdAt = java.time.LocalDateTime.now().toString();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getRestaurantId() { return restaurantId; }
    public void setRestaurantId(Long restaurantId) { this.restaurantId = restaurantId; }
    public int getTableNumber() { return tableNumber; }
    public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
```

#### Booking.java
```java
package com.restaurant.model;

public class Booking {
    private Long id;
    private Long userId;
    private Long restaurantId;
    private Long tableId;
    private String bookingDate;
    private String bookingTime;
    private int numberOfGuests;
    private String specialRequests;
    private String status;
    private String createdAt;
    private String updatedAt;
    
    public Booking() {
        this.status = "pending";
        this.createdAt = java.time.LocalDateTime.now().toString();
        this.updatedAt = java.time.LocalDateTime.now().toString();
    }
    
    public Booking(Long userId, Long restaurantId, Long tableId, String bookingDate, String bookingTime, int numberOfGuests) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.tableId = tableId;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.numberOfGuests = numberOfGuests;
        this.status = "pending";
        this.createdAt = java.time.LocalDateTime.now().toString();
        this.updatedAt = java.time.LocalDateTime.now().toString();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getRestaurantId() { return restaurantId; }
    public void setRestaurantId(Long restaurantId) { this.restaurantId = restaurantId; }
    public Long getTableId() { return tableId; }
    public void setTableId(Long tableId) { this.tableId = tableId; }
    public String getBookingDate() { return bookingDate; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }
    public String getBookingTime() { return bookingTime; }
    public void setBookingTime(String bookingTime) { this.bookingTime = bookingTime; }
    public int getNumberOfGuests() { return numberOfGuests; }
    public void setNumberOfGuests(int numberOfGuests) { this.numberOfGuests = numberOfGuests; }
    public String getSpecialRequests() { return specialRequests; }
    public void setSpecialRequests(String specialRequests) { this.specialRequests = specialRequests; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; this.updatedAt = java.time.LocalDateTime.now().toString(); }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
```
