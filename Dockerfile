# Stage 1: Build the application
FROM maven:3.9.6-openjdk-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

# Stage 2: Run the application
FROM openjdk:21-alpine
WORKDIR /app
COPY --from=build /app/target/app-0.0.1-SNAPSHOT.jar ./app-aws.jar
EXPOSE 8080
CMD ["java", "-jar", "app-aws.jar"]