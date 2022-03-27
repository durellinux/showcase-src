FROM maven:3.8.4-openjdk-11 as builder

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package -DskipTests=true

FROM openjdk:11

COPY --from=builder target/showcase-feature-flag-service-spring.jar .
ENTRYPOINT ["java", "-jar", "showcase-feature-flag-service-spring.jar"]
