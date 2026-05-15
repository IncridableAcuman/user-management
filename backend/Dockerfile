FROM maven:eclipse-temurin-21-alpine AS build
LABEL authors="izzatbek"
WORKDIR /app
COPY pom.xml ./
RUN mvn dependency go:offline
COPY src ./src
RUN mvn clean package -DskipTests
FROM eclipse-temurin-21-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]