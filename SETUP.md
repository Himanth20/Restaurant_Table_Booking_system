# Setup Instructions - Restaurant Table Booking System

## Prerequisites

### Required Software
- Java Development Kit (JDK) 17 or higher
- Maven 3.8.1 or higher
- MySQL 8.0 or higher
- Git
- Your favorite IDE (IntelliJ IDEA, VS Code, or Eclipse)

### Installation Steps

#### 1. Install Java

```bash
# macOS (using Homebrew)
brew install openjdk@17

# Windows (using Chocolatey)
choco install openjdk

# Linux (Ubuntu)
sudo apt update
sudo apt install openjdk-17-jdk
```

#### 2. Install Maven

```bash
# macOS
brew install maven

# Windows (using Chocolatey)
choco install maven

# Linux
sudo apt install maven
```

#### 3. Install MySQL

```bash
# macOS
brew install mysql
brew services start mysql

# Windows
# Download from https://dev.mysql.com/downloads/mysql/
# Or use Chocolatey: choco install mysql

# Linux
sudo apt install mysql-server
sudo systemctl start mysql
```

#### 4. Verify Installations

```bash
java -version
mvn -version
mysql --version
git --version
```

## Project Setup

### 1. Clone the Repository

```bash
git clone https://github.com/Himanth20/Restaurant_Table_Booking_system.git
cd Restaurant_Table_Booking_system
```

### 2. Create Database

```bash
mysql -u root -p

# In MySQL console:
CREATE DATABASE restaurant_booking_system;
USE restaurant_booking_system;

# Source the initial schema
SOURCE database/schema.sql;
```

### 3. Configure Backend

Create `backend/src/main/resources/application.properties`:

```properties
# Server Configuration
server.port=8080
server.servlet.context-path=/api

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/restaurant_booking_system
spring.datasource.username=root
spring.datasource.password=your_password_here
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.format_sql=true

# Logging
logging.level.root=INFO
logging.level.com.restaurant=DEBUG

# JWT Configuration
jwt.secret=your_jwt_secret_key_here_minimum_32_characters
jwt.expiration=86400000
```

### 4. Build Backend

```bash
cd backend
mvn clean package -DskipTests
```

### 5. Run Backend

```bash
# Using Maven
mvn spring-boot:run

# Or using JAR file
java -jar target/restaurant-booking-system-1.0.0.jar
```

The backend will be available at: `http://localhost:8080/api`

## Frontend Setup

### 1. Navigate to Frontend Directory

```bash
cd ../frontend
```

### 2. Configure API Endpoint

Edit `frontend/js/api.js`:

```javascript
const API_BASE_URL = 'http://localhost:8080/api';
```

### 3. Serve Frontend

**Option 1: Using Python**
```bash
python -m http.server 3000
# Or for Python 2
python -m SimpleHTTPServer 3000
```

**Option 2: Using Node.js (http-server)**
```bash
npm install -g http-server
http-server -p 3000
```

**Option 3: Using VS Code Live Server**
- Install Live Server extension in VS Code
- Right-click on `index.html` and select "Open with Live Server"

Frontend will be available at: `http://localhost:3000`

## Docker Setup (Optional)

### Build Docker Images

```bash
# Build backend image
cd backend
docker build -t restaurant-booking-backend .

# Return to root
cd ..
```

### Run with Docker Compose

```bash
docker-compose up -d
```

This will start:
- MySQL Database on port 3306
- Spring Boot Backend on port 8080
- Frontend on port 3000

## Database Schema

The database includes the following tables:

- `users` - User accounts and authentication
- `restaurants` - Restaurant information
- `tables` - Individual tables in restaurants
- `bookings` - Table reservations

For detailed schema, see `database/schema.sql`

## API Testing

### Using Postman

1. Import the Postman collection from `api/postman_collection.json`
2. Set the base URL to `http://localhost:8080/api`
3. Test endpoints

### Using cURL

```bash
# Register a new user
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john@example.com",
    "phone": "1234567890",
    "password": "password123"
  }'

# Login
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "john@example.com",
    "password": "password123"
  }'

# Get all restaurants
curl http://localhost:8080/api/restaurants
```

## Troubleshooting

### MySQL Connection Error
```
Could not connect to database
```
**Solution:** Ensure MySQL is running and credentials are correct in `application.properties`

### Port Already in Use
```
Address already in use
```
**Solution:** Change the port in `application.properties` or kill the process using the port

### Build Failures
```
mvn clean install
```
**Solution:** Clear Maven cache and rebuild

### CORS Issues
**Solution:** Frontend and backend are running on different ports. CORS is configured in the backend.

## Development Workflow

### Creating a Feature Branch
```bash
git checkout -b feature/your-feature-name
```

### Making Changes
```bash
# Make your changes
git add .
git commit -m "feat: description of changes"
git push origin feature/your-feature-name
```

### Creating a Pull Request
- Go to GitHub and create a PR to the main branch
- Ensure all tests pass
- Get code review approval
- Merge to main

## Next Steps

1. Review ARCHITECTURE.md for system design
2. Read DEPLOYMENT.md for production deployment
3. Check API documentation in `api/API_DOCS.md`
4. Run the application and test the features

## Support

For issues or questions, please create an issue on GitHub or contact the development team.
