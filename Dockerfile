FROM maven:3.9.6-eclipse-temurin-17 AS base
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

FROM base as development
CMD ["mvn", "spring-boot:run"]

FROM base as build
RUN mvn clean package

FROM eclipse-temurin:17-jre-jammy as production
EXPOSE 8081
COPY --from=build /app/target/service-products-*.jar /service-products.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/service-products.jar"]