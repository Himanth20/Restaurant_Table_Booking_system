-- Create users table
CREATE TABLE users (
    userId BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phoneNumber VARCHAR(20),
    password VARCHAR(255) NOT NULL,
    userType VARCHAR(20) DEFAULT 'CUSTOMER',
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create restaurants table
CREATE TABLE restaurants (
    restaurantId BIGINT PRIMARY KEY AUTO_INCREMENT,
    restaurantName VARCHAR(150) NOT NULL,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(100),
    state VARCHAR(100),
    zipCode VARCHAR(10),
    phoneNumber VARCHAR(20),
    email VARCHAR(100),
    cuisine VARCHAR(100),
    averageRating DECIMAL(3,2) DEFAULT 0,
    totalTables INT DEFAULT 0,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create restaurant_tables table
CREATE TABLE restaurant_tables (
    tableId BIGINT PRIMARY KEY AUTO_INCREMENT,
    restaurantId BIGINT NOT NULL,
    tableNumber INT NOT NULL,
    seatingCapacity INT NOT NULL,
    tableStatus VARCHAR(20) DEFAULT 'AVAILABLE',
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (restaurantId) REFERENCES restaurants(restaurantId)
);

-- Create bookings table
CREATE TABLE bookings (
    bookingId BIGINT PRIMARY KEY AUTO_INCREMENT,
    userId BIGINT NOT NULL,
    restaurantId BIGINT NOT NULL,
    tableId BIGINT NOT NULL,
    bookingDateTime DATETIME NOT NULL,
    numberOfGuests INT NOT NULL,
    specialRequests VARCHAR(500),
    bookingStatus VARCHAR(20) DEFAULT 'PENDING',
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (userId) REFERENCES users(userId),
    FOREIGN KEY (restaurantId) REFERENCES restaurants(restaurantId),
    FOREIGN KEY (tableId) REFERENCES restaurant_tables(tableId),
    INDEX idx_user_booking (userId),
    INDEX idx_restaurant_booking (restaurantId),
    INDEX idx_booking_status (bookingStatus)
);

-- Create indexes for better query performance
CREATE INDEX idx_user_email ON users(email);
CREATE INDEX idx_restaurant_city ON restaurants(city);
CREATE INDEX idx_table_restaurant ON restaurant_tables(restaurantId);
CREATE INDEX idx_booking_datetime ON bookings(bookingDateTime);
