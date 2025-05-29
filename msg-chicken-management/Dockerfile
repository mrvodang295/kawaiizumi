FROM maven:3.8.8-eclipse-temurin-17
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
CMD ["java", "-jar", "target/msg-chicken-management-0.0.1-SNAPSHOT.jar"]
