FROM gradle:7.6.1-jdk17 AS build
WORKDIR /home/gradle/src
COPY gradlew ./
COPY settings.gradle ./
COPY build.gradle ./
COPY gradle ./gradle
COPY src ./src
RUN ./gradlew clean
RUN ./gradlew bootJar
# App
FROM openjdk:17
EXPOSE 8080
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/todolist-0.0.1.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]