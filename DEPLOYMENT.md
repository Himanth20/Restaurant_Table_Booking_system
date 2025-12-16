# Restaurant Table Booking System - Deployment Guide

## Production Deployment Ready ✅

This is a **production-ready** Java Spring Boot application with complete Docker orchestration. Follow this guide to deploy the system.

---

## Prerequisites

### System Requirements
- **Docker Engine:** 20.10+
- **Docker Compose:** 1.29+
- **Git:** For cloning the repository
- **Disk Space:** Minimum 2GB free space
- **Memory:** Minimum 2GB RAM
- **Internet:** For downloading dependencies

### Software Versions
- Java: OpenJDK 11 (included in Docker image)
- MySQL: 8.0
- Maven: 3.8 (included in Docker build)
- Spring Boot: 2.x

---

## Quick Start - Docker Deployment

### 1. Clone the Repository
```bash
git clone https://github.com/Himanth20/Restaurant_Table_Booking_system.git
cd Restaurant_Table_Booking_system
```

### 2. Deploy with Docker Compose
```bash
# Build and start all services
docker-compose up -d

# Check service status
docker-compose ps
```

### 3. Verify Deployment
```bash
# Check application logs
docker-compose logs -f booking-app

# Check database health
docker-compose exec mysql-db mysqladmin ping -h localhost -u root -proot_password
```

### 4. Access the Application
- **API URL:** `http://localhost:8080/api`
- **Health Check:** `http://localhost:8080/api/health`
- **Booking Endpoints:** `http://localhost:8080/api/bookings`

---

## Local Development Setup

### Prerequisites
- Java JDK 11+
- Maven 3.8+
- MySQL 8.0+

### Steps

1. **Clone Repository**
```bash
git clone https://github.com/Himanth20/Restaurant_Table_Booking_system.git
cd Restaurant_Table_Booking_system
```

2. **Setup MySQL Database**
```bash
# Create database and user
MySQL -u root -p

CREATE DATABASE restaurant_booking;
CREATE USER 'app_user'@'localhost' IDENTIFIED BY 'app_password';
GRANT ALL PRIVILEGES ON restaurant_booking.* TO 'app_user'@'localhost';
FLUSH PRIVILEGES;
```

3. **Initialize Database Schema**
```bash
mysql -u app_user -p restaurant_booking < database/schema.sql
```

4. **Build Application**
```bash
mvn clean package
```

5. **Run Application**
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080/api`

---

## Production Deployment on Cloud Platforms

### AWS ECS (Recommended)
1. Push Docker image to ECR
2. Create ECS task definition
3. Create ECS service with ALB
4. Configure RDS MySQL database
5. Set environment variables for database credentials

### Google Cloud Run
1. Build Docker image: `docker build -t gcr.io/PROJECT_ID/booking-app .`
2. Push to GCR: `docker push gcr.io/PROJECT_ID/booking-app`
3. Deploy: `gcloud run deploy booking-app --image gcr.io/PROJECT_ID/booking-app --platform managed`

### Azure Container Instances
1. Create Azure Container Registry
2. Build and push image
3. Deploy container with MySQL connection

---

## Docker Services

### MySQL Database Service
- **Container:** `restaurant_booking_db`
- **Port:** 3306
- **Credentials:** 
  - Username: `app_user`
  - Password: `app_password`
  - Database: `restaurant_booking`

### Spring Boot Application Service
- **Container:** `restaurant_booking_app`
- **Port:** 8080
- **Health Check:** Enabled with 30s interval

---

## Environment Configuration

### Modify Database Credentials
Edit `docker-compose.yml`:
```yaml
environment:
  MYSQL_ROOT_PASSWORD: your_root_password
  MYSQL_PASSWORD: your_app_password
```

### Modify Application Port
Edit `docker-compose.yml`:
```yaml
ports:
  - "8080:8080"  # Change first 8080 to desired port
```

---

## Monitoring and Logs

### View Logs
```bash
# Application logs
docker-compose logs booking-app

# Database logs
docker-compose logs mysql-db

# Follow logs in real-time
docker-compose logs -f
```

### Health Checks
```bash
# Application health
curl http://localhost:8080/api/health

# Database connectivity
mysql -h localhost -u app_user -p -e "SELECT 1;"
```

---

## Maintenance

### Backup Database
```bash
docker exec restaurant_booking_db mysqldump -u app_user -p restaurant_booking > backup.sql
```

### Restore Database
```bash
docker exec -i restaurant_booking_db mysql -u app_user -p restaurant_booking < backup.sql
```

### Stop Services
```bash
docker-compose stop
```

### Restart Services
```bash
docker-compose restart
```

### Cleanup All
```bash
docker-compose down -v  # Removes containers and volumes
```

---

## Troubleshooting

### Port Already in Use
```bash
# Change port in docker-compose.yml or kill existing process
lsof -i :8080
kill -9 <PID>
```

### Database Connection Failed
```bash
# Verify MySQL is running
docker-compose ps mysql-db

# Check logs
docker-compose logs mysql-db

# Restart database
docker-compose restart mysql-db
```

### Application Crashes
```bash
# Check application logs
docker-compose logs --tail=100 booking-app

# Rebuild and restart
docker-compose down
docker-compose up -d --build
```

---

## Performance Tuning

### Database Connection Pool
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.hikari.maximum-pool-size=20
spring.datasource.hikari.minimum-idle=10
```

### JPA Batch Processing
```properties
spring.jpa.properties.hibernate.jdbc.batch_size=50
spring.jpa.properties.hibernate.order_inserts=true
spring.jpa.properties.hibernate.order_updates=true
```

---

## Security Best Practices

✅ **Implemented:**
- Docker container isolation
- Environment-based configuration
- Database authentication
- Health check monitoring

**Recommended additions:**
- SSL/TLS certificates for HTTPS
- API rate limiting
- Input validation and sanitization
- JWT authentication
- CORS configuration

---

## API Documentation

See `ARCHITECTURE.md` for complete API endpoint documentation.

### Example Requests

**Create Booking:**
```bash
curl -X POST http://localhost:8080/api/bookings \
  -H "Content-Type: application/json" \
  -d '{
    "userId": 1,
    "restaurantId": 1,
    "tableId": 1,
    "bookingDateTime": "2024-12-25T19:00:00",
    "numberOfGuests": 4
  }'
```

**Get Booking:**
```bash
curl http://localhost:8080/api/bookings/1
```

---

## Support and Issues

For issues or questions:
1. Check the troubleshooting section
2. Review application logs
3. Verify database connectivity
4. Check system resources (CPU, memory, disk)

---

## Version Information
- **Application:** Restaurant Table Booking System v1.0.0
- **Last Updated:** December 2024
- **Status:** Production Ready ✅
