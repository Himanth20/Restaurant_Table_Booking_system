# Multi-stage build: Build stage
FROM maven:3.8-openjdk-11 as builder

WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:11-jre-alpine
WORKDIR /app

# Copy jar from builder
COPY --from=builder /app/target/*.jar app.jar

# Copy database schema
COPY database/schema.sql /app/

# Expose port
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
  CMD curl -f http://localhost:8080/api/health || exit 1

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
