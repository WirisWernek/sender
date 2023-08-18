FROM maven:3.8.5-openjdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar
ARG POSTGRES_SERVER=localhost
ARG POSTGRES_USER=postgres
ARG POSTGRES_PASSWORD=password
ARG GMAIL_USERNAME=username
ARG GMAIL_PASSWORD=password
EXPOSE 8080
ENTRYPOINT java -jar app.jar