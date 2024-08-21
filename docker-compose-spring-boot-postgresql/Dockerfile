FROM amazoncorretto:21-alpine-jdk AS builder

COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradlew .
COPY gradle ./gradle
COPY src ./src

RUN chmod +x ./gradlew
RUN ./gradlew build -x test

FROM amazoncorretto:21-alpine-jdk

COPY --from=builder /build/libs/docker-compose-spring-boot-postgresql-0.0.1-SNAPSHOT.jar ./spring-boot.jar

EXPOSE 8080

CMD ["java", "-jar", "spring-boot.jar"]
