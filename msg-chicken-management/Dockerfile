FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests || mvn clean package -DskipTests
CMD ["java", "-jar", "target/msg-chicken-management-0.0.1-SNAPSHOT.jar"]
