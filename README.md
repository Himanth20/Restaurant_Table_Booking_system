# Restaurant Table Booking System

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java Version](https://img.shields.io/badge/Java-17+-blue.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)](https://www.mysql.com/)

A modern, full-featured restaurant table booking system built with Java Spring Boot backend, HTML/CSS/JavaScript frontend, and MySQL database.

## 🎯 Project Overview

This project is a complete conversion from a PHP/XAMPP-based system to a modern Java-based web application. It provides a comprehensive solution for restaurants to manage table reservations, handle customer bookings, and streamline operations.

**Old Stack (Deprecated):**
- PHP backend
- XAMPP server
- HTML/CSS frontend

**New Stack (Current):**
- ✅ Java 17+ with Spring Boot 3.x backend
- ✅ REST API architecture
- ✅ HTML5/CSS3 responsive frontend
- ✅ MySQL 8.0+ database
- ✅ Docker support
- ✅ Cloud deployment ready

## ✨ Features

### User Features
- 👤 **User Authentication**: Secure login and registration
- 📅 **Table Booking**: Easy-to-use reservation system
- 👁️ **Booking Management**: View, modify, and cancel bookings
- 🔍 **Restaurant Search**: Find and filter restaurants
- 💬 **Special Requests**: Add special dining requirements
- 📱 **Responsive Design**: Works on desktop, tablet, and mobile

### Admin Features
- 🍽️ **Restaurant Management**: Add, edit, delete restaurants
- 📊 **Booking Analytics**: View booking statistics and trends
- 👥 **User Management**: Manage customer accounts
- ⏰ **Availability Management**: Set table availability and capacity
- 📋 **Reports**: Generate booking and revenue reports

## 🛠️ Technology Stack

### Backend
- **Framework**: Spring Boot 3.x
- **Language**: Java 17
- **Build Tool**: Maven
- **Database**: MySQL 8.0+
- **ORM**: Hibernate/JPA
- **Security**: Spring Security with JWT
- **API**: RESTful Web Services

### Frontend
- **Markup**: HTML5
- **Styling**: CSS3 (Flexbox, Grid, Media Queries)
- **Interactivity**: Vanilla JavaScript (ES6+)
- **HTTP Client**: Fetch API
- **Responsive**: Mobile-first design

### DevOps
- **Containerization**: Docker
- **Orchestration**: Docker Compose
- **CI/CD**: GitHub Actions
- **Deployment**: AWS/Heroku/DigitalOcean

## 📋 Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK) 17 or higher
- Maven 3.8.1 or higher  
- MySQL 8.0 or higher
- Git
- Docker & Docker Compose (optional)

## 🚀 Quick Start

### 1. Clone the Repository

```bash
git clone https://github.com/Himanth20/Restaurant_Table_Booking_system.git
cd Restaurant_Table_Booking_system
```

### 2. Setup Database

```bash
mysql -u root -p < database/schema.sql
```

### 3. Configure Backend

```bash
cd backend
cp src/main/resources/application.properties.example src/main/resources/application.properties
# Edit application.properties with your database credentials
```

### 4. Build & Run Backend

```bash
mvn clean package
mvn spring-boot:run
```

Backend runs on: `http://localhost:8080/api`

### 5. Run Frontend

```bash
cd ../frontend
python -m http.server 3000
```

Frontend runs on: `http://localhost:3000`

## 📚 Documentation

- **[ARCHITECTURE.md](ARCHITECTURE.md)** - System design and project structure
- **[SETUP.md](SETUP.md)** - Detailed setup instructions
- **[API Documentation](docs/API.md)** - REST API endpoints and examples
- **[Database Schema](database/schema.sql)** - Database tables and relationships

## 🐳 Docker Setup

### Using Docker Compose

```bash
docker-compose up -d
```

This will start:
- MySQL on port 3306
- Backend API on port 8080  
- Frontend on port 3000

## 📦 Project Structure

```
Restaurant-Table-Booking-system/
├── backend/                    # Java Spring Boot backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/restaurant/
│   │   │   │   ├── controller/    # REST controllers
│   │   │   │   ├── service/       # Business logic
│   │   │   │   ├── repository/    # Data access
│   │   │   │   ├── model/         # Entity classes
│   │   │   │   └── dto/           # Data transfer objects
│   │   │   └── resources/
│   │   └── test/
│   ├── pom.xml
│   └── Dockerfile
├── frontend/                   # HTML/CSS/JS frontend
│   ├── index.html
│   ├── css/
│   ├── js/
│   ├── pages/
│   └── images/
├── database/                   # Database setup
│   └── schema.sql
├── docs/                       # Documentation
├── docker-compose.yml
├── ARCHITECTURE.md
├── SETUP.md
└── README.md
```

## 🔌 API Endpoints

### Authentication
- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - User login
- `POST /api/auth/logout` - User logout

### Restaurants
- `GET /api/restaurants` - Get all restaurants
- `GET /api/restaurants/{id}` - Get restaurant details
- `POST /api/restaurants` - Create restaurant (admin)
- `PUT /api/restaurants/{id}` - Update restaurant (admin)
- `DELETE /api/restaurants/{id}` - Delete restaurant (admin)

### Bookings
- `POST /api/bookings` - Create booking
- `GET /api/bookings/{id}` - Get booking details
- `GET /api/bookings/user/{userId}` - Get user's bookings
- `PUT /api/bookings/{id}` - Update booking
- `DELETE /api/bookings/{id}` - Cancel booking
- `GET /api/bookings/restaurant/{restaurantId}/availability` - Check availability

For detailed API documentation, see [API.md](docs/API.md)

## 🧪 Testing

### Unit Tests
```bash
cd backend
mvn test
```

### Integration Tests
```bash
mvn verify
```

## 📝 Database Schema

The system uses the following main tables:

- **users** - User accounts and authentication
- **restaurants** - Restaurant information and details
- **restaurant_tables** - Individual tables in restaurants
- **bookings** - Table reservations

See [schema.sql](database/schema.sql) for complete schema.

## 🚢 Deployment

### Deploy to Heroku

```bash
heroku login
heroku create your-app-name
git push heroku main
```

### Deploy to AWS

See [DEPLOYMENT.md](docs/DEPLOYMENT.md) for detailed AWS deployment instructions.

### Deploy to DigitalOcean

See [DEPLOYMENT.md](docs/DEPLOYMENT.md) for DigitalOcean App Platform deployment.

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Himanth Sai** - Initial work
- GitHub: [@Himanth20](https://github.com/Himanth20)

## 🙏 Acknowledgments

- Spring Boot documentation and community
- MySQL documentation
- Web development best practices
- All contributors and supporters

## 📞 Support

For support, email himanth@example.com or open an issue on GitHub.

## 🗂️ Additional Resources

- [Java Spring Boot Tutorial](https://spring.io/guides/gs/spring-boot/)
- [REST API Best Practices](https://restfulapi.net/)
- [MySQL Tutorial](https://dev.mysql.com/doc/)
- [HTML/CSS/JS Tutorial](https://developer.mozilla.org/en-US/)

---

**Made with ❤️ by Himanth Sai**
