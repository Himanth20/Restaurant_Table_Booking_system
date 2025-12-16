# Restaurant Table Booking System - Modern Architecture

## Project Overview
Conversion from PHP/XAMPP to modern Java + HTML/CSS + SQL Stack

## Technology Stack

### Backend
- **Framework**: Spring Boot 3.x
- **Language**: Java 17+
- **Build Tool**: Maven
- **Server**: Apache Tomcat (embedded)

### Frontend
- **HTML5**: Semantic markup
- **CSS3**: Responsive design with flexbox/grid
- **JavaScript**: Vanilla JS for interactivity (no dependencies)
- **UI Components**: Custom components, Bootstrap CDN (optional)

### Database
- **DBMS**: MySQL 8.0+
- **ORM**: Hibernate/JPA
- **Migration**: Flyway

### Deployment
- **Container**: Docker
- **Platform**: Cloud (AWS, Heroku, or DigitalOcean)
- **CI/CD**: GitHub Actions

## Project Structure

```
Restaurant-Table-Booking-System/
|
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/restaurant/
│   │   │   │   ├── controller/
│   │   │   │   │   ├── BookingController.java
│   │   │   │   │   ├── RestaurantController.java
│   │   │   │   │   └── UserController.java
│   │   │   │   ├── service/
│   │   │   │   │   ├── BookingService.java
│   │   │   │   │   ├── RestaurantService.java
│   │   │   │   │   └── UserService.java
│   │   │   │   ├── repository/
│   │   │   │   │   ├── BookingRepository.java
│   │   │   │   │   ├── RestaurantRepository.java
│   │   │   │   │   └── UserRepository.java
│   │   │   │   ├── model/
│   │   │   │   │   ├── Booking.java
│   │   │   │   │   ├── Restaurant.java
│   │   │   │   │   └── User.java
│   │   │   │   ├── dto/
│   │   │   │   │   ├── BookingDTO.java
│   │   │   │   │   ├── RestaurantDTO.java
│   │   │   │   │   └── UserDTO.java
│   │   │   │   └── RestaurantBookingApplication.java
│   │   │   └── resources/
│   │   │       ├── application.properties
│   │   │       └── db/migration/
│   │   │           └── V1__initial_schema.sql
│   │   └── test/
│   ├── pom.xml
│   └── Dockerfile
│
├── frontend/
│   ├── index.html
│   ├── css/
│   │   ├── style.css
│   │   ├── responsive.css
│   │   └── components.css
│   ├── js/
│   │   ├── app.js
│   │   ├── api.js
│   │   ├── bookings.js
│   │   └── utils.js
│   ├── pages/
│   │   ├── booking.html
│   │   ├── restaurants.html
│   │   ├── admin.html
│   │   └── profile.html
│   └── images/
│
├── database/
│   └── schema.sql
│
├── docker-compose.yml
├── .github/
│   └── workflows/
│       └── deploy.yml
├── README.md
└── SETUP.md
```

## Database Schema

### Users Table
- id (PK)
- name
- email (unique)
- phone
- password (hashed)
- role (customer/admin)
- created_at

### Restaurants Table
- id (PK)
- name
- address
- phone
- capacity
- description
- created_at

### Tables Table
- id (PK)
- restaurant_id (FK)
- table_number
- capacity
- status (available/reserved)

### Bookings Table
- id (PK)
- user_id (FK)
- restaurant_id (FK)
- table_id (FK)
- booking_date
- booking_time
- number_of_guests
- special_requests
- status (pending/confirmed/cancelled)
- created_at

## API Endpoints

### Authentication
- POST /api/auth/register
- POST /api/auth/login
- POST /api/auth/logout

### Restaurants
- GET /api/restaurants
- GET /api/restaurants/{id}
- POST /api/restaurants (admin)
- PUT /api/restaurants/{id} (admin)
- DELETE /api/restaurants/{id} (admin)

### Bookings
- POST /api/bookings
- GET /api/bookings/{id}
- GET /api/bookings/user/{userId}
- PUT /api/bookings/{id}
- DELETE /api/bookings/{id}
- GET /api/bookings/restaurant/{restaurantId}/availability

## Setup Instructions

See SETUP.md for detailed setup instructions.

## Deployment

See DEPLOYMENT.md for deployment instructions.
